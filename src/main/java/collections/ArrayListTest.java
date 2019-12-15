package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*****************************************************************************
 * @className: Collections.ArrayListTest$
 * @date : 2019/4/15$ 15:56$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        arrayList.add("000");
        arrayList.add("111");
        arrayList.add("222");
        arrayList.add("333");
        List subList = arrayList.subList(0,2);
        arrayList.set(1,"000");
        subList.set(0, "111");
        System.out.println(arrayList.toString());
        System.out.println(subList.toString());

    }

    private static void test1() {
        ArrayList list = new ArrayList();
        list.add(11);
        list.add(11);
    }





}
