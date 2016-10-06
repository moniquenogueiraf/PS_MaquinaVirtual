public class Calculator {
  public int sum(String expression) {
    int total = 0;
    for (String summand: expression.split("\\+"))
      total += Integer.valueOf(summand);
    return total;
  }
  public int sub(String expression) {
    int total = 0;
    for (String summand: expression.split("\\-"))
      total -= Integer.valueOf(summand);
    return total;
  }
}
