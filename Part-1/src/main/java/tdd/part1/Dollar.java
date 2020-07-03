package tdd.part1;

// TODO: $5 + 10 CHF = $10 if rate is 2:1
// TODO: Money rounding?
public class Dollar extends Money {

  public Dollar(int amount, String currency) {
    super(amount, currency);
  }

  public Money times(int multiplier) {
    return Money.dollar(amount * multiplier);
  }

  // TODO: hashCode()

}
