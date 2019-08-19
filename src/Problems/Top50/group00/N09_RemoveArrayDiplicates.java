package Problems.Top50.group00;

import Utility.IProblem;

import java.lang.reflect.Array;

/**
 * Write a program to remove duplicates from an array in Java without using the Java
 * Collection API. The array can be an array of String, Integer or Character, your
 * solution should be independent of the type of array. If you want to practice more
 * array based questions then see this list of top 30 array interview questions from
 * Java interviews:
 * https://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-and-answers.html
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N09_RemoveArrayDiplicates implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        String[] strings = { "Hola", "Silja", "como", "andas?", "Hola" };
        ArrayHelper<String> ah = new ArrayHelper<String>();
        ah.print(strings);
        strings = ah.removeDuplicates(strings);
        ah.print(strings);

        ArrayHelper<Integer> bbb = new ArrayHelper<Integer>();
        Integer[] asd = {1, 2, 3, 4, 4, 4, 4, 4, 5};
        bbb.print(bbb.removeDuplicates(asd));
    }

    public class ArrayHelper<T> {

        /**
         * Erases all duplicated elements from the given array.
         */
        private T[] removeDuplicates(T[] array) {
            if (array == null || array.length == 0)
                return array;

            @SuppressWarnings("unchecked")
            T[] aux = (T[]) Array.newInstance(array[0].getClass(), array.length);
            bigger: for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < aux.length; j++) {
                    if (array[i].equals(aux[j])) {
                        // duplicated found, skip this element
                        continue bigger;
                    }
                }
                aux[i] = array[i];
            }
            return aux;
        }

        /**
         * Pritns the given Array.
         */
        public void print(T[] array) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null)
                    System.out.print(array[i].toString() + ", ");
            }
            System.out.println("");
        }
    }
}