package resources;
import values.Item;
import values.ItemHandling;

public class Shipping {
	private Handling handling ;

	public Shipping(Handling handling) {
		this.handling = handling;
	}
	

	public Item getValue() {
		ItemHandling handlingVal = handling.getValue();
		return new Item(handlingVal.getName(), handlingVal.getShippingNum());
	}
}