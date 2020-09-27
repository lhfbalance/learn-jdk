package learn.threadpool;

import java.util.concurrent.Callable;

/**
 * @author louhaifeng
 * @date 2020/9/9 12:36
 */
public class Task implements Callable<TaskResult> {



    @Override
    public TaskResult call() throws Exception {
        TaskResult result = new TaskResult();
        try {
            foo1();
            result.setSuccess(true);
        } catch (Throwable th) {
            result.setSuccess(false);
            result.setFailReason(th);
            MyTaskException exception = new MyTaskException(th);
            exception.setResult(result);
            throw exception;
        }

        return result;
    }

    void foo1() throws Exception {
        foo2();
    }

    private void foo2() throws Exception {
        foo3();
    }

    private void foo3() throws Exception {
        foo4();
    }

    private void foo4() {
        throw new MyTaskRuntimeException("test ExceptionStack");
    }

    private void asyncfoo4() throws Exception {
        PerformAsync.performAsync();
    }

    public static void main(String[] args) {
        try {
            new Task().foo1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
