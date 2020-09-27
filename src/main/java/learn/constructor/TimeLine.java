package learn.constructor;

/**
 * @author louhaifeng
 * @date 2020/9/9 20:23
 */
public class TimeLine {

    private String field = "aaa";

    public TimeLine() {
        init();
        System.out.println(this.field);
        field = "bbb";
    }

    private void init() {
        field = "ccc";
    }

    public static void main(String[] args) {
        TimeLine timeLine = new TimeLine();
    }
}
