package infrastructure;

public class Result {

  public final long result;
  public final String limitNumber;

  public Result(long result, String limitNumber) {
    this.result = result;
    this.limitNumber = limitNumber;
  }

  public long getResult() {
    return result;
  }

  public String getLimitNumber() {
    return limitNumber;
  }
}
