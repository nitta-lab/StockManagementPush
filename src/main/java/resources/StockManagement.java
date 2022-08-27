package resources;
import java.util.Map;

import values.Item;
import values.ItemHandling;

public class StockManagement {
	private Stock stock;
	private Handling handling;
	private Shortage shortage;
	private Available available;
	private Arrival arrival;
	private Shipping shipping;
	private Request request;

	public StockManagement() {
		stock = new Stock();
		handling = new Handling(stock);
		shipping = new Shipping(handling);
		shortage = new Shortage();
		available = new Available(shortage, handling);
		arrival = new Arrival(available,stock);
		request = new Request(shortage, handling,stock);
	}

	public void arrive(int num, String item) {
		this.arrival.arrive(num, item);
	}

	public void req(int num, String item) {
		this.request.req(num, item);
	}

	public Item getRequest() {
		return request.getValue();
	}

	public Item getShipping() {
		return shipping.getValue();
	}

	public Item getArrival() {
		return arrival.getValue();
	}

	public Map<String, Integer> getShortage() {
		return shortage.getValue();
	}

	public Item getAvailable() {
		return available.getValue();
	}

	public ItemHandling getHandling() {
		return handling.getValue();
	}

	public Map<String, Integer> getStock() {
		return stock.getValue();
	}
}