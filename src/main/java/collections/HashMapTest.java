package collections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/*****************************************************************************
 * @className: Collections.HashMapTest$
 * @date : 2019/4/9$ 17:07$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class HashMapTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HashMap<String, String> hashMap = new HashMap<>();
        Class<?> mapType = hashMap.getClass();
        Method method = mapType.getDeclaredMethod("capacity");
        method.setAccessible(true);
        System.out.println(method.invoke(hashMap));
        System.out.println();
        for (int i = 0; i < 10; i++) {
            hashMap.put(Integer.toString(i)+"--"+ new Random().nextInt(100), Integer.toString(i));
        }
        //
        Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("------------------");
        //
        Set<String> keySet = hashMap.keySet();
        Iterator<String> iterator1 = keySet.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        System.out.println("-------------------");
        //
        Collection<String> collection = hashMap.values();
        Iterator<String> iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}
