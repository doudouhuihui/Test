package j5character;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

/*****************************************************************************
 * @className: UserTest.java
 * @date : 2020-03-19 11:36
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class UserTest {


    private static void valid(Object obj) throws IllegalAccessException {
        Field[] files = obj.getClass().getDeclaredFields();
        for (Field f : files) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(NotEmpty.class)) {
                NotEmpty empty = f.getAnnotation(NotEmpty.class);

                if(StringUtils.isEmpty(f.get(obj))){
                    throw new IllegalAccessException(empty.msg());
                }
            }
        }
    }

    public static void main(String[] args) {
        UserDO use = new UserDO();
        use.setName("hello");
        try {
            valid(use);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(use.getName());

    }
}
