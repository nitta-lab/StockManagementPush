package resources;
import values.Item;
import values.ItemHandling;

public class Shipping {
	Item value;
	
	public Shipping() {
	}


	public void updateHandling(ItemHandling handling) {
		value = new Item(handling.getName(), handling.getShippingNum());
	}

	public Item getValue() {
		return value;
	}
}