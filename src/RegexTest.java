import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*****************************************************************************
 * @className: RegexTest$
 * @date : 2019/4/16$ 15:33$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class RegexTest {
    public static void main(String[] args) {
        String[] arr = {"123第一章123", "第十一章", "第一百一十一章"};
        String regex = ".*第.{1,7}章.*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(arr[0]);
        System.out.println(matcher.matches());

    }
}
