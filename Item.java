package values;

public class Item {
    private String name;
    private int num;

    public Item(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public Item(Item other) {
        this.name = other.name;
        this.num = other.num;
    }

    public Item(ItemHandling value) {
    	this.name = value.getName();
        this.num = value.getShippingNum();
	}

	public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }
}
