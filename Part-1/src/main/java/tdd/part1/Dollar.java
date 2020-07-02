package tdd.part1;

// TODO: $5 + 10 CHF = $10 if rate is 2:1
// TODO: Money rounding?
public class Dollar {

  // TODO: make "amount" private
  public int amount;

  public Dollar(int amount) {
    this.amount = amount;
  }

  public Dollar times(int multiplier) {
    return new Dollar(amount * multiplier);
  }
  // TODO: Equal null
  // TODO: Equal object
  public boolean equals(Object object) {
    Dollar dollar = (Dollar) object;
    return amount == dollar.amount;
  }
  // TODO: hashCode()

}
