package oop;

import java.io.IOException;

public class OverrideTest {
    public static void main(String[] args) {
        Father f = new Son();
        f.say();  //调用的是父类的

    }
}
class Father{
     public static void say(){
        System.out.println("father");
    }
    void sing(){}
    public Father get(){return null;}
    public void speak() throws Exception{}
    final void hello(){}
}

class Son extends Father{
    //@Override
     public static void say(){  //static不能重写，但是可以声明
        System.out.println("son");
    }
    @Override  //访问修饰权限大于等于父类方法
    public void sing(){}

    @Override  //返回类型小于等于父类方法
    public Son get(){return null;}

    @Override //异常必须小于等于父类异常
    public  void speak() throws Exception{}

    // public void hello(){}  不能重写final方法
}
