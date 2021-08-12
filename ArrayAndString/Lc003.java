import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/array-and-string/c5tv3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Lc003 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<int[]>();
        if(intervals.length == 0){
            return new int[0][2];
        }
        // 按区间开始位置排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2){
                return i1[0] - i2[0];
            }
        });

        // 遍历区间列表
        for(int i = 0; i < intervals.length; i++){
            int left = intervals[i][0], right = intervals[i][1];
            if(i == 0 || list.get(list.size() - 1)[1] < left){
                list.add(new int[]{left, right});
            }else {
                // 确定区间右边界
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], right);
            }
        }

        return list.toArray(new int[list.size()][]);
    }


    public static void main(String[] args) {
        int[][] arrs = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        //思路
        for (int i = 0; i < arrs.length; i++) {
            for (int m = 0; m < arrs[i].length; m++) {
                System.out.print(arrs[i][m] + " ");
            }
            System.out.println("");
        }
    }
}
