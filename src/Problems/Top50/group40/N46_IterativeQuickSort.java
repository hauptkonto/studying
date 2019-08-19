package Problems.Top50.group40;


import Utility.IProblem;
import Utility.ListHandler;

import java.util.Objects;

/**
 * You need to write a Java program to implement quicksort sorting algorithm without recursion.
 * You can use essential JDK classes and programming constructs, but recursion is not allowed.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N46_IterativeQuickSort implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        Integer[] array = ListHandler.buildIntArray(10, true);
        ListHandler.printArray(array);
        quickSort(array);
        ListHandler.printArray(array);
    }

    private void quickSort(Integer[] array) {
        int [] indexStack = new int[64];
        int    stackIndex = 0;
        Objects.requireNonNull(array, "The input array is null.");

        indexStack[stackIndex++] = 0;
        indexStack[stackIndex++] = array.length;

        while (stackIndex > 0) {
            int endIndex   = indexStack[--stackIndex];
            int startIndex = indexStack[--stackIndex];

            int pivotIndex = partition(array, startIndex, endIndex);

            int leftChunkLength  = pivotIndex - startIndex;
            int rightChunkLength = endIndex - pivotIndex - 1;

            // Always push the larger chunk first, followed by the smaller chunk.
            if (leftChunkLength > 1 && leftChunkLength > rightChunkLength) {
                indexStack[stackIndex++] = startIndex;
                indexStack[stackIndex++] = pivotIndex;
            }

            if (rightChunkLength > 1) {
                indexStack[stackIndex++] = pivotIndex + 1;
                indexStack[stackIndex++] = endIndex;
            }

            if (leftChunkLength > 1 && leftChunkLength <= rightChunkLength) {
                indexStack[stackIndex++] = startIndex;
                indexStack[stackIndex++] = pivotIndex;
            }
        }
    }

    /**
     * Returns the pivot
     */
    private int partition(Integer[] array, int low, int high) {
        // TODO: code this...
        return 0;
    }

    private void swap(Integer[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}


