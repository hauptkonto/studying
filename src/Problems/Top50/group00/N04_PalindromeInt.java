package Problems.Top50.group00;

import Utility.IProblem;

/**
 * This is generally asked as follow-up or alternative of the previous program.
 * This time you need to check if given Integer is palindrome or not. An integer
 * is called palindrome if its equal to its reverse e.g. 1001 is a palindrome but
 * 1234 is not because the reverse of 1234 is 4321 which is not equal to 1234. You
 * can use divide by 10 to reduce the number and modulus 10 to get the last digit.
 * This trick is used to solve this problem.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N04_PalindromeInt implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        int[] data = {1111, 1221, 1331, 1234, 4567};
        for(int i = 0; i < data.length; i++) {
            System.out.println(data[i] + ": " + IsPalindrome(data[i]));
        }
    }

    public boolean IsPalindrome(int number) {
        int reverse = 0;
        int toUse = number;
        while(toUse > 0) {
            int restou = toUse % 10;
            reverse = reverse * 10 + restou;
            toUse = toUse / 10;
        }
        return number == reverse;
    }

}
