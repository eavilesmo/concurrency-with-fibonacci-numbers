package domain;

import java.util.ArrayList;

public class FibonacciNumbers {

  public long generate(String userInput) throws InterruptedException {
    ArrayList<Long> fibonacciNumbers = new ArrayList<>();
    fibonacciNumbers.add(0L);
    fibonacciNumbers.add(1L);

    int limitNumber = Integer.parseInt(userInput);
    while (fibonacciNumbers.size() <= limitNumber) {
      Long nextToLastNumber = fibonacciNumbers.get(fibonacciNumbers.size() - 2);
      Long lastNumber = fibonacciNumbers.get(fibonacciNumbers.size() - 1);
      fibonacciNumbers.add(lastNumber + nextToLastNumber);
    }

    Thread.sleep(10000);

    Long lastNumber = fibonacciNumbers.get(fibonacciNumbers.size() - 1);
    return lastNumber;
  }
}
