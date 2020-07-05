package tdd.part1;

// TODO: $5 + $5 = $10
// TODO: $5 + 10 CHF = $10 if rate is 2:1
// TODO: Money rounding?
// TODO: hashCode()
public class Money implements Expression {

  protected int amount;
  protected String currency;

  public Money(int amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public static Money dollar(int amount) {
    return new Money(amount, "USD");
  }

  public static Money franc(int amount) {
    return new Money(amount, "CHF");
  }

  public Money times(int multiplier) {
    return new Money(amount * multiplier, currency);
  }

  // TODO: Equal null
  // TODO: Equal object
  public boolean equals(Object object) {
    Money money = (Money) object;
    return amount == money.amount && currency.equals(money.currency);
  }

  public String currency() {
    return currency;
  }

  public String toString() {
    return amount + " " + currency;
  }

  public Expression plus(Money addend) {
    return new Sum(this, addend);
  }

  public Money reduce(Bank bank, String to) {
    int rate = bank.rate(currency, to);
    return new Money(amount / rate, to);
  }
}
