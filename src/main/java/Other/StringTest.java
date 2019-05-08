package Other;


/*****************************************************************************
 * @className: Other.StringTest$
 * @date : 2019/4/16$ 17:37$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class StringTest {
    public static void main(String[] args) throws Exception {
        String s = "这是一个？";
        System.out.println(s.getBytes("gb2312").length);
    }
}
