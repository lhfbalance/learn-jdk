package learn.threadpool;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author louhaifeng
 * @date 2020/9/9 14:29
 */
public class SyncResponseListener implements ResponseListener {

    private final CountDownLatch latch = new CountDownLatch(1);
    private final AtomicReference<Response> response = new AtomicReference<>();
    private final AtomicReference<Exception> exception = new AtomicReference<>();

    private final long timeout;

    SyncResponseListener(long timeout) {
        assert timeout > 0;
        this.timeout = timeout;
    }

    @Override
    public void onSuccess(Response response) {
        Objects.requireNonNull(response, "response must not be null");
        boolean wasResponseNull = this.response.compareAndSet(null, response);
        if (wasResponseNull == false) {
            throw new IllegalStateException("response is already set");
        }

        latch.countDown();
    }

    @Override
    public void onFailure(Exception exception) {
        Objects.requireNonNull(exception, "exception must not be null");
        boolean wasExceptionNull = this.exception.compareAndSet(null, exception);
        if (wasExceptionNull == false) {
            throw new IllegalStateException("exception is already set");
        }
        latch.countDown();
    }

    /**
     * Waits (up to a timeout) for some result of the request: either a response, or an exception.
     */
    Response get() throws IOException {
        try {
            //providing timeout is just a safety measure to prevent everlasting waits
            //the different client timeouts should already do their jobs
            if (latch.await(timeout, TimeUnit.MILLISECONDS) == false) {
                throw new IOException("listener timeout after waiting for [" + timeout + "] ms");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("thread waiting for the response was interrupted", e);
        }

        Exception exception = this.exception.get();
        Response response = this.response.get();
        if (exception != null) {
            if (response != null) {
                IllegalStateException e = new IllegalStateException("response and exception are unexpectedly set at the same time");
                e.addSuppressed(exception);
                throw e;
            }
            //try and leave the exception untouched as much as possible but we don't want to just add throws Exception clause everywhere
            if (exception instanceof IOException) {
                throw (IOException) exception;
            }
            if (exception instanceof RuntimeException){
                throw (RuntimeException) exception;
            }
            throw new RuntimeException("error while performing request", exception);
        }

        if (response == null) {
            throw new IllegalStateException("response not set and no exception caught either");
        }
        return response;
    }
}
