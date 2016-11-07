package com.tortitommaso.tax;

import java.util.Arrays;
import java.util.List;

import com.tortitommaso.item.Item;
import com.tortitommaso.price.Price;

public class TaxEvaluator {

	List<Tax> taxList = (List<Tax>) Arrays.asList(new ImportedTax(), new DefaultTax() );
	
	public Price taxToApplyFor(Item item) {
		Price taxToApply = Price.ZERO;
		for (Tax tax : taxList) {
			if (tax.shouldBeApplied(item)) {
				taxToApply = taxToApply.add(tax.apply(item));
			}
		}
		return item.basePrice().add(taxToApply);
	}

}
