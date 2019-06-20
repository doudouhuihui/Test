package leetcode;

import java.util.Arrays;

/*****************************************************************************
 * @className: LC0151$
 * @date : 2019/6/20$ 17:33$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [给定一个字符串，逐个翻转字符串中的每个单词。
示例 1：
输入: "the sky is blue"
输出: "blue is sky the"
示例 2：
输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：
输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
说明：
无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0151 {

    /**
     * 思路：1.先去掉前后空格
     * 2.用空格分成数组
     * 3.去掉为空的元素
     * 4，逆序拼接
     * @param args
     */
    public static void main(String[] args) {
        String str = "   I            am   chen! ";
        //System.out.println(str.split(" ").length);
        String reverse = reverseWords(str);
        System.out.println(reverse);
    }

    /**
     * 内存消耗 :36.5 MB, 在所有 Java 提交中击败了98.68%的用户
     * 执行用时 :4 ms, 在所有 Java 提交中击败了96.56%的用户
     * 实际中用stringbuffer/builder
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split(" ");
        int length = arr.length;
        String res = "";
        if(length>0){
            if(length==1){
                return arr[0];
            }
            for (int i = length-1; i >=0; i--){
                if(arr[i].trim().length()!=0){
                    res+=arr[i]+" ";
                }
            }

        }
        return res.trim();
    }
}
