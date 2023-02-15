import domain.FibonacciNumbers;
import infrastructure.CliController;
import infrastructure.CliPresenter;

public class Main {

  public static void main(String[] args) {
    CliPresenter cliPresenter = new CliPresenter();
    FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
    CliController cliController = new CliController(cliPresenter, fibonacciNumbers);

    cliController.runProgram();
  }
}
