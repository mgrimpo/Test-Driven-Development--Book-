package tdd.part1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MoneyTest {

  @Test
  public void testCurrency() {
    assertEquals("USD", Money.dollar(1).currency());
    assertEquals("CHF", Money.franc(1).currency());
  }

  @Test
  public void testDifferentClassEquality() {
    assertEquals(new Money(10, "CHF"), new Franc(10, "CHF"));
  }
}
