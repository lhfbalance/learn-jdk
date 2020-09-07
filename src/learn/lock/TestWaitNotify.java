package learn.lock;


import java.util.concurrent.atomic.AtomicBoolean;

public class TestWaitNotify {

    public static void main(String[] args) {

    }

    public static class Task implements Runnable {

        Object shared = new Object();

        AtomicBoolean atomicBoolean = new AtomicBoolean();

        @Override
        public void run() {

            synchronized (shared) {
                if (atomicBoolean.get()) {
                    try {
                        shared.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            shared.notify();

        }
    }

}
