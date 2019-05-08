package collections;

import java.util.*;

/*****************************************************************************
 * @className: Collections.HashTableTest$
 * @date : 2019/4/9$ 9:18$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class HashTableTest {
    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable();
        for (int i = 0; i < 10; i++) {
            hashtable.put(Integer.toString(i)+"--"+ new Random().nextInt(100), Integer.toString(i));
        }
        //第一种entrySet
        Set<Map.Entry<String, String>> entrySet = hashtable.entrySet();
        System.out.println(entrySet.getClass());
        System.out.println(entrySet.iterator().getClass());
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("--------2---------");
        //第二种keySet
        Set<String> set = hashtable.keySet();
        Iterator<String> iterator1 = set.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        System.out.println("-------3--------");
        //第三种values
        Collection<String> collection = hashtable.values();
        Iterator<String> iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
        System.out.println("--------4---------");
        //第四种keys
        Enumeration<String> enumeration = hashtable.keys();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
        System.out.println("---------5---------");
        //第五种elements
        Enumeration<String> enumeration1 = hashtable.elements();
        while (enumeration1.hasMoreElements()) {
            System.out.println(enumeration1.nextElement());
        }








    }
}
