import java.io.File;
import java.io.IOException;

public class ProcessTest {

    public static void main(String[] args) throws IOException, InterruptedException {
//        Process process = Runtime.getRuntime().exec("sleep 5s");
//
//        process.destroy();
//
//        System.out.println(process.waitFor());
//
//        System.out.println(process.exitValue());

        ProcessBuilder processBuilder = new ProcessBuilder("java", "-h", ">", "/dev/null", "2>&1");

        System.out.println(processBuilder.environment());
        processBuilder.redirectOutput();
        System.out.println(processBuilder.command());
        processBuilder.redirectOutput(ProcessBuilder.Redirect.appendTo(new File("1.txt")));
        processBuilder.redirectError(ProcessBuilder.Redirect.appendTo(new File("error.txt")));
        Process process = processBuilder.start();
        process.wait();
        System.out.println(process.waitFor());
        System.out.println(process.exitValue());
    }

}
