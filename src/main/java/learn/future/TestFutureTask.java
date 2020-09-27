package learn.future;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author louhaifeng
 * @date 2020/9/18 13:20
 */
public class TestFutureTask {
    public static void main(String[] args) {
        FutureTask<Boolean> futureTask = new FutureTask(() -> {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("return true");
            return true;
        });

        futureTask.run();
        futureTask.run();
        futureTask.run();
    }
}
