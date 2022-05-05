/**
  * 题目Id：56
  * 题目：合并区间
  * 日期：2022-05-05 15:50:24
*/
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 数组 排序 
// 👍 1464 👎 0


package Array;

//合并区间

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P56_MergeIntervals {
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P56_MergeIntervals().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
		if (intervals.length == 0){
			return new int[0][2];
		}
		List<int[]> merged = new ArrayList<>();
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		for (int i = 0; i < intervals.length; i++) {
			int L = intervals[i][0],R = intervals[i][1];
			if (merged.size() == 0 || merged.get(merged.size()-1)[1] < L) {
				merged.add(intervals[i]);
			} else {
				merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1],R);
			}
		}
		return merged.toArray(new int[merged.size()][]);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
