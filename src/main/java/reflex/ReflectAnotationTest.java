package reflex;

import java.lang.annotation.*;

/*****************************************************************************
 * @className: ReflectAnotationTest$
 * @date : 2019/7/9$ 14:05$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class ReflectAnotationTest {
    public static void main(String[] args) {
        RAT rat = new RAT();
        Class cls = rat.getClass();
        Annotation[] annotations = cls.getDeclaredAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a);
        }
        Annotation a = cls.getAnnotation(init.class);
        System.out.println(a);
    }


}
@init
@destroy
class RAT {

    private String name;
}
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface init {
    String value() default "";
}
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface destroy {
}
