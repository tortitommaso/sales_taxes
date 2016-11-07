package com.tortitommaso.item;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tortitommaso.price.Price;
import com.tortitommaso.tax.TaxEvaluator;

public class Item {

	public static Item fromString(String rawString) {
		Pattern r = Pattern.compile("(\\d+)(.*)at(.*)");
		Matcher m = r.matcher(rawString);
		if (m.find()) {
			int quantity= Integer.parseInt(m.group(1));
			String name = m.group(2).trim();
			String priceAsString = m.group(3).trim();
			Price price = new Price(priceAsString);
			return new Item(quantity, price, name);
		}
		return new Item(0, Price.ZERO, "");
	}

	private int quantity;
	private Price price;
	private String name;

	public Item(int quantity, Price price, String name) {
		this.quantity = quantity;
		this.price = price;
		this.name = name;
	}

	public int quantity() {
		return quantity;
	}

	public Price price() {
		return price;
	}

	public String name() {
		return name;
	}

	public boolean isSpecial() {
		String normalizedName = name().replace("imported", "").trim().replace("  ", " ");
		return Arrays.asList("book", "box of chocolates", "chocolate bar", "packet of headache pills").contains(normalizedName);
	}

	public boolean isImported() {
		return name().contains("imported");
	}

	public String output() {
		return String.format("%d %s: %s\n", quantity, name, totalWithTax().toString());
	}

	public Price totalWithTax() {
		return new TaxEvaluator().taxToApplyFor(this);
	}

	public Price basePrice() {
		return price.multiply(new BigDecimal(quantity));
	}

}
