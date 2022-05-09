package heap;

public class HeapSort {
    public static void sort(int[] arr) {
        heapify(arr, arr.length - 1);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            siftDown(arr, 0, i);
        }
    }

    private static void heapify(int[] arr, int index) {
        for (int i = (index - 1) / 2; i >= 0; i--) {
            siftDown(arr, i, index + 1);
        }
    }

    private static void siftDown(int[] arr, int index, int n) {
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        int currentIndex;
        if (leftIndex >= n) return;
        else if (rightIndex >= n) currentIndex = leftIndex;
        else currentIndex = arr[leftIndex] >= arr[rightIndex] ? leftIndex : rightIndex;
        if (arr[index] < arr[currentIndex]) {
            swap(arr, index, currentIndex);
            siftDown(arr, currentIndex, n);
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
