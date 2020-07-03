package tdd.part1;

// TODO: Dollar france duplication
public class Franc {

  private int amount;

  public Franc(int amount) {
    this.amount = amount;
  }

  // TODO: Common times
  public Franc times(int multiplier) {
    return new Franc(amount * multiplier);
  }
  // TODO: Common equals
  // TODO: Equal null
  // TODO: Equal object
  public boolean equals(Object object) {
    Franc franc = (Franc) object;
    return amount == franc.amount;
  }
  // TODO: hashCode()
}
