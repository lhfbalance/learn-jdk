package learn.threadpool;

import java.util.concurrent.*;

/**
 * @author louhaifeng
 * @date 2020/9/9 12:37
 */
public class MyExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<TaskResult> future = executorService.submit(new Task());

        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
            System.out.println("----------------------------------------");
            if (e.getCause() instanceof MyTaskException) {
                System.out.println(" yess ");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException interruptedException) {
                    ;
                }
                ((MyTaskException)e.getCause()).getResult().getFailReason().printStackTrace();
            }
        }

        executorService.shutdown();
    }

}
