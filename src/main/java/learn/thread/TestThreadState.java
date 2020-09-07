package learn.thread;

import java.util.concurrent.TimeUnit;

public class TestThreadState {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i=10; i>0; i--) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(thread.getState());

        thread.start();

        for (int i=0; i<20; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(357);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getState());
        }
    }

}
