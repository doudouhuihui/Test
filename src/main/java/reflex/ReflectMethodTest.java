package reflex;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectMethodTest {
    public static void main(String[] args) throws Exception {
        Class c = MethodTest.class;
        Object o = c.newInstance();
        //获取方法数组，包含父类和接口方法,仅限于public
        Method[] m1 = c.getMethods();
        Arrays.stream(m1).forEach(System.out::println);

        //获取特定的Public方法
        Method m2 = c.getMethod("publicTest", String.class);
        System.out.println(m2+"------------------------");

        //获取所有的方法数组，包括私有的,但是不包括继承过来的fatherMethod
        Method[] m3 = c.getDeclaredMethods();
        Arrays.stream(m3).forEach(System.out::println);

        //获取特定的方法
        Method m4 = c.getDeclaredMethod("privateTest");
        System.out.println(m4);

        //不常用，返回内部类所在的方法
        MethodTest methodTest = new MethodTest();
        methodTest.interfaceMethod();
        Method m5 = methodTest.o.getClass().getEnclosingMethod();
        System.out.println(m5);

        System.out.println("-----------------------------");
        //用方法，无非就三种：方法名，参数，返回值，其中还有修饰符是另外的
        //获取publicTest的方法信息
        System.out.println(m2.getName());
        System.out.println(m2.getParameterCount());
        System.out.println(Arrays.toString(m2.getParameterTypes()));
        System.out.println(Arrays.toString(m2.getParameters()));
        System.out.println(m2.getReturnType());
        String result = (String) m2.invoke(o,"hello");
        System.out.println(result);
        System.out.println(Arrays.toString(m2.getExceptionTypes()));
        /**
         * PUBLIC: 1 （二进制 0000 0001）
         * PRIVATE: 2 （二进制 0000 0010）
         * PROTECTED: 4 （二进制 0000 0100）
         * STATIC: 8 （二进制 0000 1000）
         * FINAL: 16 （二进制 0001 0000）
         * SYNCHRONIZED: 32 （二进制 0010 0000）
         * VOLATILE: 64 （二进制 0100 0000）
         * TRANSIENT: 128 （二进制 1000 0000）
         * NATIVE: 256 （二进制 0001 0000 0000）
         * INTERFACE: 512 （二进制 0010 0000 0000）
         * ABSTRACT: 1024 （二进制 0100 0000 0000）
         * STRICT: 2048 （二进制 1000 0000 0000）
         *
         * int java.lang.reflect.Field.getModifiers()
         * 以整数形式返回此 Method 对象所表示方法的 Java 语言修饰符
         *
         * boolean java.lang.reflect.Modifier.isPublic(int mod)
         * 如果整数参数包括 public 修饰符，则返回 true，否则返回 false。其他方法类似
         *
         * 版权声明：本文为博主原创文章，转载请附上博文链接！
         */
        System.out.println(m2.getModifiers());
        m2.setAccessible(true);
        System.out.println(m2.isAccessible());
    }
}

interface MT{
    void interfaceMethod();
}
class FatherMethod{
    protected void fatherMethod(){}
}
class MethodTest extends FatherMethod implements MT{

    Object o;

    private void privateTest(){
        System.out.println("I am private method");
    }

    void defaultTest(){
        System.out.println("I am default method");
    }


    public String publicTest (String string) throws IOException {
        System.out.println("I am public method"+" "+string);
        return string;
    }

    @Override
    public void interfaceMethod() {
        class M{}
        o = new M();
    }
}
