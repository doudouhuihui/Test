package oop;

import java.io.IOException;

public class OverrideTest {
    public static void main(String[] args) {
        Father f = new Son();
        f.say();  //���õ��Ǹ����

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
     public static void say(){  //static������д�����ǿ�������
        System.out.println("son");
    }
    @Override  //��������Ȩ�޴��ڵ��ڸ��෽��
    public void sing(){}

    @Override  //��������С�ڵ��ڸ��෽��
    public Son get(){return null;}

    @Override //�쳣����С�ڵ��ڸ����쳣
    public  void speak() throws Exception{}

    // public void hello(){}  ������дfinal����
}
