import models.Boutique;
import utils.ReadBytes;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Main {


    public static File readFile(String filename) {
        return new File(filename);
    }


    public static void readSingleItem(RandomAccessFile raf, long startOffset) throws IOException {
        // OffSet Starter
        raf.seek(startOffset);

        // SHOP ID = INT 4 bytes
        long shopid = ReadBytes.readInt(raf);

        // SUB CATEGORY INDEX = INT 4 bytes
        long subcategoryid = ReadBytes.readInt(raf);


        // UPDATES 4 BYTES, IDK why, but it does.
        raf.skipBytes(4);

        // SurfacePath 128 bytes - GBK (Guóbiāo Kuòzhǎn) is a character encoding used for writing Simplified Chinese.
        // That's probably used because of the .dds files in the source file structure
        String surfacePath = ReadBytes.readSurfacePath(raf);


        // Item ID - 4 bytes int
        long itemid = ReadBytes.readInt(raf);


        // Item Amount - 4 bytes int
        long itemamount = ReadBytes.readInt(raf);


        // Sales Option 1 - 4 bytes int
        long salesoptionprice1 = ReadBytes.readInt(raf);

        long salesoptionvalue1 = ReadBytes.readInt(raf);

        long salesoptionexpiredate1 = ReadBytes.readInt(raf);


        // Sales Option 1 - 4 bytes int
        long salesoptionprice2 = ReadBytes.readInt(raf);

        long salesoptionvalue2 = ReadBytes.readInt(raf);

        long salesoptionexpiredate2 = ReadBytes.readInt(raf);


        // Sales Option 3 - 4 bytes int
        long salesoptionprice3 = ReadBytes.readInt(raf);

        long salesoptionvalue3 = ReadBytes.readInt(raf);

        long salesoptionexpiredate3 = ReadBytes.readInt(raf);


        // Sales Option unk - 4 bytes int
        long salesoptionunk1 = ReadBytes.readInt(raf);

        long salesoptionunk2 = ReadBytes.readInt(raf);

        long salesoptionunk3 = ReadBytes.readInt(raf);


        long salesoptionstatus = ReadBytes.readInt(raf);


        // UPDATES 4 BYTES, IDK why, but it does.
        raf.skipBytes(76);

        String itemDescription = ReadBytes.readItemDescription(raf);


        String itemName = ReadBytes.readItemName(raf);


    }


    public static void debugLog(RandomAccessFile raf, String logString, long logStringValue) throws IOException {
        System.out.println("-- Offset: " + raf.getFilePointer() + " -- " + logString + logStringValue);
    }

    public static void main(String[] args) throws IOException {

        File file = readFile("gshop.data");

        Boutique boutique;
        boutique = new Boutique();

        // Read sample data
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {

            // Ensure we start at the beginning
            long startOffset = 0;

            // Universal Time Stamp
            long boutiqueUniversalTimestamp = boutique.readLinuxTimeStamp(raf, startOffset);
            boutique.setUniversalTimestamp(boutiqueUniversalTimestamp);
            debugLog(raf, "Linux Universal timestamp: ", boutique.getUniversalTimestamp());

            // Total Items
            long totalItems = boutique.readTotalItems(raf, raf.getFilePointer());
            boutique.setTotalItem(totalItems);
            debugLog(raf, "Gshop Total Items: ", boutique.getTotalItem());

            readSingleItem(raf, raf.getFilePointer());


        }


    }


}

