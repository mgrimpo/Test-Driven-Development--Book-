package tdd.part1;

// TODO: Dollar/Franc duplication
public class Franc extends Money {

  public Franc(int amount, String currency) {
    super(amount, currency);
  }

  // TODO: Common times
  public Money times(int multiplier) {
    return Money.franc(amount * multiplier);
  }

  // TODO: hashCode()
}
