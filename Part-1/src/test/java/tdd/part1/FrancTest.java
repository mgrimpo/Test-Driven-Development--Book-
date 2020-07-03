package tdd.part1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FrancTest {
  @Test
  public void testMultiplication() {
    Franc five = new Franc(5);
    assertEquals(new Franc(10), five.times(2));
    assertEquals(new Franc(15), five.times(3));
  }

  @Test
  public void testEquals() {
    assertTrue(new Franc(3).equals(new Franc(3)));
    assertFalse(new Franc(5).equals(new Franc(3)));
  }
}
