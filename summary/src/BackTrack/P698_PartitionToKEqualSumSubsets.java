/**
  * 题目Id：698
  * 题目：划分为k个相等的子集
  * 日期：2022-05-07 08:17:23
*/
//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 
//
// 示例 1： 
//
// 
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4], k = 3
//输出: false 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 每个元素的频率在 [1,4] 范围内 
// 
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 
// 👍 550 👎 0


package BackTrack;

//划分为k个相等的子集

import java.util.Arrays;

public class P698_PartitionToKEqualSumSubsets {
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P698_PartitionToKEqualSumSubsets().new Solution();
	 }

	//leetcode submit region end(Prohibit modification and deletion)
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution{
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum=0;
		boolean[] used=new boolean[nums.length];
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++)
		{
			sum+=nums[i];
		}
		if(sum%k!=0) {
			return false;
		}
		int target=sum/k;
		if(nums[nums.length-1]>target) {
			return false;
		}
		return dfs(nums,nums.length-1,target,0,k,used);
	}

	public boolean dfs(int[] nums,int begin,int target,int curSum,int k,boolean[] used)
	{
		//剪枝1
		if(k==1) {
			return true;
		}
		if(curSum==target) {
			return dfs(nums,nums.length-1,target,0,k-1,used);//找到了一个组合,还有k-1个.
		}
		//剪枝4
		for(int i=begin;i>=0;i--)
		{
			//使用过的元素就不能再使用了
			if(used[i]) {
				continue;
			}
			//剪枝2
			if(curSum+nums[i]>target) {
				continue;
			}
			used[i]=true;//添加元素nums[i]
			if(dfs(nums,i-1,target,curSum+nums[i],k,used)) {
				return true;//如果添加这个元素后，完成了题目要求，就return true.
			}
			used[i]=false;//回溯
			while(i>0&&nums[i-1]==nums[i])//剪枝3
			{
				i--;
			}
		}
		return false;
	}
}

//leetcode submit region end(Prohibit modification and deletion)

}
