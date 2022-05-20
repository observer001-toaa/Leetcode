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
package BackTrack;

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
       private int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo =new int[s.length()];
        HashSet<String> wordSet = new HashSet<>(wordDict);
        return backtracking(s,wordSet,0);
    }
    public boolean backtracking(String s, HashSet<String> wordSet,int startIndex){
        if(startIndex ==s.length()){
            return  true;
        }
        if(memo[startIndex]==-1){
            return false;
        }
        for (int i = startIndex; i <s.length() ; i++) {
            String word =s.substring(startIndex,i+1);
            //拆分出来的单词无法匹配
            if(!wordSet.contains(word)){
                continue;
            }
            if(backtracking(s,wordSet,i+1))
                return true;
        }
        // 这里是关键，找遍了startIndex~s.length()也没能完全匹配，标记从startIndex开始不能找到
        memo[startIndex]=-1;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
