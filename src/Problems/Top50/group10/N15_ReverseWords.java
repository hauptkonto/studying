package Problems.Top50.group10;

import Utility.IProblem;

/**
 * Reverse words of sentence.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */

public class N15_ReverseWords implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        String sentence = "uno dos tres cuatro";
        System.out.println(sentence);
        System.out.println(reverse(sentence));
    }

    public String reverse(String sentence) {
        String[] words = sentence.split(" ");
        String reversed = "";
        for (int i = words.length - 1; i >= 0; i--) {
            reversed += words[i] + " ";
        }
        return reversed;
    }
}