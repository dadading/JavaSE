/**
 * 寻找数组的中心索引
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * <p>
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * <p>
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * 示例 2：
 * <p>
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 * 示例 3：
 * <p>
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心下标是 0 。
 * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
 * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/array-and-string/yf47s/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Lc001 {
    public int pivotIndex(int[] nums) {
        //循环求出数组的和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        //再次循环求和,当和是总和的1/2退出当前的index
        int index = 0;
        int sum2 = 0;
        for (; index < nums.length; index++) {
            sum2 += nums[index];
            if ((sum2 - nums[index]) * 2 == (sum - nums[index])) {
                return index;
            }
        }

        //都不满足则返回-1
        return -1;
    }

    public static void main(String[] args) {
        //示例数组
        int[] nums = {1, 7, 3, 6, 5, 6};

        //思路
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        System.out.println(sum);

        int sum2 = 0;
        int m = 0;
        for (; m < nums.length; m++) {
            sum2 += nums[m];
            if (2 * (sum2 - nums[m]) == sum - nums[m]) {
                break;
            }
        }

        System.out.println("中心index是:" + m);
        System.out.println("----------");

        //测试
        Lc001 lc001 = new Lc001();
        int[] arrs1 = {1, 2, 3, -5};
        System.out.println("arrs的中心index是:" + lc001.pivotIndex(arrs1));
        int[] arrs2 = {1, 2, 3, 6};
        System.out.println("arrs的中心index是:" + lc001.pivotIndex(arrs2));
        int[] arrs3 = {1, 2, 3, 3};
        System.out.println("arrs的中心index是:" + lc001.pivotIndex(arrs3));
    }
}
