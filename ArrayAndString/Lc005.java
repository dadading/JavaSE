import java.util.ArrayList;

/**
 * 零矩阵
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出：
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 示例 2：
 * <p>
 * 输入：
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出：
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/array-and-string/ciekh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Lc005 {
    public void setZeroes(int[][] matrix) {
        //将为0的坐标记录下
        ArrayList<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < matrix.length; i++) {
            for (int m = 0; m < matrix[i].length; m++) {
                if (matrix[i][m] == 0) {
                    list.add(new int[]{i,m});
                }
            }
        }

        for(int[] a:list){
            //将行上的元素都置为0
            for (int x = 0; x < matrix[a[0]].length; x++) {
                matrix[a[0]][x] = 0;
            }

            //将列上的元素都置为0
            for (int y = 0; y < matrix.length; y++) {
                matrix[y][a[1]] = 0;
            }
        }
    }

    //数组遍历
    private static void show(int[][] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            for (int m = 0; m < arrs[i].length; m++) {
                System.out.print(arrs[i][m] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arrs = {{1, 2, 3}, {4, 0, 6}, {7, 8, 9}};

        //测试
        show(arrs);
        Lc005 lc005 = new Lc005();
        lc005.setZeroes(arrs);
        System.out.println("有0行列上的元素都置为0后结果是:");
        show(arrs);
    }

}
