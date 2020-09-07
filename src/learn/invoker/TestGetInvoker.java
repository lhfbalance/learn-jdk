package learn.invoker;

public class TestGetInvoker {

    public static void main(String[] args) {
        System.out.println(new Exception().getStackTrace()[0].getClassName());

    }

}
