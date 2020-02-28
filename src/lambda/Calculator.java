package lambda;

@FunctionalInterface
public interface Calculator {
  // public int cal(int num1, int num2);
  // public void noarg();
  public void add(int num1, int num2);
}