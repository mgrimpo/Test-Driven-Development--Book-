package tdd.part1;

// TODO: Dollar france duplication
public class Franc extends Money {

  public Franc(int amount) {
    super(amount);
  }

  // TODO: Common times
  public Franc times(int multiplier) {
    return new Franc(amount * multiplier);
  }
  // TODO: hashCode()
}
