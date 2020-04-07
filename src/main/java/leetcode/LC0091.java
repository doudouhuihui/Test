package leetcode;

/*****************************************************************************
 * @className: LC0091.java
 * @date : 2020-03-30 15:34
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0091 {
    public static void main(String[] args) {
        System.out.println(numDecodings("12123412312"));

    }
    public static int numDecodings(String s) {
        char[] chs = s.toCharArray();
        int count = 1;
        for (int i = 0; i < chs.length - 1; i++) {
            if ((chs[i] > '2') || (chs[i] >= '2' && chs[i+1] > '6')) {
                continue;
            }
            count++;
        }

        return count;
    }
}
