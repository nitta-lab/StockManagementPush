package resources;
import values.Item;
import values.ItemHandling;

import java.util.*;

public class Shipping {
	Handling handling;

	Shipping(Handling argHandling) {
		this.handling = argHandling;
	}

	public Item getValue() {
		ItemHandling itemHandling = handling.getValue();
		Item value = new Item(itemHandling.getName(), itemHandling.getShippingNum());
		return value;
	}
}