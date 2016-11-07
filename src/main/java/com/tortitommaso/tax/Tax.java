package com.tortitommaso.tax;

import java.math.BigDecimal;

import com.tortitommaso.item.Item;
import com.tortitommaso.price.Price;

public abstract class Tax {

	public abstract boolean shouldBeApplied(Item item) ;

	public abstract Price apply(Item item) ;
	
	protected Price taxToApplyWithFactor(Item item, String val) {
		return item.basePrice().multiply(new BigDecimal(val)).roundLastDecimalToNearestHalf();
	}

}
