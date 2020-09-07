package learn.generic;

public class Foo implements Consumer<String> {

    @Override
    public void consume(String s) {

    }

//    public void consume(Integer i) {
//
//    }

    public static void main(String[] args) {
        Consumer consumer = new Foo();
        consumer.consume(1);
    }

}
