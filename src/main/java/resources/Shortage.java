package resources;
import values.Item;

import java.util.*;

public class Shortage {
	private Item request;
	private Item available;
	private Map<String, Integer> value = new HashMap<String, Integer>();

	public void updateRequest(Item request, Map<String, Integer> stock) {
		this.request = request;
		Map<String, Integer> temp_if0;
		int temp_get0;
		if (stock.get(request.getName()) != null) {
			temp_get0 = stock.get(request.getName());
		} else {
			temp_get0 = 0;
		}
		if ((temp_get0>=request.getNum())) {
			temp_if0 = this.value;
		} else {
			int temp_get1;
			if (this.value.get(request.getName()) != null) {
				temp_get1 = this.value.get(request.getName());
			} else {
				temp_get1 = 0;
			}
			this.value.put(request.getName(),(temp_get1 + request.getNum()));
			temp_if0 = this.value;
		}
		value = temp_if0;
	}

	public void updateAvailable(Item available) {
		this.available = available;
		Map<String, Integer> temp_if1;
		int temp_get2;
		if (this.value.get(available.getName()) != null) {
			temp_get2 = this.value.get(available.getName());
		} else {
			temp_get2 = 0;
		}
		if ((available.getNum() >= temp_get2)) {
			this.value.put(available.getName(), 0);
			temp_if1 = this.value;
		} else {
			temp_if1 = this.value;
		}
		value = temp_if1;
	}

	public Map<String, Integer> getValue() {
		return new HashMap<>(value);
	}
}