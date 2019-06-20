package array;

import java.util.Arrays;
import java.util.List;

/*****************************************************************************
 * @className: ArrayToList$
 * @date : 2019/6/11$ 10:48$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class ArrayToListTest {
    public static void main(String[] args) {
        //坑！int是基本类型，集合存的是对象，所以list存的是arr数组对象，size为1
        int[] arr = {1,2,3,4};
        List list = Arrays.asList(arr);
        System.out.println(list.size());
        System.out.println(arr);
        System.out.println(list.get(0));

        //坑，数组转化的list不是我们平时用的ArrayList而是Arrays的内部类ArrayList
        //他俩用的同一个引用，改变一个，另一个随之改变，这点和subList有异曲同工之妙
        String[] strArr = {"123","456"};
        List list2 = Arrays.asList(strArr);
        System.out.println(list2.size());
        System.out.println(list2.get(0)+"----"+list2.get(1));
        strArr[1]="000";
        System.out.println(list2.get(0)+"----"+list2.get(1));
        list2.set(0,"111");
        System.out.println(strArr[0]+"----"+strArr[1]);

        //坑，这个内部类的ArrayList是个定长的集合，不支持add,remove操作，下面操作会报错
        List list3 = Arrays.asList(strArr);
        list3.add("222");
        System.out.println(list3.toString());

    }
}
