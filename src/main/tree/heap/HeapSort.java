package main.tree.heap;

/*
    Heap sort is an in-place algorithm
    Time complexity of Heap Sort is O(nLogn)

    Time complexity of heapify is O(Logn).
    Time complexity of createAndBuildHeap() is O(n)

    http://www.geeksforgeeks.org/heap-sort/
 */
public class HeapSort {

    public static void main(String[] args){

        int inputArray[] = {12, 11, 13, 5, 6, 7};

        System.out.print("Input Array is :: ");
        printArray(inputArray);

        heapSort(inputArray);

        System.out.print("\nSorted Array is :: ");
        printArray(inputArray);

    }

    private static void heapSort(int[] inputArray) {

        int n = inputArray.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(inputArray, n, i);
        }

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--) {
            // Move current root to end
            int temp = inputArray[0];
            inputArray[0] = inputArray[i];
            inputArray[i] = temp;

            // call max heapify on the reduced heap
            heapify(inputArray, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private static void heapify(int arr[], int n, int i) {

        int largest = i;  // Initialize largest as root
        int left = 2*i + 1;  // left = 2*i + 1
        int right = 2*i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    private static void printArray(int[] inputArray) {

        for (int i=0; i<inputArray.length; i++){
            System.out.print(inputArray[i] + " ");
        }
    }
}
