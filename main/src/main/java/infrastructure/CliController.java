package infrastructure;

import domain.FibonacciNumbers;
import java.util.Scanner;

public class CliController {

  private final CliPresenter cliPresenter;
  private final FibonacciNumbers fibonacciNumbers;

  public CliController(CliPresenter cliPresenter, FibonacciNumbers fibonacciNumbers) {
    this.cliPresenter = cliPresenter;
    this.fibonacciNumbers = fibonacciNumbers;
  }

  public void startProgram() {
    cliPresenter.displayOptions();
    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.nextLine();
    fibonacciNumbers.generate(userInput);
  }
}
