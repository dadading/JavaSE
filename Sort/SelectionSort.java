public class SelectionSort {
    public static void main(String[] args) {
        int[] arrs = {1, 3, 5, 7, 9, 2, 4, 6, 8};

        //排序之前数组遍历
        show(arrs);

        //选择排序
        selectionSort(arrs);

        //排序之后数组遍历
        show(arrs);
    }

    //选择排序
    private static void selectionSort(int[] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            int minIndex = i;
            for (int m = i + 1; m < arrs.length; m++) {
                if (arrs[m] < arrs[minIndex]) {
                    //记录最小的index
                    minIndex = m;
                }
            }
            //交换当前元素和最小元素
            int min = arrs[minIndex];
            arrs[minIndex] = arrs[i];
            arrs[i] = min;
        }
    }

    //数组遍历
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
