package other;

import java.util.Iterator;
import java.util.Map;

public class ThreadLocalTest {
    public static void main(String[] args) {
        Integer i1 = 150;
        Integer i2 = 150;
        System.out.println(i1 == i2);

    }
    private static void cross(Person person) {

//        System.out.println(111);
    }


}
class Person{
    protected int method(int a,int b){return 0;}
    class sub{
//        public int method(int a,int b){return 0;}
//        private int method(int a,int b){return 0;}
//        private int method(int a,long b){return 0;}
        public short method(int a,int b){return 0;}
    }
}