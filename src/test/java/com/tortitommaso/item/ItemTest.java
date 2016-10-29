package item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import item.Item;

import org.junit.Test;

import price.Price;

public class ItemTest {

	@Test
	public void fromStringToItem() {
		Item item =  Item.fromString("2 music CD at 0.11");
		assertEquals(2, item.quantity());
		assertEquals(new Price("0.11"), item.price());
		assertEquals("music CD", item.name());
	}
	
	@Test
	public void isImported() {
		Item item = Item.fromString("1 imported box of chocolates at 12.49");
		assertTrue(item.isImported());

		item = Item.fromString("1 box of chocolates at 12.49");
		assertFalse(item.isImported());
	}
	
	@Test
	public void importedSpecialItemCase() {
		Item item = Item.fromString("1 box of imported chocolates at 11.25");
		assertTrue(item.isImported());
		assertTrue(item.isSpecial());
	}
	
	@Test
	public void isSpecial() {
		Item item = Item.fromString("1 box of chocolates at 12.49");
		assertTrue(item.isSpecial());
		
		item = Item.fromString("1 chocolate bar at 0.85");
		assertTrue(item.isSpecial());
		
		item = Item.fromString("1 packet of headache pills at 12.49");
		assertTrue(item.isSpecial());
		
		item = Item.fromString("1 book at 12.49");
		assertTrue(item.isSpecial());
		
		item = Item.fromString("1 imported book at 12.49");
		assertTrue(item.isSpecial());
		
		item = Item.fromString("1 anythingelse at 12.49");
		assertFalse(item.isSpecial());
	}
	
}
