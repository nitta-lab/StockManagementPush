package resources;
import values.Item;

import java.util.*;

public class Arrival {
	private Available available;
	private Stock stock;
	private Item value;

	public Arrival(Available available, Stock stock) {
		this.available = available;
		this.stock = stock;
	}

	public void arrive(int num, String name) {
		this.value = new Item(name, num);
		Map<String, Integer> stock = this.stock.getValue();
		this.available.updateArrival(new Item(value), stock);
	}

	public Item getValue() {
		return new Item(value);
	}
}