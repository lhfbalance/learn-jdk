package learn.annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        {
            Annotation[] annotations = MyInheritedClass.class.getAnnotations();
            System.out.println(Arrays.toString(annotations));
        }
        {
            Annotation[] annotations = IInheritedInterfaceChildImp.class.getAnnotations();
            System.out.println(Arrays.toString(annotations));
        }
        {
            Annotation[] annotations = IInheritedInterface.class.getAnnotations();
            System.out.println(Arrays.toString(annotations));
        }
        {
            Annotation[] annotations = IInheritedInterfaceChild.class.getAnnotations();
            System.out.println(Arrays.toString(annotations));
        }
        {
            Annotation[] annotations = IInheritedInterfaceChildImp.class.getAnnotations();
            System.out.println(Arrays.toString(annotations));
        }
    }
}
