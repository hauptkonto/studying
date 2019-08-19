package Problems.Top50.group30;

import Utility.IProblem;
import Utility.ListHandler;

/**
 * Write a program to implement the bubble sort algorithm in Java.
 * You can use basic operators and functions but sorting functions
 * from Java API is not allowed.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N32_BubbleSort implements IProblem {
    private static final int SIZE = 10;

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        System.out.println("Array:");
        arrayImplementation();
    }

    public static void arrayImplementation() {
        Integer[] array = ListHandler.buildIntArray(SIZE, true);
        ListHandler.printArray(array);
        array = bubbleSort(array);
        ListHandler.printArray(array);
    }
    public static Integer[] bubbleSort(Integer[] array) {
        boolean itemsWereMoved = true;
        while(itemsWereMoved) {
            itemsWereMoved = false;
            for(int i = array.length - 1; i > 0; i--) {
                if(array[i] < array[i -1]) {
                    Integer temp = array[i -1];
                    array[i -1] = array[i];
                    array[i] = temp;
                    itemsWereMoved = true;
                }
            }
        }
        return array;
    }
}














