package Problems.Top50.group30;


import Utility.IProblem;

/**
 * Reverse a String in place.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N35_StringReverse implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        String input = "123456789";
        System.out.println(input);
        System.out.println(reverse(input));
    }

    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        for(int i = 0; i <= length / 2; i++) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(length - 1 - i));
            sb.setCharAt(length - 1 - i, temp);
        }
        return sb.toString();
    }
}
