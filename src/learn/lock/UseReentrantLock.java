package learn.lock;

import java.util.concurrent.locks.ReentrantLock;

public class UseReentrantLock {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        System.out.println(lock.getHoldCount());
        System.out.println(lock.getQueueLength());
        System.out.println(lock.hasQueuedThreads());
        lock.unlock();
    }

}
