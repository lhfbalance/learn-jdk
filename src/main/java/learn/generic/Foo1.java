package learn.generic;

public class Foo1 {

    public void consume(String s) {
        System.out.println("string");
    }

    public void consume(Integer i) {
        System.out.println("integer");
    }

    public void consume(Object i) {
        System.out.println("object");
    }

    public static void main(String[] args) {
        Foo1 consumer = new Foo1();
        consumer.consume(1);
    }

}
