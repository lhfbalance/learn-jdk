package learn.threadpool;

/**
 * @author louhaifeng
 * @date 2020/9/9 12:44
 */
public class MyTaskException extends Exception {


    TaskResult result;

    public MyTaskException(Throwable cause) {
        super(cause);
    }

    public MyTaskException(String message) {
        super(message);
    }

    public TaskResult getResult() {
        return result;
    }

    public void setResult(TaskResult result) {
        this.result = result;
    }

}
