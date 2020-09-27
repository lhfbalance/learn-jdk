package learn.threadpool;

/**
 * @author louhaifeng
 * @date 2020/9/9 14:34
 */
public interface ResponseListener {
    /**
     * Method invoked if the request yielded a successful response
     */
    void onSuccess(Response response);

    /**
     * Method invoked if the request failed. There are two main categories of failures: connection failures (usually
     * {@link java.io.IOException}s, or responses that were treated as errors based on their error response code
     */
    void onFailure(Exception exception);
}
