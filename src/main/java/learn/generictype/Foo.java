package learn.generictype;

public class Foo implements Consumer<String> {

    @Override
    public void consume(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.consume("123");

        Consumer<String> consumer = new Foo();
        consumer.consume("123");
    }
}
