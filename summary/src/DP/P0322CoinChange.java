/**
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 

 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 

 你可以认为每种硬币的数量是无限的。 

 

 示例 1： 

 
输入：coins = [1, 2, 5], amount = 11
输出：3 
解释：11 = 5 + 5 + 1 

 示例 2： 

 
输入：coins = [2], amount = 3
输出：-1 

 示例 3： 

 
输入：coins = [1], amount = 0
输出：0
 

 

 提示： 

 
 1 <= coins.length <= 12 
 1 <= coins[i] <= 2³¹ - 1 
 0 <= amount <= 10⁴ 
 
 Related Topics 广度优先搜索 数组 动态规划 👍 1935 👎 0

*/   
package DP;
/** 
* @author  wbt
* @date    2022-05-17 10:51:45 
*/
public class P0322CoinChange {
   public static void main(String[] args) {        
   Solution solution = new P0322CoinChange().new Solution();   
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int max =Integer.MAX_VALUE;
        int[]dp =new int[amount+1];
        //初始化dp数组的最大值
        for (int i = 1; i < dp.length ; i++) {
            dp[i]=max;
        }
        //当金额为0时需要的硬币数目为0
        dp[0]=0;
        for (int i = 0; i < coins.length ; i++) {
            for (int j = coins[i]; j <=amount ; j++) {
                //只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                if(dp[j-coins[i]]!=max){
                    dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        return dp[amount]==max?-1:dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
