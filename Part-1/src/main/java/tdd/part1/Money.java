package tdd.part1;

public abstract class Money {

  protected int amount;
  protected String currency;

  public Money(int amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public static Money dollar(int amount) {
    return new Dollar(amount, "USD");
  }

  public static Money franc(int amount) {
    return new Franc(amount, "CHF");
  }

  public abstract Money times(int multiplier);

  // TODO: Equal null
  // TODO: Equal object
  public boolean equals(Object object) {
    Money money = (Money) object;
    return amount == money.amount && this.getClass().equals(money.getClass());
  }

  public String currency() {
    return currency;
  }
}
