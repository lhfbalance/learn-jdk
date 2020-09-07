import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws Exception {

        Test2 test2 = new Test2();
        System.out.println(test2.getClass());
        System.out.println(test2.getClass().getClassLoader());
        System.out.println("------------------");


        MyClassLoader myClassLoader = new MyClassLoader();
//        Class<?> clazz = myClassLoader.loadClass("Test2");
        Class<?> clazz = Class.forName("Test4", false, myClassLoader);
        TimeUnit.SECONDS.sleep(2);
        Object object = clazz.newInstance();
//        System.out.println(object.getClass());
//        System.out.println(object.getClass().getClassLoader());
//        System.out.println(object.getClass().getClassLoader().getParent());
//        System.out.println(object.getClass().getClassLoader().getParent().getParent());

    }

}
