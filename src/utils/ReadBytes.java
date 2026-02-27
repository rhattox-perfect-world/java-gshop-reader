package utils;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ReadBytes {
    
    // This function is responsible to transform the 4 bytes into an integer type.
    // It has to be a positive number.
    public static long readInt(RandomAccessFile raf) throws IOException {
        byte[] bytes = new byte[4];
        raf.readFully(bytes);
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        return buffer.getInt() & 0xFFFFFFFFL;
    }

    // It allocates 128 bytes to read the surface path, It has to use the GBK because of the chinese path
    public static String readSurfacePath(RandomAccessFile raf) throws IOException {
        byte[] bytes = new byte[128];
        raf.readFully(bytes);
        return new String(bytes, Charset.forName("GBK"));
    }

    // It allocates 1024 bytes to read the item description, It has to use the UTF16LE
    public static String readItemDescription(RandomAccessFile raf) throws IOException {
        byte[] bytes = new byte[1024];
        raf.readFully(bytes);
        return new String(bytes, StandardCharsets.UTF_16LE);
    }

    // It allocates 64 bytes to read the item name, It has to use the UTF16LE
    public static String readItemName(RandomAccessFile raf) throws IOException {
        byte[] bytes = new byte[64];
        raf.readFully(bytes);
        return new String(bytes, StandardCharsets.UTF_16LE);
    }

}
