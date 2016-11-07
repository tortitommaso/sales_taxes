package com.tortitommaso.tax;

import com.tortitommaso.item.Item;
import com.tortitommaso.price.Price;

public class DefaultTax extends Tax {

	@Override
	public boolean shouldBeApplied(Item item) {
		return !item.isSpecial();
	}

	@Override
	public Price apply(Item item) {
		return taxToApplyWithFactor(item, "0.1");
	}

}
