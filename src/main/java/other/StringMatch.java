package other;

import java.util.Arrays;
import java.util.Objects;

/*****************************************************************************
 * @className: StringMatch.java
 * @date : 2020-01-13 10:08
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class StringMatch {

    public static void main(String[] args) {
        System.out.println(match3("abcdefg", "def"));

        int[] next = getNext("ABCDABD");
        System.out.println(Arrays.toString(next));

    }

    /**
     * [BF暴力破解]
     * @Author: 陈伟振 (chenwz@vvise.com)
     * @Date: 2020-01-13 10:46
     * @param orig 源字符串
     * @param substr 子字符串
     * @return 下标
     */
    public static int match(String orig, String substr) {
        if (!checkStr(orig, substr)) {
            return -1;
        }
        if (substr.isEmpty()) {
            return 0;
        }

        char[] origArr = orig.toCharArray();
        char[] subArr = substr.toCharArray();
        for (int i = 0; i < origArr.length - subArr.length + 1; i++) {
            if (origArr[i] != subArr[0]) {
                continue;
            }
            if (subArr.length == 1) {
                return i;
            }
            for (int j = 1; j < subArr.length; j++) {
                if (origArr[i + j] != subArr[j]) {
                    break;
                }
                if (j == subArr.length - 1) {
                    return i;
                }
            }


        }

        return -1;
    }

    public static int match3(String orig, String substr){
        char[] origArr = orig.toCharArray();
        char[] subArr = substr.toCharArray();
        int i = 0, j = 0;
        while (i < origArr.length && j < subArr.length) {
            if (origArr[i] == subArr[j]) {
                i++;
                j++;
            } else {
                j = 0;
                i = i - j + 1;
            }

            if (j == subArr.length - 1) {
                return i - j;
            }
        }

        return -1;
    }

    /**
     * [校验]
     * @Author: 陈伟振 (chenwz@vvise.com)
     * @Date: 2020-01-13 14:02
     * @param orig 源字符串
     * @param substr 子字符串
     * @return str
     */
    public static boolean checkStr(String orig, String substr){
        if (Objects.isNull(orig) || Objects.isNull(substr)) {
            throw new NullPointerException();
        }

        if (substr.length() > orig.length()) {
            return false;
        }
        return true;
    }

    /**
     * [RK算法]
     * @Author: 陈伟振 (chenwz@vvise.com)
     * @Date: 2020-01-13 13:41
     * @param orig 源字符串
     * @param substr 子字符串
     * @return int
     */
    public static int match2(String orig, String substr){
        if (!checkStr(orig, substr)) {
            return -1;
        }
        if (substr.isEmpty()) {
            return 0;
        }
        int length = substr.length();
        for (int i = 0; i < orig.length() - length + 1; i++) {
            if (orig.substring(i, i + length).equals(substr)) {
                return i;
            }
        }


        return -1;
    }

    private static int[] getNext(String substr){
        char[] subArr = substr.toCharArray();
        int[] next = new int[subArr.length + 1];
        int i = 0, j = -1;
        next[0] = -1;
        while (i < subArr.length) {
            if (j == -1 || subArr[i] == subArr[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }


        return next;
    }
}
