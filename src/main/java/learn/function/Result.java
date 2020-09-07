package learn.function;

public class Result {

    boolean success;
    long startTime;
    long cost;

    public Result() {
        startTime = System.currentTimeMillis();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.cost = System.currentTimeMillis() - startTime;
        this.success = success;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Result{" + "success=" + success + ", startTime=" + startTime + ", cost=" + cost + '}';
    }
}
