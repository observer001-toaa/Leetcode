/**
<p>给你一个二进制字符串数组 <code>strs</code> 和两个整数 <code>m</code> 和 <code>n</code> 。</p>

<div class="MachineTrans-Lines">
<p class="MachineTrans-lang-zh-CN">请你找出并返回 <code>strs</code> 的最大子集的长度，该子集中 <strong>最多</strong> 有 <code>m</code> 个 <code>0</code> 和 <code>n</code> 个 <code>1</code> 。</p>

<p class="MachineTrans-lang-zh-CN">如果 <code>x</code> 的所有元素也是 <code>y</code> 的元素，集合 <code>x</code> 是集合 <code>y</code> 的 <strong>子集</strong> 。</p>
</div>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
<strong>输出：</strong>4
<strong>解释：</strong>最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>strs = ["10", "0", "1"], m = 1, n = 1
<strong>输出：</strong>2
<strong>解释：</strong>最大的子集是 {"0", "1"} ，所以答案是 2 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= strs.length &lt;= 600</code></li>
	<li><code>1 &lt;= strs[i].length &lt;= 100</code></li>
	<li><code>strs[i]</code>&nbsp;仅由&nbsp;<code>'0'</code> 和&nbsp;<code>'1'</code> 组成</li>
	<li><code>1 &lt;= m, n &lt;= 100</code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 720</li><li>👎 0</li></div>
*/   
package DP;
/** 
* @author  wbt
* @date    2022-05-14 10:17:07 
*/
public class P0474OnesAndZeroes {
   public static void main(String[] args) {        
   Solution solution = new P0474OnesAndZeroes().new Solution();   
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]：最多有i个0和j个1的strs的最大子集的大小为dp[i][j]
        int [][]dp=new int[m+1][n+1];
        int oneNum,zeroNum;
        for(String str:strs){
            oneNum=0;
            zeroNum=0;
            for (char c:str.toCharArray()){
                if(c=='0')zeroNum++;
                else oneNum++;
            }
            //倒序遍历
            for (int i = m; i >=zeroNum; i--) {
                for (int j = n; j >=oneNum ; j--) {
                    dp[i][j]=Math.max(dp[i][j],dp[i-zeroNum][j-oneNum]+1);
                }
            }
        }
        return  dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
