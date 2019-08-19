package Problems.Top50.group30;

import Utility.IProblem;
import Utility.ListHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * You need to write a Java program to sort an array of integers using quick sort algorithm.
 * You cannot use any library method e.g. JDK or a third party library, which means, you need
 * to first implement the quicksort algorithm and then sort the array.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */

public class N30_QuickSort implements IProblem {
    private static final int SIZE = 10;

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        runIterative();
    }

    /**
     * Performs iterative stuff.
     */
    public void runIterative() {
        Integer[] numbers = {5,8,2,0,4,1,3,7,6,9};//ListHandler.buildIntArray(SIZE, true);
        ListHandler.printArray(numbers);
        numbers = quickSortIterative(numbers);
        ListHandler.printArray(numbers);
    }

    public Integer[] quickSortIterative(Integer[] array) {
        return  quickSortIterative(array, 0, array.length - 1);
    }

    /**
     * 1) i = low, j = high. Get pivot as middle value of the array to be considered.
     * 2) Swap elements greater than the pivot to the array that's after the pivot,
     *    and lesser elements to the lower part.
     * 3) low < j means that there are still some elements to be considered, so a
     *    recursive call is performed where low remains and j is the high value.
     *    Values outside this range are ordered in the other recursive call. In
     *    summary, this part orders everything below the current pivot.
     * 4) i < high means that there are still some elements to be considered on top
     * 	  of the current pivot.
     */
    public Integer[] quickSortIterative(Integer[] array, int low, int high) {
        int i = low;
        int j = high;
        int pivot = array[low + (high - low) / 2];

        while(i <= j) {
            while(i < array.length && array[i] < pivot) {
                i++;
            }
            while(j > 0 && array[j] > pivot) {
                j--;
            }
            if(i <= j) {
                // swap
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                // increment
                i++;
                j--;
            }
        }
        // Recursive calls
        if(low < j) {
            // Orders everything below the current pivot
            quickSortIterative(array, low, j);
        }
        if(i < high) {
            // Orders everything on top of the current pivot
            quickSortIterative(array, i, high);
        }
        return array;
    }

    /**
     * Performs recursive stuff.
     */
    public void runRecursive() {
        List<Integer> numbers = ListHandler.buildIntList(SIZE, true);
        ListHandler.pirntList(numbers);
        numbers = quickSort(numbers);
        ListHandler.pirntList(numbers);
    }

    /**
     * Recursive Quick Sort
     */
    public List<Integer> quickSort(List<Integer> array) {
        if(array == null || array.size() < 2) {
            return array;
        }
        int pivot = array.get(0);
        List<Integer> lower = new ArrayList<Integer>();
        List<Integer> higher = new ArrayList<Integer>();
        for(int i = 0; i < array.size(); i++) {
            int current = array.get(i);
            if(current < pivot) {
                lower.add(current);
            } else if(current > pivot){
                higher.add(current);
            }
        }
        List<Integer> result = quickSort(lower);
        result.add(pivot);
        result.addAll(quickSort(higher));
        return result;
    }

}