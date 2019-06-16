package reflex;

public class ClassLoaderTest {
    public static void main(String[] args) {
        //A和B并不是加载到内存中，而是需要时再加载
        new A();
        System.out.println("-------按需加载--------");
        new B();

        new C();

        new D();
        new D();
    }
}
class A{}
class B{}

class C{
    //静态块紧接着类加载，且只有一份，先静态块后构造方法
    static {
        System.out.println("静态块");
    }
    public C(){
        System.out.println("构造方法");
    }
}
class D{
    //动态块每次创建对象都会执行，且在构造方法前
    public D(){
        System.out.println("D构造方法");
    }
    {
        System.out.println("动态块");
    }
        }
