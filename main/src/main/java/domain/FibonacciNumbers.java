package domain;

import java.util.ArrayList;

public class FibonacciNumbers {

  public long generate(String inputNumber) {
    ArrayList<Long> fibonacciNumbers = new ArrayList<>();
    fibonacciNumbers.add(0L);
    fibonacciNumbers.add(1L);

    int input = Integer.parseInt(inputNumber);
    while (fibonacciNumbers.size() <= input) {
      Long lastElement = fibonacciNumbers.get(fibonacciNumbers.size() - 1);
      Long almostLastElement = fibonacciNumbers.get(fibonacciNumbers.size() - 2);
      fibonacciNumbers.add(lastElement + almostLastElement);
    }

    System.out.println(fibonacciNumbers.get(fibonacciNumbers.size() - 1));

    return fibonacciNumbers.get(fibonacciNumbers.size() - 1);
  }
}
