import java.util.*;

/*****************************************************************************
 * @className: ComparableTest$
 * @date : 2019/4/16$ 10:54$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class ComparableTest {
    public static void main(String[] args) {
//        List list = new ArrayList();
//
//        list.add(new CT());
//        Collections.sort(list);
        CT ct1 = new CT();
        CT ct2 = new CT();
        ct1.setLength(10);
        ct2.setLength(8);
        System.out.println(ct1.compareTo(ct2));
        System.out.println(new CTComparator().compare(ct1,ct2));

    }
}
class CT implements Comparable{

    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int compareTo(Object o) {
        return this.length-((CT)o).getLength();
    }
}
class CTComparator implements Comparator<CT>{

    @Override
    public int compare(CT o1, CT o2) {
        return o1.getLength()-o2.getLength();
    }
}
