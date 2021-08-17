/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * <p>
 * 不占用额外内存空间能否做到？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * 注意：本题与主站 48 题相同：https://leetcode-cn.com/problems/rotate-image/
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/array-and-string/clpgd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Lc004 {
    public static void main(String[] args) {
        int[][] arrs = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};


        //测试
        //数组遍历
        System.out.println("原始数组:");
        show(arrs);

        //正对角反转
        Lc004 lc004 = new Lc004();
        lc004.diagonalReverse(arrs);

        //数组遍历
        System.out.println("正对角反转后:");
        show(arrs);
    }

    //二维数组反转
    public void rotate(int[][] matrix) {
        int length = matrix.length;

        //先对角反转
        for (int i = 0; i < length; i++) {
            for (int m = 0; m < length / 2; m++) {
                int tmp = matrix[i][m];
                matrix[i][m] = matrix[i][length - 1 - m];
                matrix[i][length - 1 - m] = tmp;
            }
        }

        //斜对角镜面反转
        for (int i = 0; i < length; i++) {
            for (int m = 0; m < length; m++) {
                int tmp = matrix[i][m];
                int i2 = length - 1 - i;
                int m2 = length - 1 - m;
            }
        }
    }

    //正对角反转
    //1 2 3     转换后 1 4 7
    //4 5 6           2 5 8
    //7 8 9           3 6 9
    public static void diagonalReverse(int[][] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            for (int m = 0; m < arrs.length; m++) {
                int tmp = arrs[i][m];
                arrs[i][m] = arrs[m][i];
                arrs[m][i] = tmp;
            }
        }
    }

    //斜对角反转
    public static void oppositeDiagonalReverse(int[][] arrs) {

    }

    //上下反转
    public static void upDownReverse2(int[][] arrs) {

    }

    //左右反转
    public static void leftRightReverse(int[][] arrs) {

    }

    //二维数组遍历
    private static void show(int[][] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            for (int m = 0; m < arrs[i].length; m++) {
                System.out.print(arrs[i][m] + " ");
            }
            System.out.println();
        }
    }
}
