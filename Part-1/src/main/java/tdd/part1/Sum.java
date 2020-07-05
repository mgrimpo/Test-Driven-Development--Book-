package tdd.part1;

public class Sum implements Expression {
  public Expression augend;
  public Expression addend;

  public Sum(Expression augend, Expression addend) {
    this.augend = augend;
    this.addend = addend;
  }

  public Money reduce(Bank bank, String currency) {
    int amount = augend.reduce(bank, currency).amount + addend.reduce(bank, currency).amount;
    return new Money(amount, currency);
  }

  @Override
  public Expression plus(Expression addend) {
    return new Sum(this, addend);
  }

  @Override
  public Expression times(int multiplicator) {
    return new Sum(augend.times(multiplicator), addend.times(multiplicator));
  }
}
