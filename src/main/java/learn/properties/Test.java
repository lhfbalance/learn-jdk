package learn.properties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Test {

    public static void main(String[] args) throws IOException {
        String fileName = "test.properties";
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        Properties properties = new Properties();
        properties.put("key1", "value1");
        properties.put("key2", "value2:value2-1:value2-2");
        String comment = "111";
        System.out.println(comment);
        properties.store(new FileOutputStream(file), comment);
    }
}
