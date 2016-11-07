package com.tortitommaso.tax;

import com.tortitommaso.item.Item;
import com.tortitommaso.price.Price;

public class ImportedTax extends Tax {

	@Override
	public boolean shouldBeApplied(Item item) {
		return item.isImported();
	}

	@Override
	public Price apply(Item item) {
		return taxToApplyWithFactor(item, "0.05");
	}

}
