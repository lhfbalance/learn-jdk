package learn.proxy;

public class FooApiIml implements FooApi {
    @Override
    public void foo(String s) {
        System.out.println(s);
    }
}
