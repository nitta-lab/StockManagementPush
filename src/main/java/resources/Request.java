package resources;
import values.Item;

import java.util.*;

public class Request {
	private Shortage shortage;
	private Handling handling;
	private Stock stock;
	private Item value;

	public Request(Shortage shortage, Handling handling, Stock stock) {
		this.shortage = shortage;
		this.handling = handling;
		this.stock = stock;
	}

	public void req(int num, String name) {
		this.value = new Item(name, num);
		Map<String, Integer> stock = this.stock.getValue();
		this.shortage.updateRequest(new Item(value), stock);
		this.handling.updateRequest(new Item(value), stock);
	}

	public Item getValue() {
		return new Item(value);
	}
}