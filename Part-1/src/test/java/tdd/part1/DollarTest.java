package tdd.part1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DollarTest {
  @Test
  public void testMultiplication() {
    Money five = Money.dollar(5);
    assertEquals(Money.dollar(10), five.times(2));
    assertEquals(Money.dollar(15), five.times(3));
  }

  @Test
  public void testEquals() {
    assertTrue(Money.dollar(3).equals(Money.dollar(3)));
    assertFalse(Money.dollar(5).equals(Money.dollar(3)));
  }

  @Test
  public void testDollarsAreNotFrancs() {
    assertFalse(Money.dollar(5).equals(Money.franc(5)));
  }
}
