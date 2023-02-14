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

  public void startProgram() {
    cliPresenter.displayOptions();
    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.nextLine();
    decideNextOption(userInput);
  }

  private void decideNextOption(String userInput) {
    switch (userInput) {
      case "0":
        Runnable runnable = () -> {
          try {
            fibonacciNumbers.generate(userInput);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        };
        Thread thread = new Thread(runnable);
        threads.add(thread);
        break;
      case "1":
        System.out.println("Please introduce the number of the thread you want to start");
        String input = new Scanner(System.in).nextLine();
        threads.get(0).start();
        System.out.println("Thread started");
        break;
      case "2":
      case "3":
      case "4":
    }
  }
}
