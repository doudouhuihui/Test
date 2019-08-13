package designmode.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/*****************************************************************************
 * @className: SingletonTest1$
 * @date : 2019/7/1$ 9:57$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [饿汉式]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class SingletonTest1 {
    private static SingletonTest1 instance = null;
    private SingletonTest1(){
    }

    public static SingletonTest1 getInstance(){
        if(instance==null){
            instance = new SingletonTest1();

        }
        return instance;
    }


}
class Test1{
    public static void main(String[] args) throws Exception {
        System.out.println(SingletonTest1.getInstance().hashCode());
        //可以反射攻击
        Class clz = Class.forName("designmode.singleton.SingletonTest1");

        Constructor c = clz.getDeclaredConstructor();
        c.setAccessible(true);
        Object o = c.newInstance();

        System.out.println(o.hashCode());




    }
}
