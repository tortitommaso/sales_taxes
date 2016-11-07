package com.tortitommaso.main;

import java.util.ArrayList;
import java.util.List;

import com.tortitommaso.item.Item;
import com.tortitommaso.price.Price;

public class Receipt {
	
	List<Item> items = new ArrayList<Item>();
	
	public void input(String input) {
		items.add( Item.fromString(input)) ;
	}

	public String output() {
		String result = "";
		Price totalWithTax = Price.ZERO;
		Price totalWithoutTax = Price.ZERO;
		for (Item item : items) {
			result += item.output();
			totalWithTax = totalWithTax.add(item.totalWithTax());
			totalWithoutTax = totalWithoutTax.add(item.basePrice());
		}
		result += "Sales Taxes: " + totalWithTax.subtract(totalWithoutTax);
		result += "\nTotal: " + totalWithTax;
		return result;
	}

}
