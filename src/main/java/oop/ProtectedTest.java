package oop;

import base.ProtectAtest;

public class ProtectedTest {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.a);
        C c = new C();
        //c.show();  不可以使用
    }
}
 class A{
    protected int a = 1;
}
class B extends A{

}
class C extends ProtectAtest{
    public void say(){
        show();
    }
    public static void main(String[] args) {
        C c = new C();
        c.show();

        ProtectAtest protectAtest = new ProtectAtest();
//        protectAtest.show();
    }
}
