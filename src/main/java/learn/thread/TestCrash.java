package learn.thread;

import java.util.concurrent.TimeUnit;

public class TestCrash {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {

            int num = 3;

            for (;num>0;num--) {
                System.out.println(Thread.currentThread().getName() + ": " + num);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    ;
                }
            }

            throw new RuntimeException(Thread.currentThread().getName() + " crash!!!!!!!");

        }, "mey-thread-1");

        Thread thread2 = new Thread(() -> {
            int num = 50;

            for (;num>0;num--) {
                System.out.println(Thread.currentThread().getName() + ": " + num);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    ;
                }
            }

        }, "mey-thread-2");

        thread1.start();
        thread2.start();
    }
}

