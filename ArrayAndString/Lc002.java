import javafx.scene.shape.VLineTo;

/**
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * 示例 5:
 * <p>
 * 输入: nums = [1], target = 0
 * 输出: 0
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为无重复元素的升序排列数组
 * -104 <= target <= 104
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/array-and-string/cxqdh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Lc002 {
    public int searchInsert(int[] nums, int target) {
        //定义index
        int index = 0;

        //如果target小于第一个元素则返回0
        if (target < nums[0]) {
            return index;
        }

        while (target >= nums[index]) {
            //若target等于当前元素则返回当前元素
            if (target == nums[index]) {
                return index;
            }
            //若是最后一个元素则跳出循环
            else if (index == nums.length - 1) {
                index++;
                break;
            }
            //若target不满足条件也跳出循环
            else {
                index++;
            }
        }
        return index;
    }

    //暴力遍历
    public int searchInsert2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    //二分法
    public int searchInsert3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            //防止left+right整形溢出
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int value = -1;

        //思路
        int index = 0;
        if (value < nums[0]) {
            index = 0;
        }

        while (value >= nums[index]) {
            if (value == nums[index]) { //value = 7 index = 0 1 2
                System.out.println(index);
            } else if (index == nums.length - 1) {
                index += 1;
                break;
            } else {
                index++;
            }
        }
        System.out.println("插入的index是index:" + index);

        //测试
        Lc002 lc002 = new Lc002();
        System.out.println("插入的index是:" + lc002.searchInsert(nums, value));
        System.out.println("插入的index是:" + lc002.searchInsert2(nums, value));
        System.out.println("插入的index是:" + lc002.searchInsert3(nums, value));
    }
}
