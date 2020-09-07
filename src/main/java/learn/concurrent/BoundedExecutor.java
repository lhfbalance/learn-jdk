package learn.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

public class BoundedExecutor {

    private final Executor executor;
    private final Semaphore semaphore;

    public BoundedExecutor(Executor executor, Semaphore semaphore) {
        this.executor = executor;
        this.semaphore = semaphore;
    }

    public void submitTask(final Runnable command) throws InterruptedException {
        semaphore.acquire();
        try {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        command.run();
                    } finally {
                        semaphore.release();
                    }
                }
            });
        } catch (Exception e) {
            semaphore.release();
        }
    }
}
