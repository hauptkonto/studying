package Problems.Top50.group30;

import Utility.IProblem;

/**
 * Removal all white space from String.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N38_EraseWhiteSpace implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        String input = "Hola como andas";
        System.out.println(input);
        System.out.println(byeWhite(input));
    }

    private String byeWhite(String str) {
        //str.replaceAll("\\s", "O"); // regex
        return str.replace(" ", ""); // regular
    }
}
