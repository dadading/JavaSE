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
        //创建数组集合存放区间数据
        List<int[]> list = new ArrayList<int[]>();
        if (intervals.length == 0) {
            return new int[0][2];
        }

        // 按区间开始位置排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                //按左边界+右边界组合排序
                int a = o1[0] - o2[0];
                int b = a == 0 ? o1[1] - o2[1] : a;
                return b;
            }
        });

        // 遍历区间列表
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            //若是第一组区间直接加入集合中,或者当前区间左边界大于集合内部最后一个区间的右边界也是把当前区间直接插入集合
            if (i == 0 || list.get(list.size() - 1)[1] < left) {
                list.add(new int[]{left, right});
            }
            //其余情况都是将当前区间右边界赋值和集合内部最后一个区间的右边界中的大值赋给集合最后一个区间的右边界
            else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], right);
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    public void show(int[][] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            if (i == arrs.length - 1) {
                System.out.println(Arrays.toString(arrs[i]));
            } else {
                System.out.print(Arrays.toString(arrs[i]) + "  ");
            }
        }
    }


    public static void main(String[] args) {
        int[][] arrs = {{1, 3}, {2, 6}, {8, 10}, {15, 18}, {2, 4}, {9, 10}};

        //思路
        //按区间开头进行排序
        Arrays.sort(arrs, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                //按左边界+右边界组合排序
                int a = o1[0] - o2[0];
                int b = a == 0 ? o1[1] - o2[1] : a;
                return b;
            }
        });

        //测试
        Lc003 lc003 = new Lc003();

        lc003.show(arrs);
        lc003.show(lc003.merge(arrs));

    }
}
