package infrastructure;

import domain.FibonacciNumbers;
import java.util.ArrayList;
import java.util.Scanner;

public class CliController extends Thread {

  private final CliPresenter cliPresenter;
  private final FibonacciNumbers fibonacciNumbers;

  public CliController(CliPresenter cliPresenter, FibonacciNumbers fibonacciNumbers) {
    this.cliPresenter = cliPresenter;
    this.fibonacciNumbers = fibonacciNumbers;
  }

  private final ArrayList<Thread> threads = new ArrayList<>();
  private final ArrayList<Long> results = new ArrayList<>();

  public void startProgram() {
    cliPresenter.displayOptions();
    decideNextOption(getUserInput());
  }

  private void decideNextOption(String userInput) {
    switch (userInput) {
      case "0":
        cliPresenter.displayThreads(threads);
        startProgram();
        break;
      case "1":
        System.out.println("Please introduce the number you want to calculate: ");
        Runnable runnable = () -> {
          try {
            long result = fibonacciNumbers.generate(getUserInput());
            results.add(result);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        };
        Thread thread = new Thread(runnable);
        threads.add(thread);
        startProgram();
        break;
      case "2":
        System.out.println("Please introduce the number of the thread you want to start");
        int index = Integer.parseInt(getUserInput());
        threads.get(index).start();
        System.out.println("Thread started: " + threads.get(index).getName());
        startProgram();
        break;
      case "3":
        cliPresenter.displayResults(results);
        startProgram();
        break;
      case "4":
        break;
      default:
        cliPresenter.displayNotValidOptionMessage();
        startProgram();
    }
  }

  private String getUserInput() {
    return new Scanner(System.in).nextLine();
  }
}
