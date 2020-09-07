import java.security.Permission;
import java.util.concurrent.TimeUnit;

public class NoExitSecurityManager extends SecurityManager {

    boolean exitFilter = true;

    @Override
    public void checkPermission(Permission perm) {
    }

    @Override
    public void checkPermission(Permission perm, Object context) {
    }

    @Override
    public void checkExit(int status) {
        super.checkExit(status);
        if (exitFilter) {
            throw new ExitException(status);
        }
    }

    protected static class ExitException extends SecurityException {

        private static final long serialVersionUID = 1L;
        public final int status;

        public ExitException(int status) {
            super("³É¹¦À¹½ØSystem.ext(0)£¡");
            this.status = status;
        }
    }

    public static void main(String args[]) throws InterruptedException {
        NoExitSecurityManager manager = new NoExitSecurityManager();
        System.setSecurityManager(manager);
        exit();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("not exit");
        manager.exitFilter = false;
        System.exit(0);
    }

    private static void exit() {
        System.out.println("jvm will exit");
        System.exit(0);
    }

}
