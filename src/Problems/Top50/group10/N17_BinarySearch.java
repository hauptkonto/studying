package Problems.Top50.group10;


import Utility.IProblem;

/**
 * Binary search.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N17_BinarySearch implements IProblem {
    private int iterations = 0;

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        int[] array = generateOrderedArray(1000);
        int element = 517;
        int index = binarySearch(array, element);
        System.out.println("Element " + element + " is at index: " + index
                + " (used " + iterations + " iterations)");
    }

    public int binarySearch(int[] array, int number) {
        return binarySearch(array, number, 0, array.length - 1);
    }

    public int binarySearch(int[] array, int number, int leftIndex, int rightIndex) {
        iterations++;
        if(leftIndex > rightIndex) {
            return -1; // element was not found
        }

        int medIndex = leftIndex + ((rightIndex - leftIndex) / 2);
        if(array[medIndex] == number) {
            return medIndex; // element was found
        }

        if(array[medIndex] < number) {
            // if the element in the index is lesser than the number we look for,
            // then the number should be in the upper remaining part
            return binarySearch(array, number, medIndex + 1, rightIndex);
        } else {
            // if the element in the index is bigger than the number we look for,
            // then the number should be in the lower remaining part
            return binarySearch(array, number, leftIndex, medIndex - 1);
        }
    }

    public int[] generateOrderedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }
}