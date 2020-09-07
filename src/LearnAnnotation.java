import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Objects;

public class LearnAnnotation {
    
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("Person");

        if (c.isAnnotationPresent(Design.class)) {
            Design d = (Design) c.getAnnotation(Design.class);
            System.out.println(d.getClass());
            System.out.println(d.data());
        }

        Method[] methods = c.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Design.class)) {
                Design design = method.getAnnotation(Design.class);
                System.out.println(design.data());
            }
        }
    }

}
