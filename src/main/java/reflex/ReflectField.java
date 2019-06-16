package reflex;

import sun.reflect.annotation.AnnotatedTypeFactory;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ReflectField {

    public static void main(String[] args) throws Exception {
        Class c = FieldTest.class;

        //获取当前类和父类的所有public属性
        Field[] f = c.getFields();
        System.out.println(""+ Arrays.toString(f));

        //获取当前类的所有属，不限修饰符
        Field[] f1 = c.getDeclaredFields();
        System.out.println(""+Arrays.toString(f1));

        Field f2 = c.getField("str");
        System.out.println(f2);

        Field f3 = c.getDeclaredField("l");
        System.out.println(f3);

        int i = f2.getModifiers();
        System.out.println(i);
        int j = f3.getModifiers();
        System.out.println(j);

        System.out.println(f2.getName());
        System.out.println(f2.getType().equals(String.class));

        System.out.println(f3.getType()==long.class);
        System.out.println(f2.getGenericType());
        System.out.println(f2.getType());
        System.out.println(f2.getAnnotatedType());
        System.out.println(Arrays.toString(f2.getAnnotations()));
        System.out.println(Arrays.toString(f2.getDeclaredAnnotations()));
        //System.out.println(f2.getDeclaredAnnotation(AnnotatedTypeFactory.class));
    }
}
class FT{
    private int fi;
    public String fStr;
    protected char Fch;
    long fl;
}
class FieldTest extends FT {
    private int i;
    @SuppressWarnings("123")
    public String str = "hello";
    protected char ch;
    long l;

}
