package leetcode;

/*****************************************************************************
 * @className: LC0877$
 * @date : 2019/6/24$ 11:02$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。

游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
示例：
输入：[5,3,4,5]
输出：true
解释：
亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。

 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0877 {

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 5};
        System.out.println(test(arr));
    }

    private static boolean test(int[] arr) {

        //dp[i][j]表示，在序列i到j中，第一个人在当前时刻比另一个人多的石子数量   (i<=j)
        //如果i==j，dp[i][j] = p [i]
        //如果选择i,比另一人多数量为arr[i]-dp[i+1][j]
        //如果选择j，比另一人多数量为arr[j]-dp[i][j+1]
        //dp[i][j] = Math.max(arr[i] - dp[i+1][j], arr[j] - dp[i][j-1]);

        //要求的结果就是dp[0][arr.length-1]是否大于0


        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i][i] = arr[i];
        }
        for (int j = 1; j < arr.length; j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[i][j] = Math.max(arr[i] - dp[i + 1][j], arr[j] - dp[i][j - 1]);
            }
        }
        return dp[0][arr.length - 1] > 0;
    }

    private static boolean test2(int[] arr){
        //得到 dp[0][1]dp[0][1] 的值之后，就不再需要 dp[0][0] 得值。
        // 同理得到 dp[1][2]的值之后，就不再需要 dp[1][1] 的值。
        // 即每个 j 值对应的一位数组可以覆盖 j-1对应的一位数组，所以只需要一位数组即可得到最终的结果。
        int[] dp = new int[arr.length];
        for (int j = 1; j < arr.length; j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[i] = Math.max(arr[i] - dp[i + 1], arr[j] - dp[i]);
            }
        }
        return dp[0] > 0;
    }

    private static boolean test3(){
        //偶数堆石子，如果只有2堆，选择第一堆，还是第二堆，选择权在第一个人上，肯定能赢
        //如果有4堆，先选择的人可以确定要偶数堆还是奇数堆，总数是奇数个，所以先选择的一定能赢
        //如果有2n堆，无论有多少种解法，找到了一种必赢的情况，不是偶数堆就是奇数堆可控制，就够了
        return true;
    }
}
