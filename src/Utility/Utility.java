package Utility;

import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static <T> String arrayToString(T[] array) {
        String result = "[";
        for (int i = 0; i < array.length - 1; i++) {
            result += array[i] + ", ";
        }
        result += array[array.length - 1] + "]";
        return result;
    }

    public static <T> String listToString(List<T> list) {
        String result = "[";
        for (int i = 0; i < list.size() - 1; i++) {
            result += list.get(i) + ", ";
        }
        result += list.get(list.size() - 1) + "]";
        return result;
    }

    public static <T> List<T> array2List(T[] array) {
        List<T> result = new ArrayList<T>();
        for (int i = 0; i < array.length; i++) {
            result.add(array[i]);
        }
        return result;
    }

    public static <T> T[] list2Array(List<T> list) {
        return (T[])list.toArray();
    }
}
