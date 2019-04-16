import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/*****************************************************************************
 * @className: TreeMapTest$
 * @date : 2019/4/15$ 11:26$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(1,"Str");
        treeMap.put(3,"Str");
        treeMap.put(2,"Str");
        treeMap.put(4,"Str");
        System.out.println(treeMap.size());
        Set entrySet = treeMap.entrySet();
        System.out.println(entrySet.getClass());
        Iterator iterator = entrySet.iterator();
        System.out.println(iterator.getClass());
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
class St implements Comparable{
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
