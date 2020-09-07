package learn.bio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestThreadSafe implements Runnable {

    FileInputStream fileInputStream;

    public TestThreadSafe() {
        try {
            this.fileInputStream = new FileInputStream("1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new TestThreadSafe(), "thread-1").start();
        new Thread(new TestThreadSafe(), "thread-2").start();
    }

    @Override
    public void run() {
        readFromFile();
    }

    void readFromStdin() {
        try {
            while (true) {
                byte[] read = new byte[10];
                int n = System.in.read(read);
                System.out.println(Thread.currentThread().getName()+ " read " + n + " bytes");
                byte[] dst = new byte[n];
                System.arraycopy(read, 0, dst, 0, n);
                System.out.print(Thread.currentThread().getName()+ " : " + new String(dst));
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    void readFromFile() {
        try {
            while (true) {
                byte[] read = new byte[10];
                int n = fileInputStream.read(read);
                System.out.println(Thread.currentThread().getName()+ " read " + n + " bytes");
                if (n == -1) {
                    break;
                }
                byte[] dst = new byte[n];
                System.arraycopy(read, 0, dst, 0, n);
                System.out.println(Thread.currentThread().getName()+ " : " + new String(dst));
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
