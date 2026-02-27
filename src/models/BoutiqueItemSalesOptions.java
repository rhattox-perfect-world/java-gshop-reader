package models;

public class BoutiqueItemSalesOptions {

    public BoutiqueItemSalesOptions() {
    }

    long price;
    long value;
    long expireDate;

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(long expireDate) {
        this.expireDate = expireDate;
    }
}
