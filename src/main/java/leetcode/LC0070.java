package leetcode;

/*****************************************************************************
 * @className: LC0070.java
 * @date : 2020-03-27 10:59
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0070 {
    /**
     * 递归容易栈溢出，超出时间限制
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        return climbStairs(n-1) + climbStairs(n-2);
    }

    public static int climbStairs2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int a = 1, b = 2, c = 0;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }



    public static void main(String[] args) {
        System.out.println(climbStairs2(45));
    }
}
