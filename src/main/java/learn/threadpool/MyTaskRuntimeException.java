package learn.threadpool;

/**
 * @author louhaifeng
 * @date 2020/9/9 12:44
 */
public class MyTaskRuntimeException extends RuntimeException {

//    private static final StackTraceElement[] UNASSIGNED_STACK = new StackTraceElement[0];
//    private StackTraceElement[] stackTrace = UNASSIGNED_STACK;
//    private transient Object backtrace;

    TaskResult result;


    public MyTaskRuntimeException(String message) {
        super(message);
    }

    public TaskResult getResult() {
        return result;
    }

    public void setResult(TaskResult result) {
        this.result = result;
    }

//    @Override
//    public synchronized Throwable fillInStackTrace() {
//        if (stackTrace != null ||
//            backtrace != null /* Out of protocol state */ ) {
//            fillInStackTrace(0);
//            stackTrace = UNASSIGNED_STACK;
//        }
//        return this;
//    }
//
//    private native Throwable fillInStackTrace(int dummy);
}
