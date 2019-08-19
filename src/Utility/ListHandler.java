package Utility;


import java.util.ArrayList;
import java.util.List;

public class ListHandler {

    public static List<Integer> buildIntList(int size, boolean reverseOrder) {
        List<Integer> list = new ArrayList<Integer>();
        if (reverseOrder) {
            for (int i = size - 1; i >= 0; i--) {
                list.add(i);
            }
        } else {
            for (int i = 0; i < size; i++) {
                list.add(i);
            }
        }
        return list;
    }

    public static Integer[] buildIntArray(int size, boolean reverseOrder) {
        Integer[] array = new Integer[size];
        List<Integer> list = buildIntList(size, reverseOrder);
        for(int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static <T> void pirntList(List<T> list) {
        System.out.println(list2str(list));
    }
    public static <T> String list2str(List<T> list) {
        String result = "";
        for (int i = 0; i < list.size() - 1; i++) {
            result = result + list.get(i).toString() + ", ";
        }
        result = result + list.get(list.size() - 1).toString();
        return result;
    }


    public static <T> void printArray(T[] array) {
        System.out.println(arr2str(array));
    }
    public static <T> String arr2str(T[] array) {
        String result = "";
        for (int i = 0; i < array.length - 1; i++) {
            result += array[i] + ", ";
        }
        result += array[array.length - 1];
        return result;
    }
}
