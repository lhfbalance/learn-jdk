package learn.exception;

/**
 * @author louhaifeng
 * @date 2020/9/8 14:57
 */
public class TestException {

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                new TestException().foo1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }

    void foo1() {
        foo2();
    }

    private void foo2() {
        try {
            foo3();
        } catch (Exception e) {
            throw e;
        }

    }

    private void foo3() {
        foo4();
    }

    private void aysncfoo5() {
    }

    private void foo4() {
        throw new RuntimeException("test ExceptionStack");
    }
}
