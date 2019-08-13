package j5character;

import java.lang.annotation.*;

/*****************************************************************************
 * @className: MyField$
 * @date : 2019/7/9$ 11:13$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MyField {
    String value() default "" ;
    boolean flag() default false;
    int type() default 0;
}
