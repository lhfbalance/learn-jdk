package learn.thread;

import java.util.concurrent.TimeUnit;

public class TestInterrupt {

    static void interrupedOtherThread() throws InterruptedException {
        Object o = new Object();
        Thread thread = new Thread(new MyTask(o), "ttt");
        thread.start();
        TimeUnit.MILLISECONDS.sleep(500);
        if (thread.isAlive()) {
            thread.interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        interrupedOtherThread();
    }
}

class MyTask implements Runnable {

    private Object lock;

    public MyTask(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + " will wait");
                    lock.wait(1000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted");
                }
            }
        }
    }
}
