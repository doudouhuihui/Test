package other;


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
    public static void main(String[] args) throws Exception {
        String s = "这是一个？";
        System.out.println(s.getBytes("utf-8").length);


        //split方法
        System.out.println(Arrays.toString("/".split("/")));

        System.out.println(Arrays.toString("/1".split("/")));

        System.out.println(Arrays.toString("1/".split("/")));

        System.out.println(Arrays.toString("/1/".split("/")));

        System.out.println(Arrays.toString("///".split("/")));

        System.out.println(Arrays.toString("///,".split("/")));

        //replace
        System.out.println("helloworld-java".replace("world-","."));
        System.out.println("helloworld-java".replaceAll("l{2,}","."));
        System.out.println("123123123".replace("1","+"));
        System.out.println("123123123".replaceAll("1*","+"));
        System.out.println("123123123".replaceFirst("\\d","+"));




        for(int i = 0; i < 100; i++){

        }







    }
}
