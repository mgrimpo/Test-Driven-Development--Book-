package tdd.part1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MoneyTest {

  @Test
  public void testCurrency() {
    assertEquals("USD", Money.dollar(1).currency());
    assertEquals("CHF", Money.franc(1).currency());
  }

  @Test
  public void testMultiplication() {
    Money five = Money.dollar(5);
    assertEquals(Money.dollar(10), five.times(2));
    assertEquals(Money.dollar(15), five.times(3));
  }

  @Test
  public void testEquality() {
    assertTrue(Money.dollar(3).equals(Money.dollar(3)));
    assertFalse(Money.dollar(5).equals(Money.dollar(3)));
    assertTrue(Money.franc(3).equals(Money.franc(3)));
    assertFalse(Money.franc(5).equals(Money.franc(3)));
    assertFalse(Money.dollar(5).equals(Money.franc(5)));
  }

  @Test
  public void testSimpleAddition() {
    Money fiveDollar = Money.dollar(5);
    Expression sum = fiveDollar.plus(fiveDollar);
    Bank bank = new Bank();
    Money reduced = bank.reduce(sum, "USD");
    assertEquals(Money.dollar(10), reduced);
  }

  @Test
  public void testPlusReturnsSum() {
    Money fiveDollar = Money.dollar(5);
    Expression result = fiveDollar.plus(fiveDollar);
    Sum sum = (Sum) result;
    assertEquals(fiveDollar, sum.augend);
    assertEquals(fiveDollar, sum.addend);
  }

  @Test
  public void testReduceSum() {
    Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
    Bank bank = new Bank();
    Money result = bank.reduce(sum, "USD");
    assertEquals(Money.dollar(7), result);
  }

  @Test
  public void testReduceMoney() {
    Bank bank = new Bank();
    Money reducedMoney = bank.reduce(Money.dollar(1), "USD");
    assertEquals(Money.dollar(1), reducedMoney);
  }

  @Test
  public void testReduceToDifferentCurrency() {
    Money franc = Money.franc(2);
    Bank bank = new Bank();
    bank.addRate("CHF", "USD", 2);
    Money reducedToDollar = bank.reduce(franc, "USD");
    assertEquals(Money.dollar(1), reducedToDollar);
  }

  @Test
  public void testMixedAddition() {
    Expression fiveDollars = Money.dollar(5);
    Expression tenFrancs = Money.franc(10);
    Bank bank = new Bank();
    bank.addRate("CHF", "USD", 2);
    Expression reducedSum = bank.reduce(fiveDollars.plus(tenFrancs), "USD");
    assertEquals(Money.dollar(10), reducedSum);
  }

  @Test
  public void testSumPlusMoney() {
    Expression fiveDollars = Money.dollar(5);
    Expression tenFrancs = Money.franc(10);
    Bank bank = new Bank();
    bank.addRate("CHF", "USD", 2);
    Expression sum = new Sum(fiveDollars, tenFrancs).plus(fiveDollars);
    Money reduced = sum.reduce(bank, "USD");
    assertEquals(Money.dollar(15), reduced);
  }

  @Test
  public void testSumTimes() {
    Expression fiveDollars = Money.dollar(5);
    Expression tenFrancs = Money.franc(10);
    Bank bank = new Bank();
    bank.addRate("CHF", "USD", 2);
    Expression sumTimes2 = new Sum(fiveDollars, tenFrancs).times(2);
    Money reduced = sumTimes2.reduce(bank, "USD");
    assertEquals(Money.dollar(20), reduced);
  }
}
