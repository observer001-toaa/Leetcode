/**
给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。 

 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 

 

 示例 1： 

 
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 

 示例 2： 

 
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     注意，你可以重复使用字典中的单词。
 

 示例 3： 

 
输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
 

 

 提示： 

 
 1 <= s.length <= 300 
 1 <= wordDict.length <= 1000 
 1 <= wordDict[i].length <= 20 
 s 和 wordDict[i] 仅有小写英文字母组成 
 wordDict 中的所有字符串 互不相同 
 
 Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1614 👎 0

*/   
package DP;

import java.util.HashSet;
import java.util.List;

/**
* @author  wbt
* @date    2022-05-20 09:41:26 
*/
public class P0139WordBreak {
   public static void main(String[] args) {        
   Solution solution = new P0139WordBreak().new Solution();   
    }    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        //1.确定dp数组以及下标的含义,
        // dp[i] : 字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词
        boolean []dp=new boolean[s.length()+1];
        //2.确定递推公式
        //如果确定dp[j] 是true，且 [j, i] 这个区间的子串出现在字典里，那么dp[i]一定是true。（j < i ）。
        //所以递推公式是 if([j, i] 这个区间的子串出现在字典里 && dp[j]是true) 那么 dp[i] = true。
        //3.dp数组如何初始化,从递归公式中可以看出，dp[i] 的状态依靠
        // dp[j]是否为true，那么dp[0]就是递归的根基，dp[0]一定要为true，否则递归下去后面都都是false了。
        dp[0]=true;
        //4.遍历顺序
        for(int i=1;i<=s.length();i++){
            for (int j = 0; j <i ; j++) {
                if(wordSet.contains(s.substring(j,i))&&dp[j])
                    dp[i]=true;
            }
        }
        return dp[s.length()];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
