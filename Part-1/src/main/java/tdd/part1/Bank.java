package tdd.part1;

import java.util.HashMap;
import java.util.Map;

public class Bank {

  private Map<Pair, Integer> rates;

  public Bank() {
    rates = new HashMap<>();
  }

  public Money reduce(Expression source, String to) {
    return source.reduce(this, to);
  }

  /**
   * Add an exchange rate that indicates that {@code rate} amount of {@code fromCurrency} can be
   * conververted to exactly one of {@code toCurrency}.
   */
  public void addRate(String fromCurrency, String toCurrency, int rate) {
    rates.put(new Pair(fromCurrency, toCurrency), rate);
  }

  /**
   * Returns the exchange rate between {@code fromCurrency} and {@code toCurrency}. The exchange
   * rate answers the question: How many units of {@code fromCurrency} are needed to get one unit of
   * {@code toCurrency}?
   */
  public int rate(String fromCurrency, String toCurrency) {
    if (fromCurrency.equals(toCurrency)) return 1;
    return rates.get(new Pair(fromCurrency, toCurrency));
  }
}
