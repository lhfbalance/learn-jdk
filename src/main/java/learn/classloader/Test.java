package learn.classloader;

import java.util.ServiceLoader;

public class Test {

    public static int staticField1 = 1000;

    static {
        System.out.println("static block init");
    }


    public Test() {
        name = "lohifen";
    }

    private String name;

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.getClass().getClassLoader());
        System.out.println(ServiceLoader.loadInstalled(Test.class));
    }



}
