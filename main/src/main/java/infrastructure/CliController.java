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
    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.nextLine();
    decideNextOption(userInput);
  }

  private void decideNextOption(String userInput) {
    switch (userInput) {
      case "0":
        for (Thread thread : threads) {
          System.out.println(thread.getId() + " - " + thread.getName());
        }
        break;
      case "1":
        Runnable runnable = () -> {
          try {
            long result = fibonacciNumbers.generate(userInput);
            results.add(result);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        };
        Thread thread = new Thread(runnable);
        threads.add(thread);
        break;
      case "2":
        System.out.println("Please introduce the number of the thread you want to start");
        String input = new Scanner(System.in).nextLine();
        int index = Integer.parseInt(input);
        threads.get(index).start();
        System.out.println("Thread started: " + threads.get(index).getName());
        break;
      case "3":
        for (Long result : results) {
          System.out.println(result);
        }
      case "4":
        break;
    }
    startProgram();
  }
}
