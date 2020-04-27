package other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*****************************************************************************
 * @className: Other.RegexTest$
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

      //  test();

        test2();

   //     test3();

   //     test4();
    }

    private static void test() {
        String str = "1213-12312-12";
        String regex = "\\d{4,6}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.find());
        System.out.println(matcher.find());
        System.out.println(matcher.find());
        matcher.reset();
        System.out.println(matcher.find());
        System.out.println(matcher.find());
        System.out.println(matcher.find());
    }

    private static void test2() {
        String str = "<div>123abc</div><div>456qwe</div>";
        String regex = "<div>(\\d*?)([a-z]*?)</div>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
       // System.out.println(matcher.matches());
       // System.out.println(matcher.find());
       // System.out.println(matcher.groupCount());
        while (matcher.find()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println(matcher.group(i));
            }
        }

    }

    private static void test3() {
        //反向引用
        //匹配xxyy
        System.out.println("xxyy".matches("(\\w)\\1(\\w)\\2"));
        System.out.println("8a8".matches("(\\d)a\\1"));
        System.out.println("8a\1".matches("(\\d)a\1")); //   \1不是对1转义，就是\1字符串

        //分组捕获
        System.out.println("userInfo".replaceAll("([a-z])([A-Z])", "$1_$2"));
        System.out.println("the-first-name".replaceAll("([a-z])-([a-z])", "$1_$2"));




    }
    //非捕获组
    private static void test4() {


        // （?:x）分组并不捕获, 虽然有4个组，但是有两个并没有捕获，所以只有两个
        Pattern p = Pattern.compile("(\\d+)(?:\\.?)(?:\\d+)([￥$])$");
        String str = "8899.99￥";
        Matcher m = p.matcher(str);
        if(m.matches()){
            System.out.println("货币金额: " + m.group(1));
            System.out.println("货币种类: " + m.group(2));
        }





        //     (?=X) 向前查找， 0宽度，并不捕获，下面正则匹配的是前面是两位字母或数字，后面是aa
        //匹配的是32和38，而不是32aa和38aa，因为不捕获不占宽度
        //下次匹配从32/38后的a开始，也是因为不占宽度
         p = Pattern.compile("[0-9a-z]{2}(?=aa)");
         str = "12332aa438aaf";
         m = p.matcher(str);
        while(m.find()){
            System.out.println(m.group());
        }

        //  （?=X）  匹配abc,前面是数字，后面是abcc的子串， 不是abc后的abcc，因为他不占宽度，数字后面直接是abcc了
        // 只有4abcc满足
        p = Pattern.compile("\\d(?=abc)abcc");
        str = "123abc124abccc";
        m = p.matcher(str);
        while(m.find()){
            System.out.println(m.group());
        }

        // (?<=X) 向后查找， 匹配abc，后面是数字的子串，不包括abc，因为不捕获
        p = Pattern.compile("c(?<=abc)\\d");
        str = "123abc124abc69";
        m = p.matcher(str);
        while(m.find()){
            System.out.println(m.group());
        }

        // （?!x） 向后查找，不等于x的
        // 匹配前面不是ab，后面紧跟着数字的子串
        p = Pattern.compile("(?!ab)\\d");
        str = "123abc124abc69";
        m = p.matcher(str);
        while(m.find()){
            System.out.println(m.group());
        }

        System.out.println("------------------");
        // (?<!x)  向前查找，不等于x的
        //匹配前面是数字，后面紧跟着不是ab的子串
        p = Pattern.compile("\\d(?<!ab)");
        str = "123abc124abc69";
        m = p.matcher(str);
        while(m.find()){
            System.out.println(m.group());
        }



    }

}
