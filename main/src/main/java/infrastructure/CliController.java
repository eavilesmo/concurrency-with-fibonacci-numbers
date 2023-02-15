package infrastructure;

import domain.FibonacciNumbers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CliController extends Thread {

  private final CliPresenter cliPresenter;
  private final FibonacciNumbers fibonacciNumbers;

  public CliController(CliPresenter cliPresenter, FibonacciNumbers fibonacciNumbers) {
    this.cliPresenter = cliPresenter;
    this.fibonacciNumbers = fibonacciNumbers;
  }

  private final ArrayList<Thread> threads = new ArrayList<>();
  private final HashMap<Integer, String> threadData = new HashMap<>();
  private final ArrayList<Result> results = new ArrayList<>();

  public void runProgram() {
    cliPresenter.displayOptions();
    decideNextOption(getUserInput());
  }

  private void decideNextOption(String userInput) {
    switch (userInput) {
      case "0":
        cliPresenter.displayTasks(threadData);
        runProgram();
        break;

      case "1":
        cliPresenter.askUserForFibonacciCalculationLimitNumber();
        createThread();
        runProgram();
        break;

      case "2":
        cliPresenter.askUserForTaskToStart();
        int index = Integer.parseInt(getUserInput());
        threads.get(index).start();
        String taskName = threads.get(index).getName();
        cliPresenter.displayStartedTask(taskName);
        runProgram();
        break;

      case "3":
        cliPresenter.displayResults(results);
        runProgram();
        break;

      case "4":
        break;

      default:
        cliPresenter.displayNotValidOptionMessage();
        runProgram();
    }
  }

  private void createThread() {
    String number = getUserInput();
    Runnable runnable = () -> {
      try {
        long result = fibonacciNumbers.generate(number);
        results.add(new Result(result, number));
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    };
    Thread thread = new Thread(runnable);
    String threadName = String.valueOf(threads.size());
    thread.setName(threadName);
    threads.add(thread);
    int threadIndex = Integer.parseInt(thread.getName());
    threadData.put(threadIndex, number);
  }

  private String getUserInput() {
    return new Scanner(System.in).nextLine();
  }
}
