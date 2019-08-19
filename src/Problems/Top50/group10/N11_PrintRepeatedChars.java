package Problems.Top50.group10;


import Utility.IProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * Print repeated characters of String.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N11_PrintRepeatedChars implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        CountSortDuplicated("Hola! como andas?");
    }

    /**
     * Counts duplicated elements using a map.
     * Works fine every time. Is more reliable than the other implementation.
     * Would use this one unless there's a need for not using collections.
     */
    public void MapDuplicated(String str) {
        if(str == null || str.isEmpty()) {
            System.out.println("Invaild input");
            return;
        }
        System.out.println("Duplicated characters on: \"" + str + "\"");
        //str = str.toLowerCase();
        //str = str.replaceAll("[^a-z]", "");
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if(map.containsKey(current)) {
                map.put(current, map.get(current) + 1);
            } else {
                map.put(current, 1);
            }
        }

        // Go through the map to count the repeated chars
        for(char key : map.keySet()) {
            int value = map.get(key);
            if(value > 1) {
                System.out.println(key + ": " + value + " times");
            }
        }
    }


    /**
     * Using a countSort to count characters.
     * Works faster if not using regex and lowercase, but requires a
     * char array with positions available for all ascii characters.
     * ASCII_OFFSET breaks the use of numbers and some special chars.
     */
    public void CountSortDuplicated(String str) {
        final int CHARACTERS = 255, ASCII_OFFSET = 0;
        if(str == null || str.isEmpty()) {
            System.out.println("Invaild input");
            return;
        }
        System.out.println("Duplicated characters on: \"" + str + "\"");

        //str = str.toLowerCase();
        //str = str.replaceAll("[^a-z]", "");
        char[] characters = new char[CHARACTERS];
        for(int i = 0; i < str.length(); i++) {
            int index = str.charAt(i)  - ASCII_OFFSET;
            characters[index]++;
        }

        // Print duplicated characters
        for(int j = 0; j < CHARACTERS; j++) {
            if(characters[j] > 1) {
                char current = (char) (ASCII_OFFSET + j);
                System.out.println(current + ": " + (int) characters[j] + " times");
            }
        }
    }
}