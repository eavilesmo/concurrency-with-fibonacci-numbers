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
        cliPresenter.displayThreads(threads);
        startProgram();
        break;
      case "1":
        System.out.println("Please introduce the number you want to calculate: ");
        String input = new Scanner(System.in).nextLine();
        Runnable runnable = () -> {
          try {
            long result = fibonacciNumbers.generate(input);
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
        String inputNumber = new Scanner(System.in).nextLine();
        int index = Integer.parseInt(inputNumber);
        threads.get(index).start();
        System.out.println("Thread started: " + threads.get(index).getName());
        startProgram();
        break;
      case "3":
        for (Long result : results) {
          System.out.println(result);
        }
        startProgram();
        break;
      case "4":
        break;
      default:
        System.out.println("Not a valid option, please try again.");
        startProgram();
    }
  }
}
