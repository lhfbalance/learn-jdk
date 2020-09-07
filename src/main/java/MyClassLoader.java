import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        if (name != null) {
            FileInputStream fileInputStream = null;
            ByteArrayOutputStream out = null;
            try {
                String path = "/Users/louhf/workspaces/" + name + ".class";
                fileInputStream = new FileInputStream(new File(path));
                byte[] buffer=new byte[2048];
                int len;
                while ((len = fileInputStream.read(buffer)) != -1) {
                    out=new ByteArrayOutputStream();
                    out.write(buffer, 0, len);
                }

                byte[] bytes = out.toByteArray();

                return defineClass(name, bytes, 0, bytes.length);
            } catch (Exception e) {
                throw new ClassNotFoundException(name, e);
            } finally {
                try {
                    if (fileInputStream != null)
                        fileInputStream.close();
                    if (out != null)
                        out.close();

                } catch (IOException e) {
                    //ignore
                }
            }
        }


        return super.findClass(name);
    }
}
