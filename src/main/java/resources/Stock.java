package resources;
import values.ItemHandling;

import java.util.*;

public class Stock {
	private Map<String, Integer> value = new HashMap<String, Integer>();

	public void updateHandling(ItemHandling itemHandling) {
		this.value.put(itemHandling.getName(), itemHandling.getStockNum());
	}

	public Map<String, Integer> getValue() {
		return new HashMap<>(value);
	}
}