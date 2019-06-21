package leetcode;

/*****************************************************************************
 * @className: LC0121$
 * @date : 2019/6/21$ 11:44$
 * @author : 陈伟振   (chenweizhen@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc :
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
注意你不能在买入股票前卖出股票。
示例 1:
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
示例 2:
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class LC0121 {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit2(arr));
    }

    /**
     * 读题后，找到三个因素

     天数，交易次数，是否持有股票
     用三维数组表示就是
     dp[i][k][f]    (0=<i<=n-1)(0<k<K)(f=0 or 1)
     表示第i+1天，只允许k次交易，当天是/否持有股票

     那么利润最大最后一天就是
     dp[i-1][K][0],最后一位为0表示卖出去了，肯定比dp[i-1][K][1]利润高，同时交易次数可从买入时候-1，或者卖出时候-1

     每天利润公式就是

     dp[i][k][0] = max(dp[i-1][k][0] , dp[i-1][k][1] + price[i]);
     解读：今天没持有股票，可能是昨天就没有，今天也没买，也可能是昨天有，今天卖出去了,两者利润取最大值

     dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - price[i])
     解读：今天持有股票，可能昨天就持有，今天没卖，也可能是昨天没有，今天买的，在这里k-1代表买入时交易次数-1

     base case:
     dp[-1][k][0] = 0
     还没开始，利润为0
     dp[-1][k][1] = -infinity
     还没开始，不可能有股票，-infinity表示负无穷，不可能
     dp[i][0][0] = 0
     k为0，表示没有交易，为0
     dp[i][0][1] = -infinity
     不允许交易是不可能持有股票，-infinity

     掌握了状态公式和基本情况，类似递归，可以开始了
     这题k=1,
     dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
     dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
     由base case化简，同时k恒等于1，已经不影响状态了，可以去掉
     dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     dp[i][1] = max(dp[i-1][1], -prices[i])

     直接写出代码：

     int n = prices.length;
     int[][] dp = new int[n][2];
     for (int i = 0; i < n; i++) {
     dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
     dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
     }
     return dp[n - 1][0];

     发现当i=0时会越界
     用自然语言解读:
     第一天时没有股票，不可能是昨天卖的，只能是今天没买
     dp[i][0] = 0
     第一天时有股票，不可能是昨天买的，只能是今天买的
     dp[i][1] = -price[i];

     最终代码如下：
     int[][] dp = new int[prices.length][2];
     for (int i = 0; i< prices.length;i++) {
     if(i==0){
     dp[i][0] = 0;
     dp[i][1] = -prices[i];
     continue;
     }
     dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
     dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
     }
     return dp[prices.length-1][0];

     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if(prices.length==0)return 0;
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i< prices.length;i++) {
            if(i==0){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[prices.length-1][0];
    }


    private static int maxProfit2(int[] prices){
        if(prices.length==0)return 0;
        int a = 0, b = Integer.MIN_VALUE;
        for(int i = 0; i< prices.length;i++){
            a = Math.max(a,b+prices[i]);
            b = Math.max(b,-prices[i]);
        }
        return a;
    }
}
