package j8character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*****************************************************************************
 * @className: OptionalTest$
 * @date : 2019/5/6$ 10:25$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class OptionalTest
{
    public static void main(String[] args) {

        //创建空的OPTIONAL
        //抛异常 java.util.NoSuchElementException: No value present
        //Optional<User> opt = Optional.empty();
        //User user = opt.get();
        //System.out.println(user);

        //

        String s = "abc";
        System.out.println(s.chars().reduce(Integer::sum).getAsInt());

        List<String> list = new ArrayList<String>(){{
            add("111");
            add("222");
            add("111");
        }
        };
        list = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list);
        int i = 1;
        System.out.println(i++ + ++i  + i--);
        Collections.shuffle(list);
        int[] arr = {1,2,3};
        int[] arr1 = arr.clone();
        System.out.println(Arrays.toString(arr1));

    }
}
class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
