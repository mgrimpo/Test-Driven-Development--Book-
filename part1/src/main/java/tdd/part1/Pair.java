package tdd.part1;

import java.util.Objects;

public class Pair {
  private String from;
  private String to;

  Pair(String from, String to) {
    this.from = from;
    this.to = to;
  }

  @Override
  public boolean equals(Object object) {
    Pair pair = (Pair) object;
    return pair.from.equals(from) && pair.to.equals(to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to);
  }
}
