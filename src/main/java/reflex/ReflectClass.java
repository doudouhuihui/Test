package reflex;

import java.lang.reflect.InvocationTargetException;

public class ReflectClass {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String str = "reflex.T";
        //把类加载进内存，没创建对象
        Class c = Class.forName(str);
        //反射创建对象，通过无参构造,且必须是public
        Object o = c.newInstance();


    }
}

class T {


    static {
        System.out.println("T was loaded!");
    }

    public T(){
        System.out.println("T was constructed!");
    }

}
