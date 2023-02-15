package infrastructure;

public class Result {

  public final long result;
  public final String inputNumber;

  public Result(long result, String inputNumber) {
    this.result = result;
    this.inputNumber = inputNumber;
  }

  public long getResult() {
    return result;
  }

  public String getInputNumber() {
    return inputNumber;
  }
}
