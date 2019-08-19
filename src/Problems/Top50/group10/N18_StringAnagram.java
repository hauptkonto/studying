package Problems.Top50.group10;
import Utility.IProblem;

/**
 * Write a program to check if two given String is Anagram of each other.
 * Your function should return true if two Strings are Anagram, false otherwise.
 * A string is said to be an anagram if it contains same characters and same
 * length but in different order e.g. army and Mary are anagrams. You can ignore
 * cases for this problem but you should clarify that from your interview.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N18_StringAnagram implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        checkAnagram("Mary", "army", true);
        checkAnagram("Marcelo", "Silja", true);
        checkAnagram("neuquen", "neuquen", true);
        checkAnagram("ccc", "cccc", true);
    }

    public void checkAnagram(String str1, String str2, boolean ignoreCase) {
        if (isAnagram(str1, str2, ignoreCase)) {
            System.out.println(str1 + " is an anagram of " + str2 + ".");
        } else {
            System.err.println(str1 + " is NOT an anagram of " + str2 + ".");
        }
    }

    public boolean isAnagram(String str1, String str2) {
        return isAnagram(str1, str2, true);
    }

    public boolean isAnagram(String str1, String str2, boolean ignoreCase) {
        if(str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty() || str1.equals(str2)) {
            return false;
        }

        if (ignoreCase) {
            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();
        }

        char[] characters = str1.toCharArray();
        for(char c : characters) {
            int index = str2.indexOf(c);
            if(index != -1) {
                str2 = str2.substring(0, index) + str2.substring(index + 1, str2.length());
            } else {
                return false;
            }
        }
        return str2.isEmpty();
    }

}