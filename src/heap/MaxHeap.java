package heap;

import java.util.ArrayList;

public class MaxHeap {
    private ArrayList<Integer> elements;

    public MaxHeap() {
        elements = new ArrayList<>();
    }

    public MaxHeap(int[] arr) {
        elements = new ArrayList<>();
        for (int v : arr)
            elements.add(v);
        heapify();
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.size() == 0;
    }

    public void heapify() {
        for (int i = (elements.size() - 2) / 2; i >= 0; i--) {
            siftDown(i);
        }
    }

    public void offer(int element) {
        elements.add(element);
        siftUp(elements.size() - 1);
    }

    public int poll() {
        int result = elements.get(0);
        int last = elements.remove(elements.size() - 1);
        if (elements.size() == 0) return last;
        elements.set(0, last);
        siftDown(0);
        return result;
    }

    private void siftUp(int index) {
        if (index == 0) return;
        int currentIndex = parent(index);
        if (elements.get(index) > elements.get(currentIndex)) {
            swap(currentIndex, index);
            siftUp(currentIndex);
        }
    }

    private void siftDown(int index) {
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);
        int currentIndex = index;
        if (leftIndex >= elements.size()) return;
        else if (rightIndex >= elements.size()) currentIndex = leftIndex;
        else currentIndex = elements.get(leftIndex) >= elements.get(rightIndex) ? leftIndex : rightIndex;
        if (elements.get(index) < elements.get(currentIndex)) {
            swap(currentIndex, index);
            siftDown(currentIndex);
        }
    }

    private void swap(int index1, int index2) {
        int temp1 = elements.get(index1);
        int temp2 = elements.get(index2);
        elements.set(index1, temp2);
        elements.set(index2, temp1);
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
