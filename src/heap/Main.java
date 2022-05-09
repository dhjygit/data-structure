package heap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {12, 8, 9, 200, 4, 5, 7, 3, 4, 6, 7, 3, 3};
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}