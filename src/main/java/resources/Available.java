package resources;
import values.Item;

import java.util.*;

public class Available {
	private Shortage shortage;
	private Handling handling;
	private Item value;

	public Available(Shortage shortage, Handling handling) {
		this.shortage = shortage;
		this.handling = handling;
	}

	public void updateArrival(Item arrival, Map<String, Integer> stock) {
		Map<String, Integer> shortage = this.shortage.getValue();
		int temp_get3;
		if (stock.get(arrival.getName()) != null) {
			temp_get3 = stock.get(arrival.getName());
		} else {
			temp_get3 = 0;
		}
		value = new Item(arrival.getName(), (arrival.getNum() + temp_get3));
		this.shortage.updateAvailable(new Item(value));
		this.handling.updateAvailable(new Item(value), shortage);
	}

	public Item getValue() {
		return new Item(value);
	}
}