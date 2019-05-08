package collections;

import java.util.TreeSet;

/*****************************************************************************
 * @className: Collections.TreeSetTest$
 * @date : 2019/4/15$ 11:35$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class TreeSetTest {
    public static void main(String[] args) {
        //TS可以不用实现comparable接口，但是必须定义一个比较器
        TreeSet<TS> treeSet = new TreeSet((o1,o2)->
        ((TS)o1).getLength() - ((TS)o2).getLength()
        );
        treeSet.add(new TS(5));
        treeSet.add(new TS(1));
        treeSet.add(new TS(3));

    }
}
class TS{
    private int length;
    public TS(){}
    public TS(int length){
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
