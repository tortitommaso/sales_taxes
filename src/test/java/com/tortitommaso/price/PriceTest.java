package price;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import price.Price;

public class PriceTest {

    @Test
    public void pricesShouldBeEqual() {
        Price price = new Price("10");
        Price equalPrice = new Price("10.00");

        assertEquals(price, equalPrice);
    }

    @Test
    public void shouldAddAndRemovePricesWithDefaultRounding() {
        Price price = new Price("10");
        Price priceToAdd = new Price("5.349368");

        Price totalPrice = price.add(priceToAdd);

        assertEquals(new Price("15.35"), totalPrice);
        
        assertEquals(price, totalPrice.subtract(priceToAdd));
    }

    @Test
    public void shouldMultiplyPricesWithDefaultRounding() {
        Price price = new Price("2.39137");

        Price totalPrice = price.multiply(new BigDecimal("2.1"));

        assertEquals(new Price("5.021"), totalPrice);
    }

    @Test
    public void shouldRoundLastDecimalToNearestHalf() {
        Price roundedPrice = new Price("2.62737").roundLastDecimalToNearestHalf();

        assertEquals(new Price("2.65"), roundedPrice);
    }
}
