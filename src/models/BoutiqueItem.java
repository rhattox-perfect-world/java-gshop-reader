package models;

public class BoutiqueItem {
    public BoutiqueItem() {
    }

    long shopId;
    long subcategoryId;
    long itemId;
    long itemAmount;
    BoutiqueItemSalesOptions boutiqueItemSalesOptions;
    long saleOptionsStatus;
    String itemDescription;
    String itemName;

    public long getShopId() {
        return shopId;
    }

    public long getSubcategoryId() {
        return subcategoryId;
    }

    public long getItemId() {
        return itemId;
    }

    public long getItemAmount() {
        return itemAmount;
    }

    public BoutiqueItemSalesOptions getBoutiqueItemSalesOptions() {
        return boutiqueItemSalesOptions;
    }

    public long getSaleOptionsStatus() {
        return saleOptionsStatus;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemName() {
        return itemName;
    }
    
    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public void setSubcategoryId(long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public void setItemAmount(long itemAmount) {
        this.itemAmount = itemAmount;
    }

    public void setBoutiqueItemSalesOptions(BoutiqueItemSalesOptions boutiqueItemSalesOptions) {
        this.boutiqueItemSalesOptions = boutiqueItemSalesOptions;
    }

    public void setSaleOptionsStatus(long saleOptionsStatus) {
        this.saleOptionsStatus = saleOptionsStatus;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
