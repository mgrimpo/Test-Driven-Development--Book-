package tdd.part1;

public abstract class Money {

  protected int amount;

  public Money(int amount) {
    this.amount = amount;
  }

  public static Money dollar(int amount) {
    return new Dollar(amount);
  }

  public static Money franc(int amount) {
    return new Franc(amount);
  }

  public abstract Money times(int multiplier);

  // TODO: Equal null
  // TODO: Equal object
  public boolean equals(Object object) {
    Money money = (Money) object;
    return amount == money.amount && this.getClass().equals(money.getClass());
  }
}
