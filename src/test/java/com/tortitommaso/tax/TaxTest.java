package tax;

import static org.junit.Assert.assertEquals;
import item.Item;

import org.junit.Test;

import price.Price;

public class TaxTest {

	@Test
	public void basicTax() {
		Item item = Item.fromString("1 music CD at 14.99");
		assertEquals(new Price("16.49"), new TaxEvaluator().taxToApplyFor(item));
		
		item = Item.fromString("1 bottle of perfume at 18.99");
		assertEquals(new Price("20.89"), new TaxEvaluator().taxToApplyFor(item));
	}
	
	@Test
	public void noTaxForSpecialItems() {
		Item item = Item.fromString("1 book at 12.49");
		assertEquals(new Price("12.49"), new TaxEvaluator().taxToApplyFor(item));
		
		item = Item.fromString("1 box of chocolates at 12.49");
		assertEquals(new Price("12.49"), new TaxEvaluator().taxToApplyFor(item));
		
		item = Item.fromString("1 chocolate bar at 0.85");
		assertEquals(new Price("0.85"), new TaxEvaluator().taxToApplyFor(item));
		
		item = Item.fromString("1 packet of headache pills at 9.75");
		assertEquals(new Price("9.75"), new TaxEvaluator().taxToApplyFor(item));
	}
	
	@Test
	public void taxForImportedItem() {
		Item item = Item.fromString("1 imported box of chocolates at 10.00");
		assertEquals(new Price("10.50"), new TaxEvaluator().taxToApplyFor(item));
	}
	
	@Test
	public void mixedCase() {
		Item item = Item.fromString("1 imported bottle of perfume at 47.50");
		assertEquals(new Price("54.65"), new TaxEvaluator().taxToApplyFor(item));
		
		item = Item.fromString("1 imported bottle of perfume at 27.99");
		assertEquals(new Price("32.19"), new TaxEvaluator().taxToApplyFor(item));
		
		item = Item.fromString("1 box of imported chocolates at 11.25");
		assertEquals(new Price("11.85"), new TaxEvaluator().taxToApplyFor(item));
	}
}
