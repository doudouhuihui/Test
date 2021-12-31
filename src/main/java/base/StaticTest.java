package base;
import static java.lang.System.*;

public class StaticTest {
    public static void main(String[] args) {
        out.println("main");
        new Father();
    }

}

class Father{
    static {
        System.out.println("父类静态块");
    }
    public Father(){
        System.out.println("父类构造函数");
    }
    {
        System.out.println("父类非静态代码块");
    }
}

class Son extends Father{
    static {
        System.out.println("子类静态块");
    }
    public Son(){
        System.out.println("子类构造函数");
    }
    {
        System.out.println("子类非静态代码块");
    }
}
