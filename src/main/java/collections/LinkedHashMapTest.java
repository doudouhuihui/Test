package collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/*****************************************************************************
 * @className: Collections.LinkedHashMapTest$
 * @date : 2019/4/15$ 14:17$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map linkedHashMap = new LinkedHashMap<String, String>(16, .75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String,String> eldest) {
                if(size()>5){
                    return true;
                }
                return false;
            }
        };
        linkedHashMap.put("1","11");
        linkedHashMap.put("2","11");
        linkedHashMap.put("3","11");
        linkedHashMap.put("4","11");
        linkedHashMap.put("5","11");
        linkedHashMap.put("6","11");
        linkedHashMap.put("7","11");
        linkedHashMap.get("3");

        Iterator iterator = linkedHashMap.keySet().iterator();
        while (iterator.hasNext()){

            iterator.next();
            iterator.remove();
            iterator.remove();
        }

            System.out.println();

    }
}
class LRU<K, V> extends LinkedHashMap<K, V>{
    public LRU(){
        super();
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        if(size()>4){
            return true;
        }
        return false;
    }
}
