package models;

import utils.ReadBytes;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Boutique {

    public Boutique() {
    }

    private long universalTimestamp;
    private long totalItem;
    private BoutiqueItem boutiqueItem;
    private BoutiqueItemSalesOptions boutiqueItemSalesOptions;

    public long getUniversalTimestamp() {
        return universalTimestamp;
    }

    public long getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(long totalItem) {
        this.totalItem = totalItem;
    }

    public void setUniversalTimestamp(long universalTimestamp) {
        this.universalTimestamp = universalTimestamp;
    }


    // Functions
    public long readLinuxTimeStamp(RandomAccessFile raf, long startOffset) throws IOException {
        raf.seek(startOffset);
        return ReadBytes.readInt(raf);
    }

    public long readTotalItems(RandomAccessFile raf, long startOffset) throws IOException {
        raf.seek(startOffset);
        return ReadBytes.readInt(raf);
    }

}
