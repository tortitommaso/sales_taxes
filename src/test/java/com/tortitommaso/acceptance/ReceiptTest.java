package com.tortitommaso.acceptance;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tortitommaso.main.Receipt;

public class ReceiptTest {

	@Test
	public void firstInput() {
		Receipt receipt = new Receipt();
		receipt.input("1 book at 12.49");
		receipt.input("1 music CD at 14.99");
		receipt.input("1 chocolate bar at 0.85");

		assertEquals("1 book: 12.49\n"
				+ "1 music CD: 16.49\n"
				+ "1 chocolate bar: 0.85\n"
				+ "Sales Taxes: 1.50\n" 
				+ "Total: 29.83", receipt.output());
	}
	
	@Test
	public void secondInput() {
		Receipt receipt = new Receipt();
		receipt.input("1 imported box of chocolates at 10.00");
		receipt.input("1 imported bottle of perfume at 47.50");

		assertEquals("1 imported box of chocolates: 10.50\n"
				+ "1 imported bottle of perfume: 54.65\n"
				+ "Sales Taxes: 7.65\n" 
				+ "Total: 65.15", receipt.output());
	}
	
	@Test
	public void thirdInput() {
		Receipt receipt = new Receipt();
		receipt.input("1 imported bottle of perfume at 27.99");
		receipt.input("1 bottle of perfume at 18.99");
		receipt.input("1 packet of headache pills at 9.75");
		receipt.input("1 imported box of chocolates at 11.25");

		assertEquals("1 imported bottle of perfume: 32.19\n"
				+ "1 bottle of perfume: 20.89\n"
				+ "1 packet of headache pills: 9.75\n"
				+ "1 imported box of chocolates: 11.85\n"
				+ "Sales Taxes: 6.70\n" 
				+ "Total: 74.68", receipt.output());
	}
}
