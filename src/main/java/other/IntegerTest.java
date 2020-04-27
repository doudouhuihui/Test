package other;

import java.util.Objects;

/*****************************************************************************
 * @className: Other.IntegerTest$
 * @date : 2019/4/16$ 17:56$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class IntegerTest {

    private boolean flag = true;
    private int a = 1;
    private double d = 1.25;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerTest that = (IntegerTest) o;
        return flag == that.flag &&
                a == that.a &&
                Double.compare(that.d, d) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flag, a, d);
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(19));
        int a = 200;
        Integer i = 200;
        Integer i1 = 200;
        System.out.println(i==i1);
        System.out.println(new IntegerTest().hashCode());
    }
}
