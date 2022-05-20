/**
小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。 

 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连
的房子在同一天晚上被打劫 ，房屋将自动报警。 

 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。 

 

 示例 1: 

 

 
输入: root = [3,2,3,null,3,null,1]
输出: 7 
解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7 

 示例 2: 

 

 
输入: root = [3,4,5,1,3,null,1]
输出: 9
解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 

 

 提示： 

 

 
 树的节点数在 [1, 10⁴] 范围内 
 0 <= Node.val <= 10⁴ 
 
 Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1308 👎 0

*/   
package DP;

import java.util.HashMap;
import java.util.Map;

/**
* @author  wbt
* @date    2022-05-20 11:29:26 
*/
public class P0337HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new P0337HouseRobberIii().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        // 1.递归去偷，超时
        public int rob(TreeNode root) {
            if (root == null)
                return 0;
            int money = root.val;
            if (root.left != null) {
                money += rob(root.left.left) + rob(root.left.right);
            }
            if (root.right != null) {
                money += rob(root.right.left) + rob(root.right.right);
            }
            return Math.max(money, rob(root.left) + rob(root.right));
        }

        // 2.递归去偷，记录状态
        // 执行用时：3 ms , 在所有 Java 提交中击败了 56.24% 的用户
        public int rob1(TreeNode root) {
            Map<TreeNode, Integer> memo = new HashMap<>();
            return robAction(root, memo);
        }

        int robAction(TreeNode root, Map<TreeNode, Integer> memo) {
            if (root == null)
                return 0;
            if (memo.containsKey(root))
                return memo.get(root);
            int money = root.val;
            if (root.left != null) {
                money += robAction(root.left.left, memo) + robAction(root.left.right, memo);
            }
            if (root.right != null) {
                money += robAction(root.right.left, memo) + robAction(root.right.right, memo);
            }
            int res = Math.max(money, robAction(root.left, memo) + robAction(root.right, memo));
            memo.put(root, res);
            return res;
        }

        // 3.状态标记递归
        // 执行用时：0 ms , 在所有 Java 提交中击败了 100% 的用户
        // 不偷：Max(左孩子不偷，左孩子偷) + Max(又孩子不偷，右孩子偷)
        // root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) +
        // Math.max(rob(root.right)[0], rob(root.right)[1])
        // 偷：左孩子不偷+ 右孩子不偷 + 当前节点偷
        // root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
        public int rob3(TreeNode root) {
            int[] res = robAction1(root);
            return Math.max(res[0], res[1]);
        }

        int[] robAction1(TreeNode root) {
            int res[] = new int[2];
            if (root == null)
                return res;

            int[] left = robAction1(root.left);
            int[] right = robAction1(root.right);

            res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            res[1] = root.val + left[0] + right[0];
            return res;
        }
//leetcode submit region end(Prohibit modification and deletion)

    }
}




