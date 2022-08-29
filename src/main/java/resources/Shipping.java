package resources;
import values.Item;
import values.ItemHandling;

public class Shipping {
	//Item value;
	Handling handling;
	
	public Shipping(Handling handling) {
		this.handling = handling;
	}


	//public void updateHandling(ItemHandling handling) {
	//	value = new Item(handling.getName(), handling.getShippingNum());
	//}

	public Item getValue() {
		

		ItemHandling itemhandling = handling.getValue();

		//return value;
		return new Item(itemhandling.getName(), itemhandling.getShippingNum());
	}
}