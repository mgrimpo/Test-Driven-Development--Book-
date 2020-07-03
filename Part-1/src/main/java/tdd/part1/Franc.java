package tdd.part1;

// TODO: Dollar/Franc duplication
public class Franc extends Money {

  public Franc(int amount) {
    super(amount);
  }

  // TODO: Common times
  public Money times(int multiplier) {
    return new Franc(amount * multiplier);
  }
  // TODO: hashCode()
}
