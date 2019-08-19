package Problems.Top50.group00;

import Utility.IProblem;

/**
 * You need to write a simple Java program to check if a given String is palindrome or not.
 * A Palindrome is a String which is equal to the reverse of itself e.g. "Bob" is a palindrome
 * because of the reverse of "Bob" is also "Bob".  Though be prepared with both recursive and
 * iterative solution of this problem. The interviewer may ask you to solve without using any
 * library method e.g. indexOf() or subString() so be prepared for that.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N03_PalindromeStr implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        String[] data = {"Alice", "Bob", "Carl", "Drew", "Eddie", "Neuquen"};
        for(int i = 0; i < data.length; i++) {
            System.out.println(data[i] + ": " + IsPalindrome(data[i]));
        }
    }

    public boolean IsPalindrome(String word) {
        if(word == null || word.isEmpty()) {
            return false;
        }
        word = word.toLowerCase();
        int leftIndex = 0;
        int rightindex = word.length() - 1;
        while(leftIndex < rightindex) {
            if(word.charAt(leftIndex) != word.charAt(rightindex)) {
                return false;
            }
            leftIndex++;
            rightindex--;
        }
        return true;
    }

}
