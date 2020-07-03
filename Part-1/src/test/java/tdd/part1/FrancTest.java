package tdd.part1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FrancTest {
  @Test
  public void testMultiplication() {
    Money five = Money.franc(5);
    assertEquals(Money.franc(10), five.times(2));
    assertEquals(Money.franc(15), five.times(3));
  }

  @Test
  public void testEquals() {
    assertTrue(Money.franc(3).equals(Money.franc(3)));
    assertFalse(Money.franc(5).equals(Money.franc(3)));
  }
}
