package infrastructure;

import java.util.ArrayList;

public class CliPresenter {

  public void displayOptions() {
    System.out.println("Choose one of the following options:");
    System.out.println("0 - Show created tasks");
    System.out.println("1 - Create new task");
    System.out.println("2 - Start a task");
    System.out.println("3 - See results of completed tasks");
    System.out.println("4 - Exit program");
  }

  public void displayThreads(ArrayList<Thread> threads) {
    for (Thread thread : threads) {
      System.out.println(thread.getId() + " - " + thread.getName());
    }
  }

  public void displayResults(ArrayList<Long> results) {
    for (Long result : results) {
      System.out.println(result);
    }
  }
}
