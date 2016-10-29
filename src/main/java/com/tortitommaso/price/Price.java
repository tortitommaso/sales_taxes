package price;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class Price {
	
	private static final MathContext DEFAULT_CONTEXT = new MathContext(4, RoundingMode.HALF_UP);

	private static final MathContext CEILING_CONTEXT = new MathContext(2, RoundingMode.CEILING);

	public static final Price ZERO = new Price(new BigDecimal("0.00"), DEFAULT_CONTEXT);

	private static final BigInteger HALF_FACTOR = new BigInteger("5");

	private final MathContext mathContext;

	private final BigDecimal value;

	public Price(String priceString) {
		this(new BigDecimal(priceString, DEFAULT_CONTEXT), DEFAULT_CONTEXT);
	}

	private Price(BigDecimal bigDecimal, MathContext mathContext) {
		value = bigDecimal;
		this.mathContext = mathContext;
	}

	public Price add(Price price) {
		return new Price(value.add(price.value, mathContext), mathContext);
	}
	
	public Price subtract(Price price) {
		return new Price(value.subtract(price.value, mathContext), mathContext);
	}

	public Price multiply(BigDecimal  quantity) {
		return new Price(value.multiply(quantity, mathContext), mathContext);
	}


	public Price roundLastDecimalToNearestHalf() {
		BigDecimal precisionFactor = BigDecimal.ONE.divide(new BigDecimal(HALF_FACTOR, value.scale()));

		BigDecimal roundedValue = ((value.multiply(precisionFactor))
				.round(CEILING_CONTEXT)).divide(precisionFactor);
		return new Price(roundedValue, mathContext);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public String toString() {
		return value.toString();
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}

		if (other == this) {
			return true;
		}

		if (!(other instanceof Price)) {
			return false;
		}

		Price otherPrice = (Price) other;

		return value.compareTo(otherPrice.value) == 0;
	}


}
