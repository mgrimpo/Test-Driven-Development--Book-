package tdd.part1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DollarTest {
  @Test
  public void testMultiplication() {
    Dollar five = new Dollar(5);
    assertEquals(new Dollar(10), five.times(2));
    assertEquals(new Dollar(15), five.times(3));
  }

  @Test
  public void testEquals() {
    assertTrue(new Dollar(3).equals(new Dollar(3)));
    assertFalse(new Dollar(5).equals(new Dollar(3)));
  }
}
