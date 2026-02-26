import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;


public class Main {


    public static File readFile(String filename) {
        return new File(filename);
    }

    // This function is responsible to transform the 4 bytes into an integer type.
    // It has to be a positive number.
    public static long readUint32LE(RandomAccessFile raf) throws IOException {
        byte[] bytes = new byte[4];
        raf.readFully(bytes);

        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        return buffer.getInt() & 0xFFFFFFFFL;
    }

    public static String readGBK128(RandomAccessFile raf) throws IOException {
        byte[] bytes = new byte[128];     // allocate 128 bytes
        raf.readFully(bytes);             // read exactly 128 bytes

        return new String(bytes, Charset.forName("GBK"));
    }

    public static long readLinuxTimeStamp(RandomAccessFile raf, long startOffset) throws IOException {
        raf.seek(startOffset);
        return readUint32LE(raf);
    }

    public static long readTotalItems(RandomAccessFile raf, long startOffset) throws IOException {
        raf.seek(startOffset);
        return readUint32LE(raf);
    }

    public static void readSingleItem(RandomAccessFile raf, long startOffset) throws IOException {
        // OffSet Starter
        raf.seek(startOffset);

        //
        // A single item is composed by various small chunks, that's defined by default using 1288 bytes.
        //

        System.out.println("Offset place: " + raf.getFilePointer());

        // SHOP ID = INT 4 bytes
        long shopid = readUint32LE(raf);
        System.out.println(shopid);
        System.out.println("Offset place: " + raf.getFilePointer());

        // SUB CATEGORY INDEX = INT 4 bytes
        long subcategoryid = readUint32LE(raf);
        System.out.println(subcategoryid);
        System.out.println("Offset place: " + raf.getFilePointer());


        // UPDATES 4 BYTES, IDK why, but it does.
        raf.skipBytes(4);
        System.out.println("Offset place: " + raf.getFilePointer());
        // SurfacePath 128 bytes - GBK (Guóbiāo Kuòzhǎn) is a character encoding used for writing Simplified Chinese.
        // That's probably used because of the .dds files in the source file structure
        String surfacePath = readGBK128(raf);
        System.out.println(surfacePath);
        System.out.println("Offset place: " + raf.getFilePointer());

        // Item ID - 4 bytes int
        long itemid = readUint32LE(raf);
        System.out.println(itemid);
        System.out.println("Offset place: " + raf.getFilePointer());

        // Item Amount - 4 bytes int
        long itemamount = readUint32LE(raf);
        System.out.println(itemamount);
        System.out.println("Offset place: " + raf.getFilePointer());

        // Sales Option 1 - 4 bytes int
        long salesoption1 = readUint32LE(raf);
        System.out.println(salesoption1);
        System.out.println("Offset place: " + raf.getFilePointer());
        // Sales Option 2 - 4 bytes int
        long salesoption2 = readUint32LE(raf);
        System.out.println(salesoption2);
        System.out.println("Offset place: " + raf.getFilePointer());
        // Sales Option 3 - 4 bytes int
        long salesoption3 = readUint32LE(raf);
        System.out.println(salesoption3);
        System.out.println("Offset place: " + raf.getFilePointer());
    }


    public static void main(String[] args) throws IOException {

        File file = readFile("gshop.data");

        // Read sample data
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {

            // Ensure we start at the beginning
            long startOffset = 0;
            System.out.println("Offset place: " + raf.getFilePointer());

            long linuxTimeStamp = readLinuxTimeStamp(raf, startOffset);
            System.out.println(linuxTimeStamp);
            System.out.println("Offset place: " + raf.getFilePointer());

            long totalItems = readTotalItems(raf, raf.getFilePointer());
            System.out.println(totalItems);

            readSingleItem(raf, raf.getFilePointer());


        }


    }


}

