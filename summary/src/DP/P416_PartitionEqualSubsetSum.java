/**
  * 题目Id：416
  * 题目：分割等和子集
  * 日期：2022-05-06 12:41:15
*/
//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
// 示例 1：
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。
// 示例 2：
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 提示：
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 1290 👎 0

package DP;

//分割等和子集

import java.util.Arrays;

public class P416_PartitionEqualSubsetSum {
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P416_PartitionEqualSubsetSum().new Solution();
	 }
//力扣代码
/*用01背包解题
* 分析：背包的体积为sum / 2
		背包要放入的商品（集合里的元素）重量为 元素的数值，价值也为元素的数值
		背包如果正好装满，说明找到了总和为 sum / 2 的子集。
		背包中每一个元素是不可重复放入。
* */
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
		int	sum= Arrays.stream(nums).sum();
		if(sum%2==1) {
			return false;
		}
		int target =sum/2;

		int []dp=new int[target+1];
		for (int i = 0; i <nums.length ; i++) {
			for(int j=target;j>=nums[i];j--){
				dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
			}
		}
		return dp[target]==target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
