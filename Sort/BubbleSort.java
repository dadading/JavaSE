import javax.xml.transform.Source;

/**
 * 冒泡排序
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] arrs = {1, 3, 5, 7, 9, 2, 4, 6, 8};

        //排序之前数组遍历
        show(arrs);

        //冒泡排序
        bubbleSort(arrs);

        //排序之后数组遍历
        show(arrs);
    }

    private static void bubbleSort(int[] arrs) {
        for (int i = 1; i < arrs.length; i++) {
            for (int m = 0; m < arrs.length - i; m++) {
                if (arrs[m] > arrs[m + 1]) {
                    int max = arrs[m];
                    arrs[m] = arrs[m + 1];
                    arrs[m + 1] = max;
                }
            }
        }
    }

    public static void show(int[] arrs) {
        System.out.print("[");
        for (int i = 0; i < arrs.length; i++) {
            if (i == arrs.length - 1) {
                System.out.println(arrs[i] + "]");
            } else {
                System.out.print(arrs[i] + ", ");
            }
        }
    }
}
