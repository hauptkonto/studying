package Problems.Top50.group00;

import Utility.IProblem;

/**
 * This problem is similar to the String Palindrome problem we have discussed above.
 * If you can solve that problem you can solve this as well. You can use indexOf()
 * or substring() to reverse a String or alternatively, convert the problem to reverse
 * an array by operating on character array instead of String.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */

public class N08_StringReverse implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        String[] strings = { "Hola", "Silja", "como", "andas?" };
        for (int i = strings.length - 1; i > 0; i--) {
            System.out.print(reverse(strings[i]) + ", ");
        }
        System.out.print(reverse(strings[0]) + "\n");
    }

    public String reverse(String s) {
        String reversed = "";
        if (s == null || s.isEmpty()) {
            return "";
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed+= s.charAt(i);
        }
        return reversed;
    }
}
