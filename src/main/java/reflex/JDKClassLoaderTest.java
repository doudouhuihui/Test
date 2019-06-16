package reflex;

import java.net.URLClassLoader;

public class JDKClassLoaderTest {
    public static void main(String[] args) {
        //bootstrap classloader, 加载核心类获取不到它
        System.out.println(String.class.getClassLoader());

        //extension classloader, 加载拓展类 jre/lib/ext/下面的
        System.out.println(com.sun.crypto.provider.AESKeyGenerator.class.getClassLoader().getClass().getName());

        //application classloader, 加载我们自己写的类
        System.out.println(JDKClassLoaderTest.class.getClassLoader().getClass().getName());

        //define classloader, 通过继承ClassLoader类来自定义加载。自带的例如URLClassLoader SecureClassLoader
        URLClassLoader url ;
    }
}
class myClassLoader extends ClassLoader {

}
