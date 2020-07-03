package tdd.part1;

public class Money {

  protected int amount;

  public Money(int amount) {
    this.amount = amount;
  }

  // TODO: Equal null
  // TODO: Equal object
  public boolean equals(Object object) {
    Money money = (Money) object;
    return amount == money.amount && this.getClass().equals(money.getClass());
  }
}
