/**
给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。 

 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 

 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 

 

 示例 1： 

 
输入：k = 2, prices = [2,4,1]
输出：2
解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 

 示例 2： 

 
输入：k = 2, prices = [3,2,6,5,0,3]
输出：7
解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。 


 

 提示： 

 
 0 <= k <= 100 
 0 <= prices.length <= 1000 
 0 <= prices[i] <= 1000 
 
 Related Topics 数组 动态规划 👍 729 👎 0

*/   
package DP;
/** 
* @author  wbt
* @date    2022-05-21 10:59:16 
*/
public class P0188BestTimeToBuyAndSellStockIv {
   public static void main(String[] args) {        
   Solution solution = new P0188BestTimeToBuyAndSellStockIv().new Solution();   
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices==null||prices.length==0)return 0;
        // [天数][交易次数][是否持有股票]
        int len=prices.length;
        int[][][]dp=new int [len][k+1][2];

        // dp数组初始化
        // 初始化所有的交易次数是为确保 最后结果是最多 k 次买卖的最大利润
        for (int i = 0; i <=k ; i++) {
            dp[0][i][1]=-prices[0];
        }
        for (int i = 1; i <len ; i++) {
            for (int j = 1; j <=k ; j++) {
                // dp方程, 0表示不持有/卖出, 1表示持有持有/买入
                dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
            }
        }
        return dp[len-1][k][0];
    }
}
    //版本三：一维 dp数组
    class Solution1 {
        public int maxProfit(int k, int[] prices) {
            if(prices.length == 0){
                return 0;
            }
            if(k == 0){
                return 0;
            }
            // 其实就是123题的扩展，123题只用记录2次交易的状态
            // 这里记录k次交易的状态就行了
            // 每次交易都有买入，卖出两个状态，所以要乘 2
            int[] dp = new int[2 * k];
            // 按123题解题格式那样，做一个初始化
            for(int i = 0; i < dp.length / 2; i++){
                dp[i * 2] = -prices[0];
            }
            for(int i = 1; i <= prices.length; i++){
                dp[0] = Math.max(dp[0], -prices[i - 1]);
                dp[1] = Math.max(dp[1], dp[0] + prices[i - 1]);
                // 还是与123题一样，与123题对照来看
                // 就很容易啦
                for(int j = 2; j < dp.length; j += 2){
                    dp[j] = Math.max(dp[j], dp[j - 1] - prices[i-1]);
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + prices[i - 1]);
                }
            }
            // 返回最后一次交易卖出状态的结果就行了
            return dp[dp.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
