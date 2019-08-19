package Problems.Top50.group10;


import Utility.IProblem;

/**
 * Reverse array in place.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N14_ReverseArray implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        int[] array = { 1, 2, 3, 4, 5 };
        printarray(array);
        printarray(reverse(array));
    }

    public int[] reverse(int[] array) {
        int size = array.length;
        int med = Math.round(size / 2);
        for (int i = 0; i < med; i++) {
            int temp = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = temp;
        }
        return array;
    }

    public void printarray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1]);
    }
}
