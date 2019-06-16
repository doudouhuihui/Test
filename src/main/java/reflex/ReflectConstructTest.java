package reflex;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * 反射构造器相关方法
 */
public class ReflectConstructTest {
    public static void main(String[] args) throws Exception {
        Class c = ConstructTest.class;
        //返回构造器数组，包含所有的public构造器
        Constructor[] c1 = c.getConstructors();
        System.out.println("getConstructors()获取所有Public修饰的构造器----"+Arrays.toString(c1));

        //返回特定的构造器,也是只包含public的，参数为构造器的参数类型
        Constructor c2 = c.getConstructor(String.class);
        System.out.println("getConstructor()获取特定的public构造器----"+c2);

        //返回构造器数组，所有的构造器，包括private和默认的,
        Constructor[] c3 =c.getDeclaredConstructors();
        System.out.println("getDeclaredConstructors()获取所有的构造器，包括默认的和private----"+Arrays.toString(c3));

        //返回 特定的构造器，包含private和默认的
        Constructor c4 = c.getDeclaredConstructor(int.class);
        System.out.println("getDeclaredConstructor()获取特定的构造器----"+c4);

        //很少用，返回内部类所在的构造函数
        Constructor c5 = new ConstructTest("123").o.getClass().getEnclosingConstructor();
        System.out.println("内部类所在的构造函数"+c5);


        //构造器也有newInstance方法，用来创建对象,参数为构造器的参数
        Object o1 = c1[0].newInstance();

        Object o2 = c2.newInstance("hello");

        Object o3 = c3[0].newInstance();

        //通过private修饰的构造器需要去掉修饰符，可攻击单例模式，new出不同的对象出来
        c4.setAccessible(true);
        Object o4 = c4.newInstance(123);

        Object o5 = c5.newInstance("world");

        System.out.println(c2.getParameterCount());

    }
}
interface CT{}
class ConstructTest implements CT{
    static Object o;
    int i;
    String s;
    public ConstructTest(){
        System.out.println("public default constructor!");
    }
    private ConstructTest(int i){
        System.out.println("private 1 param constructor!"+i);
    }
    public ConstructTest(String s){
        class Inner{}
        o = new Inner();
        System.out.println("public 1 param constructor!"+s);
    }


}
