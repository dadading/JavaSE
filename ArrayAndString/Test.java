import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(12);
        list.add(13);
        list.add(90);
        list.add(20);

        for (int i : list) {
            System.out.println(i);
        }
        System.out.println("-----");

        int[][] arrs = {{1, 2, 3}, {7, 8, 9}, {4, 5, 6}};

        int[] arrs2 = {1, 3, 5, 3, 8, 5};

        //Arrays.sort(arrs);
        // Arrays.sort(arrs2);


        for (int i = 0; i < arrs2.length; i++) {
            System.out.println(arrs2[i]);
        }
    }
}
