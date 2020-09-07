package learn.securitymanager;

public class MySecurityManager {

    public static void main(String[] args) {

        SecurityManager securityManager = new SecurityManager();

        System.setSecurityManager(securityManager);

        System.out.println(System.getSecurityManager());

    }

}
