package infrastructure;

import java.util.ArrayList;
import java.util.HashMap;

public class CliPresenter {

  public void displayOptions() {
    System.out.println();
    System.out.println("Choose one of the following options:");
    System.out.println("0 - Show created tasks");
    System.out.println("1 - Create new task");
    System.out.println("2 - Start a task");
    System.out.println("3 - See results of completed tasks");
    System.out.println("4 - Exit program");
    System.out.println();
  }

  public void displayThreads(HashMap<Integer, String> threadData) {
    System.out.println();
    for (int index = 0; index < threadData.size(); index++) {
      System.out.println(index + " - Calculate Fibonacci numbers until " + threadData.get(index));
    }
  }

  public void displayResults(ArrayList<Long> results) {
    for (Long result : results) {
      System.out.println(result);
    }
  }

  public void displayNotValidOptionMessage() {
    System.out.println();
    System.out.println("Not a valid option, please try again.");
  }

  public void askUserForFibonacciCalculationNumber() {
    System.out.println();
    System.out.println("Please introduce the number you want to calculate: ");
  }

  public void askUserForTaskToStart() {
    System.out.println("Please introduce the number of the task you want to start");
  }

  public void displayStartedTask(String taskName) {
    System.out.println("Task started: " + taskName);
  }
}
