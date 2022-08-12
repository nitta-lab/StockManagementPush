package values;

public class ItemHandling {
    private String name;
    private int shippingNum;
    private int stockNum;

    public ItemHandling(String name, int shippingNum, int stockNum) {
        this.name = name;
        this.shippingNum = shippingNum;
        this.stockNum = stockNum;
    }

    public ItemHandling(ItemHandling other) {
        this.name = other.name;
        this.shippingNum = other.shippingNum;
        this.stockNum = other.stockNum;
    }

    public String getName() {
        return name;
    }

    public int getShippingNum() {
        return shippingNum;
    }

    public int getStockNum() {
        return stockNum;
    }
}
