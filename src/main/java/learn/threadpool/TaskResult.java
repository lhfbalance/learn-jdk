package learn.threadpool;

/**
 * @author louhaifeng
 * @date 2020/9/9 12:40
 */
public class TaskResult {

    boolean success;
    Throwable failReason;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Throwable getFailReason() {
        return failReason;
    }

    public void setFailReason(Throwable failReason) {
        this.failReason = failReason;
    }
}
