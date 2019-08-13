package other;

import java.util.Date;
import java.util.Stack;

/*****************************************************************************
 * @className: StirngReverse$
 * @date : 2019/6/10$ 10:28$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [字符串反转的几种方法]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class StringReverse {
    public static void main(String[] args) {
        String str = "hello world";
        long start = System.currentTimeMillis();
        System.out.println(reverse1(str));
        System.out.println("递归：" + (new Date().getTime() - start));

        start = System.currentTimeMillis();
        System.out.println(reverse2(str));
        System.out.println("charAt逆序遍历：" + (new Date().getTime() - start));

        start = System.currentTimeMillis();
        System.out.println(reverse3(str));
        System.out.println("char数组逆序遍历：" + (new Date().getTime() - start));

        start = System.currentTimeMillis();
        System.out.println(reverse4(str));
        System.out.println("StringBuffer/Builder自带方法：" + (new Date().getTime() - start));

        start = System.currentTimeMillis();
        System.out.println(reverse5(str));
        System.out.println("char数组首尾对调：" + (new Date().getTime() - start));

        start = System.currentTimeMillis();
        System.out.println(reverse6(str));
        System.out.println("char数组首尾对调异或：" + (new Date().getTime() - start));

        start = System.currentTimeMillis();
        System.out.println(reverse7(str));
        System.out.println("char数组进出栈：" + (new Date().getTime() - start));
    }

    /**
     * 递归
     *
     * @param str
     * @return
     */
    private static String reverse1(String str) {
        if (str.length() <= 1) {
            return str;
        }
        String left = str.substring(0, str.length() / 2);
        String right = str.substring(str.length() / 2, str.length());
        return reverse1(right) + reverse1(left);
    }


    /**
     * charAt遍历拼接
     *
     * @param str
     * @return
     */
    private static String reverse2(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        return reverse;
    }

    /**
     * 和第二个方法类似，要快一点，因为不用调用方法
     *
     * @param str
     * @return
     */
    private static String reverse3(String str) {
        char[] chs = str.toCharArray();
        String reverse = "";
        for (int i = chs.length - 1; i >= 0; i--) {
            reverse += chs[i];
        }
        return reverse;
    }

    /**
     * 强烈推荐，速度最快，写法最简单
     *
     * @param str
     * @return
     */
    private static String reverse4(String str) {
        return new StringBuffer(str).reverse().toString();
    }

    /**
     * 3的改进，数组首尾对调，也不错
     *
     * @param str
     * @return
     */
    private static String reverse5(String str) {
        char[] chs = str.toCharArray();
        int n = chs.length - 1;
        int middle = chs.length / 2;
        for (int i = 0; i < middle; i++) {
            char temp = chs[i];
            chs[i] = chs[n - i];
            chs[n - i] = temp;
        }
        return new String(chs);
    }

    /**
     * 和上面5类似，原先的首尾交换转为数字异或交换
     *
     * @param str
     * @return
     */
    private static String reverse6(String str) {
        char[] chs = str.toCharArray();
        int begin = 0;
        int end = chs.length - 1;
        while (begin < end) {
            chs[begin] = (char) (chs[begin] ^ chs[end]);
            chs[end] = (char) (chs[begin] ^ chs[end]);
            chs[begin] = (char) (chs[begin] ^ chs[end]);
            begin++;
            end--;
        }
        return new String(chs);
    }

    /**
     * 比较慢，涉及拆装箱，数据结构
     *
     * @param str
     * @return
     */
    private static String reverse7(String str) {
        char[] chs = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chs) {
            stack.push(c);
        }
        String reverse = "";
        for (char c : chs) {
            reverse += stack.pop();
        }
        return reverse;
    }
}
