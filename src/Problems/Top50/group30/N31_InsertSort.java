package Problems.Top50.group30;

/**
 * Write a program to implement the insertion sort algorithm in Java. The program should
 * take an unsorted array and sort it using insertion sort algorithm Also explain the best
 * case and worst case time and space complexity of Insertion sort algorithm.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */

import Utility.IProblem;
import Utility.ListHandler;

import java.util.ArrayList;
import java.util.List;
public class N31_InsertSort implements IProblem {
    private static final int SIZE = 10;

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        System.out.println("Array:");
        arrayImplementation();
        System.out.println("List: ");
        listImplementation();
    }

    private static void arrayImplementation() {
        Integer[] array = ListHandler.buildIntArray(SIZE, true);
        ListHandler.printArray(array);
        array = insertSort(array);
        ListHandler.printArray(array);
    }

    /** [Iterative insert sort]
     * 1) For each element of the array
     * 2) from that element on, copy it's predecesor value into it while the
     * 	  predecesor's value is greater than the current.
     * 	  remember that i starts from one and j starts from 0.
     *    This makes room for the insertion.
     * 4) assign the current to the remaining position.
     */
    private static Integer[] insertSort(Integer[] array) {
        if(array == null || array.length == 0) {
            return array;
        }
        for(int i = 1; i < array.length; i++) {
            Integer current = array[i];
            int j = i;
            while(j > 0 && array[j - 1] > current) {
                array[j] = array[j - 1]; // Make room for insertion
                j--;
            }
            array[j] = current;
        }
        return array;
    }

    private static void listImplementation() {
        List<Integer> list = ListHandler.buildIntList(SIZE, true);
        ListHandler.pirntList(list);
        list = insertSort(list);
        ListHandler.pirntList(list);
    }

    private static List<Integer> insertSort(List<Integer> list) {
        List<Integer> sorted = new ArrayList<Integer>();
        outterLoop: for(int n : list ) {
            for(int i = 0; i < sorted.size(); i++) {
                if(n < sorted.get(i)) {
                    sorted.add(i, n);
                    continue outterLoop;
                }
            }
            sorted.add(n);
        }
        return sorted;
    }
}


