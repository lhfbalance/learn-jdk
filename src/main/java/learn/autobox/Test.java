package learn.autobox;

/**
 * @author louhaifeng
 * @date 2020/9/7 9:09
 */
public class Test {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        //false
        System.out.println(c == d);
        //false
        System.out.println(e == f);
        //false
        System.out.println(c == (a + b));
        //true
        System.out.println(c.equals(a + b));
        //false
        System.out.println(g == (a + b));
        //false
        System.out.println(g.equals(a + b));
    }
}
