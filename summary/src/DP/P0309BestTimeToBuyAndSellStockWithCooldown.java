/**
给定一个整数数组 prices，其中第 prices[i] 表示第 i 天的股票价格 。 

 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 

 
 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
 

 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 

 

 示例 1: 

 
输入: prices = [1,2,3,0,2]
输出: 3 
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 

 示例 2: 

 
输入: prices = [1]
输出: 0
 

 

 提示： 

 
 1 <= prices.length <= 5000 
 0 <= prices[i] <= 1000 
 
 Related Topics 数组 动态规划 👍 1214 👎 0

*/   
package DP;
/** 
* @author  wbt
* @date    2022-05-21 11:16:38 
*/
public class P0309BestTimeToBuyAndSellStockWithCooldown {
   public static void main(String[] args) {        
   Solution solution = new P0309BestTimeToBuyAndSellStockWithCooldown().new Solution();   
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        /*
            状态一：买入股票状态（今天买入股票，或者是之前就买入了股票然后没有操作）
            卖出股票状态，这里就有两种卖出股票状态
            状态二：两天前就卖出了股票，度过了冷冻期，一直没操作，今天保持卖出股票状态
            状态三：今天卖出了股票
            状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有一天！
         */
        if(prices==null || prices.length<2)return 0;
        int n=prices.length;
        int[][]dp=new int[n][4];

        dp[0][0]=-prices[0];
        for (int i = 1; i <n; i++) {
            dp[i][0]=Math.max(dp[i-1][0],Math.max(dp[i-1][3],dp[i-1][1])-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][3]);
            dp[i][2]=dp[i-1][0]+prices[i];
            dp[i][3]=dp[i-1][2];
        }
        return  Math.max(dp[n-1][3],Math.max(dp[n-1][2],dp[n-1][1]));

    }
}
    class Solution1 {
        public int maxProfit(int[] prices) {
        /*
        int n=prices.length;
        int[][] dp=new int[n][3];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[0][2]=0;
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]);//不持有或者冷冻期
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);//之前买或者今天买
            dp[i][2]=dp[i-1][1]+prices[i];//前一天卖了，进入冷冻期
        }
        return Math.max(dp[n-1][0],dp[n-1][2]);
        */
            //状态压缩
            int buy=-prices[0],cool=0,sell=0;
            for(int i=1;i<prices.length;i++){
                buy=Math.max(buy,sell-prices[i]);
                sell=Math.max(sell,cool);
                cool=buy+prices[i];
            }
            return Math.max(sell,cool);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
