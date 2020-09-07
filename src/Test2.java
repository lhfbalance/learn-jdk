public class Test2 {

//    static {
//        System.out.println(" static test2");
//    }
//
//    public Test2() {
//        System.out.println("new Test2");
//    }

    public static void main(String[] args) {
//        System.out.println(System.getProperty("java.library.path"));
//        System.out.println(System.getProperty("sun.boot.library.path"));


        String url = "http://123-qcloud.com/ccimg/1231231231.jpg";

        System.out.println(url.replaceFirst("http://[^/]+/", ""));

    }

}
