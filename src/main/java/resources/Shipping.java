package resources;
import values.Item;

public class Shipping {
	Handling handling;
	
	public Shipping(Handling handling) {
		this.handling = handling;
	}

	public Item getValue() {
		return new Item(handling.getValue().getName(), handling.getValue().getShippingNum());
	}
}