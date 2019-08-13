package leetcode;

/*****************************************************************************
 * @className: LC1137$
 * @date : 2019/8/6$ 15:48$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [泰波那契序列 Tn 定义如下： 
T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
示例 1：
输入：n = 4
输出：4
解释：
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
示例 2：
输入：n = 25
输出：1389537
 
提示：
0 <= n <= 37
答案保证是一个 32 位整数，即 answer <= 2^31 - 1。]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC1137 {
    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }

    //如果使用递归会栈溢出
    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int i = 0, j = 1, k = 1;
        int res = 0;
        for (int m = 2; m < n; m++) {
            res = i + j + k;
            i = j;
            j = k;
            k = res;
        }
        return res;
    }
}
