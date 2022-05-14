/**
<p>给你一个整数数组 <code>nums</code> 和一个整数 <code>target</code> 。</p>

<p>向数组中的每个整数前添加 <code>'+'</code> 或 <code>'-'</code> ，然后串联起所有整数，可以构造一个 <strong>表达式</strong> ：</p>

<ul>
	<li>例如，<code>nums = [2, 1]</code> ，可以在 <code>2</code> 之前添加 <code>'+'</code> ，在 <code>1</code> 之前添加 <code>'-'</code> ，然后串联起来得到表达式 <code>"+2-1"</code> 。</li>
</ul>

<p>返回可以通过上述方法构造的、运算结果等于 <code>target</code> 的不同 <strong>表达式</strong> 的数目。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,1,1,1], target = 3
<strong>输出：</strong>5
<strong>解释：</strong>一共有 5 种方法让最终目标和为 3 。
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1], target = 1
<strong>输出：</strong>1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 20</code></li>
	<li><code>0 <= nums[i] <= 1000</code></li>
	<li><code>0 <= sum(nums[i]) <= 1000</code></li>
	<li><code>-1000 <= target <= 1000</code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>动态规划</li><li>回溯</li></div></div><br><div><li>👍 1205</li><li>👎 0</li></div>
*/   
package DP;

import java.util.Arrays;

/**
* @author  wbt
* @date    2022-05-14 09:34:18 
*/
public class P0494TargetSum {
   public static void main(String[] args) {        
   Solution solution = new P0494TargetSum().new Solution();   
    }
    /*本题要如何使表达式结果为target，
   既然为target，那么就一定有 left组合 - right组合 = target。
   left + right等于sum，而sum是固定的。
   公式 left - (sum - left) = target -> left = (target + sum)/2 。
   target是固定的，sum是固定的，left就可以求出来。此时问题就是在集合nums中找出和为left的组合。
   如何转化为01背包问题呢。
   假设加法的总和为x，那么减法对应的总和就是sum - x。
   所以我们要求的是 x - (sum - x) = S ,x = (S + sum) / 2
   此时问题就转化为，装满容量为x背包，有几种方法
   * */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        target=Math.abs(target);
        if(target>sum)return 0;
        if((target+sum)%2==1)return 0;
        int bagSize=(target+sum)/2;
        int []dp=new int[bagSize+1];
        dp[0]=1;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = bagSize; j>=nums[i]; j--) {
                dp[j]+=dp[j-nums[i]];
            }

        }
        return dp[bagSize];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
