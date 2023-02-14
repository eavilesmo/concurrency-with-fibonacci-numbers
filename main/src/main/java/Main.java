import domain.FibonacciNumbers;
import infrastructure.CliPresenter;

public class Main {

  public static void main(String[] args) {
    CliPresenter cliPresenter = new CliPresenter();
    cliPresenter.displayOptions();
    FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
    fibonacciNumbers.generate("7");
  }
}
