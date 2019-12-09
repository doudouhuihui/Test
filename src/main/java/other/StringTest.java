package other;


import java.io.UnsupportedEncodingException;
import java.util.Arrays;

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
    public static void main(String[] args) {


        testIntern();


    }

    private static void testIntern() {

        System.out.println(new String("11"));

        String s1 = "java";
        String s2 = "ja" + "va";
        String s3 = new String("java");
        String s4 = "ja";
        String s5 = "va";
        String s6 = s4 + s5;
        String s7 = new String("ja") + new String("va");
        String s8 = new StringBuilder().append("java").toString();

        System.out.println(s1 == s2);  //true
        System.out.println(s1 == s3);  //false
        System.out.println(s1 == s6);   //false
        System.out.println(s1 == s7);   //false
        System.out.println(s7.intern() == s1);
        System.out.println(s7.intern() == s7);



    }

    private static void testGetBytes() {
        String s = "这是一个？";
        try {
            System.out.println(s.getBytes("utf-8").length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static void testSplit() {
        //split方法
        System.out.println(Arrays.toString("/".split("/")));

        System.out.println(Arrays.toString("/1".split("/")));

        System.out.println(Arrays.toString("1/".split("/")));

        System.out.println(Arrays.toString("/1/".split("/")));

        System.out.println(Arrays.toString("///".split("/")));

        System.out.println(Arrays.toString("///.".split("/")));

    }

    public static void testReplace() {

        //replace
        System.out.println("helloworld-java".replace("world-", "."));
        System.out.println("helloworld-java".replaceAll("l{2,}", "."));
        System.out.println("123123123".replace("1", "+"));
        System.out.println("123123123".replaceAll("1*", "+"));
        System.out.println("123123123".replaceFirst("\\d", "+"));
    }
}
