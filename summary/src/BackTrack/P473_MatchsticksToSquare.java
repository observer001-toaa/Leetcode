/**
  * 题目Id：473
  * 题目：火柴拼正方形
  * 日期：2022-05-08 10:15:46
*/
//你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能
//折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。 
//
// 如果你能使这个正方形，则返回 true ，否则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: matchsticks = [1,1,2,2,2]
//输出: true
//解释: 能拼成一个边长为2的正方形，每边两根火柴。
// 
//
// 示例 2: 
//
// 
//输入: matchsticks = [3,3,3,3,4]
//输出: false
//解释: 不能用所有火柴拼成一个正方形。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= matchsticks.length <= 15 
// 1 <= matchsticks[i] <= 108 
// 
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 
// 👍 262 👎 0


package BackTrack;

//火柴拼正方形

import java.util.Arrays;

public class P473_MatchsticksToSquare {
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P473_MatchsticksToSquare().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean makesquare(int[] matchsticks) {
		int sum=0;
		boolean[] used=new boolean[matchsticks.length];
		Arrays.sort(matchsticks);
		for(int i=0;i<matchsticks.length;i++)
		{
			sum+=matchsticks[i];
		}
		if(sum%4!=0) {
			return false;
		}
		int target=sum/4;
		if(matchsticks[matchsticks.length-1]>target) {
			return false;
		}
		return dfs(matchsticks,matchsticks.length-1,target,0,4,used);
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
