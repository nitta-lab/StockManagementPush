import java.util.Map;

import org.junit.jupiter.api.Test;
import resources.StockManagement;
import values.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

	@Test
	public void test() {
		StockManagement stockMan = new StockManagement();

		// 商品Aが10個，商品Bが10個，倉庫に搬入される
		stockMan.arrive(10, "A");
		System.out.println("Arrive A: 10");
		stockMan.arrive(20, "B");
		System.out.println("Arrive B: 20");
		
		Map<String, Integer> stock1 = stockMan.getStock();
		Map<String, Integer> shortage1 = stockMan.getShortage();
		Item shipping1 = stockMan.getShipping();
		System.out.println("stock:");
		System.out.println("A: " + stock1.get("A"));
		System.out.println("B: " + stock1.get("B"));
		assertEquals((int)stock1.get("A"), 10);
		assertEquals((int)stock1.get("B"), 20);
		System.out.println("shotage:");
		System.out.println("A: " + shortage1.get("A"));
		System.out.println("B: " + shortage1.get("B"));
		assertEquals((int)shortage1.get("A"), 0);
		assertEquals((int)shortage1.get("B"), 0);
		System.out.println("shipping:");
		if (shipping1 != null) System.out.println(shipping1.getName() +": " + shipping1.getNum());

		// 商品Aを5個，出庫依頼される
		stockMan.req(5, "A");	
		System.out.println("Request A: 5");
		
		Map<String, Integer> stock2 = stockMan.getStock();
		Map<String, Integer> shortage2 = stockMan.getShortage();
		Item shipping2 = stockMan.getShipping();
		System.out.println("stock:");
		System.out.println("A: " + stock2.get("A"));
		System.out.println("B: " + stock2.get("B"));
		assertEquals((int)stock2.get("A"), 5);
		assertEquals((int)stock2.get("B"), 20);
		System.out.println("shotage:");
		System.out.println("A: " + shortage2.get("A"));
		System.out.println("B: " + shortage2.get("B"));
		assertEquals((int)shortage2.get("A"), 0);
		assertEquals((int)shortage2.get("B"), 0);
		// 商品Aが5個，出庫される
		System.out.println("shipping:");
		if (shipping2 != null) {
			System.out.println(shipping2.getName() +": " + shipping2.getNum());
			assertEquals(shipping2.getName(), "A");
			assertEquals(shipping2.getNum(), 5);
		}

		// 商品Aを10個，出庫依頼される
		stockMan.req(10, "A");
		System.out.println("Request A: 10");
		
		Map<String, Integer> stock3 = stockMan.getStock();
		Map<String, Integer> shortage3 = stockMan.getShortage();
		Item shipping3 = stockMan.getShipping();
		System.out.println("stock:");
		System.out.println("A: " + stock3.get("A"));
		System.out.println("B: " + stock3.get("B"));
		assertEquals((int)stock3.get("A"), 5);
		assertEquals((int)stock3.get("B"), 20);
		// Aの在庫が不足しているので，在庫不足リストに商品Aが10個登録される
		System.out.println("shotage:");
		System.out.println("A: " + shortage3.get("A"));
		System.out.println("B: " + shortage3.get("B"));
		assertEquals((int)shortage3.get("A"), 10);
		assertEquals((int)shortage3.get("B"), 0);
		System.out.println("shipping:");
		if (shipping3 != null) System.out.println(shipping3.getName() +": " + shipping3.getNum());

		// 商品Aが10個，倉庫に搬入される
		stockMan.arrive(10, "A");
		System.out.println("Arrive A: 10");
		
		Map<String, Integer> stock4 = stockMan.getStock();
		Map<String, Integer> shortage4 = stockMan.getShortage();
		Item shipping4 = stockMan.getShipping();
		System.out.println("stock:");
		System.out.println("A: " + stock4.get("A"));
		System.out.println("B: " + stock4.get("B"));
		assertEquals((int)stock4.get("A"), 5);
		assertEquals((int)stock4.get("B"), 20);
		System.out.println("shotage:");
		System.out.println("A: " + shortage4.get("A"));
		System.out.println("B: " + shortage4.get("B"));
		assertEquals((int)shortage4.get("A"), 0);
		assertEquals((int)shortage4.get("B"), 0);
		// Aの在庫不足が解消されたので，商品Aが10個出庫される
		System.out.println("shipping:");
		if (shipping4 != null) {
			System.out.println(shipping4.getName() +": " + shipping4.getNum());
			assertEquals(shipping4.getName(), "A");
			assertEquals(shipping4.getNum(), 10);
		}
	}
 
}
