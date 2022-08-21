package resources;
import values.Item;
import values.ItemHandling;

public class Shipping {
	Handling handling;

	public Shipping(Handling handling) {
		this.handling = handling;
	}

	public Item getValue() {
		ItemHandling itemHandling = handling.getValue();
		return new Item(itemHandling.getName(), itemHandling.getShippingNum()) ;
	}
}