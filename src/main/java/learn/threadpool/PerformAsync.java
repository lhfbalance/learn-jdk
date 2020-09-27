package learn.threadpool;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author louhaifeng
 * @date 2020/9/9 14:27
 */
public class PerformAsync {

    static Response performAsync() throws IOException {
        SyncResponseListener syncResponseListener = new SyncResponseListener(3000);
        performAsync(syncResponseListener);
        return syncResponseListener.get();
    }

    static void performAsync(SyncResponseListener listener) {
        Thread thread = new Thread(new AsyncTask(listener));
        thread.start();
    }

    static class AsyncTask implements Runnable {

        ResponseListener responseListener;

        public AsyncTask(ResponseListener responseListener) {
            this.responseListener = responseListener;
        }

        @Override
        public void run() {

            biz();
        }

        void biz() {
            System.out.println("AsyncTask start");

            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (true) {
                responseListener.onFailure(new IOException("a mannul exception"));
            }
        }
    }
}
