package tax;

import item.Item;
import price.Price;

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
