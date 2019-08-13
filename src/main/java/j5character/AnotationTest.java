package j5character;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*****************************************************************************
 * @className: AnotationTest$
 * @date : 2019/7/9$ 11:13$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [使用属性注解给属性赋值]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class AnotationTest {
    public static void main(String[] args) {
        Annimal annimal = FactoryTest.fieldReject();
        System.out.println(annimal.getName());
        System.out.println(annimal.getAge());

        annimal = FactoryTest.methodReject();
        System.out.println(annimal.getName());
        System.out.println(annimal.getAge());
    }
}
class FactoryTest{
    /**
     * 通过属性赋值
     * @return
     */
    public static Annimal fieldReject(){
        Annimal annimal = new Annimal();
        Field[] fields = annimal.getClass().getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(MyField.class)) {
                MyField myField = f.getAnnotation(MyField.class);
                f.setAccessible(true);
                try {
                    f.set(annimal, myField.value());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return annimal;
    }

    /**
     * 通过方法赋值
     * @return
     */
    public static Annimal methodReject(){
        Annimal annimal = new Annimal();
        Method[] methods = annimal.getClass().getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(MyMethod.class)) {
                MyMethod myMethod = m.getAnnotation(MyMethod.class);
                try {
                    m.invoke(annimal, myMethod.value());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return annimal;
    }

}
class Annimal{
    @MyField(value = "chenwz",flag = true)
    private String name;
    @MyField(value = "22",flag = false)
    private String age;

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @MyMethod("20")
    public void setAge(String age) {
        this.age = age;
    }
    @MyMethod("CHENWZ")
    public void setName(String name) {
        this.name = name;
    }
}


