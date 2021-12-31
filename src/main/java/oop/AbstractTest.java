package oop;

public abstract  class AbstractTest { //有抽象方法必定是抽象类

    public abstract void say();

    public void hello(){}; //可以有非抽象方法

//    public static abstract void run(); static和abstract冲突不能一起修饰，final同理
}
