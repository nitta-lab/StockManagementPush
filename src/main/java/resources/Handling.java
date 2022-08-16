package resources;
import values.Item;
import values.ItemHandling;

import java.util.*;

public class Handling {
	private Item available;
	private Item request;
	private Stock stock;
	Shipping shipping;
	private ItemHandling value;

	public Handling(Stock stock) {
		this.stock = stock;
	}

	public void updateAvailable(Item available, Map<String, Integer> shortage) {
		this.available = available;
		ItemHandling temp_if2;
		int temp_get4;
		if (shortage.get(available.getName()) != null) {
			temp_get4 = shortage.get(available.getName());
		} else {
			temp_get4 = 0;
		}
		if ((available.getNum() >= temp_get4)) {
			int temp_get5;
			if (shortage.get(available.getName()) != null) {
				temp_get5 = shortage.get(available.getName());
			} else {
				temp_get5 = 0;
			}
			int temp_get6;
			if (shortage.get(available.getName()) != null) {
				temp_get6 = shortage.get(available.getName());
			} else {
				temp_get6 = 0;
			}
			temp_if2 = new ItemHandling(available.getName(), temp_get5, available.getNum() - temp_get6);
		} else {
			temp_if2 = new ItemHandling(available.getName(), 0, available.getNum());
		}
		value = temp_if2;
		this.stock.updateHandling(new ItemHandling(value));
	}

	public void updateRequest(Item request, Map<String, Integer> stock) {
		this.request = request;
		ItemHandling temp_if3;
		int temp_get7;
		if (stock.get(request.getName()) != null) {
			temp_get7 = stock.get(request.getName());
		} else {
			temp_get7 = 0;
		}
		if ((temp_get7>=request.getNum())) {
			int temp_get8;
		if (stock.get(request.getName()) != null) {
			temp_get8 = stock.get(request.getName());
		} else {
			temp_get8 = 0;
		}
			temp_if3 = new ItemHandling(request.getName(), request.getNum(), temp_get8 - request.getNum());
		} else {
			int temp_get9;
		if (stock.get(request.getName()) != null) {
			temp_get9 = stock.get(request.getName());
		} else {
			temp_get9 = 0;
		}
			temp_if3 = new ItemHandling(request.getName(), 0, temp_get9);
		}
		value = temp_if3;
		this.stock.updateHandling(new ItemHandling(value));
	}

	public ItemHandling getValue() {
		return new ItemHandling(value);
	}
}