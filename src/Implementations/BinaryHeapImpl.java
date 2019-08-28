package Implementations;

import java.util.HashMap;
import java.util.Map;

public class BinaryHeapImpl {


    private int[] arr;
    private int last = 0;

    public BinaryHeapImpl(int size) {
        arr = new int[size];
    }

    public void insert(int data) {
        arr[last] = data;
        bubbleUp(last);
        last++;
    }


    public void delete(int val) {
        int index = find(val);
        arr[index] = arr[last-1];
        bubbleDown(index);
        last--;

    }

    public void bubbleUp(int index) {
        if (hasParent(index)) {
            int parentIndex = getParentIndex(index);
            if (arr[parentIndex] > arr[index]) {
                int temp = arr[parentIndex];
                arr[parentIndex] = arr[index];
                arr[index] = temp;
                bubbleUp(parentIndex);
            }
        }

    }

    public void bubbleDown(int index) {
        if (hasLeftChild(index)) {

            int minIndex = index;
            if (arr[getLeftChild(index)] < arr[minIndex]) {
                minIndex = getLeftChild(index);
            }
            if (hasRightChild(index) && getRightChild(index) < minIndex) {
                minIndex = getRightChild(index);
            }
            if (minIndex == index)
                return;
            else {
                int temp = arr[index];
                arr[index] = arr[minIndex];
                arr[minIndex] = temp;
                bubbleDown(index);
            }

        }
    }

    public boolean hasParent(int index) {
        return index != 0;
    }

    public boolean hasLeftChild(int index) {
        return index * 2 + 1 < last;
    }

    public boolean hasRightChild(int index) {
        return index * 2 + 2 < last;
    }

    public int getParentIndex(int index) {
        if (index % 2 == 0)
            return (index - 2) / 2;
        else
            return (index - 1 )/ 2;
    }

    public int getLeftChild(int index) {
        return index * 2 + 1;
    }

    public int getRightChild(int index) {
        return index * 2 + 2;
    }


    public int find(int val) {
        for (int i = 0; i < last; i++) {
            if (arr[i] == val)
                return i;
        }
        return 0;
    }

    public void print(){
        for(int i=0;i<last;i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        BinaryHeapImpl binaryHeap=new BinaryHeapImpl(20);
        binaryHeap.insert(3);
        binaryHeap.insert(1);
        binaryHeap.insert(5);
        binaryHeap.delete(1);
        binaryHeap.print();
    }
}


