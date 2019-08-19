package Problems.Top50.group30;


import Utility.IProblem;

/**
 * Write a Java program to print all permutations of a given String. For example, if given String
 * is "GOD" then your program should print all 6 permutations of this string e.g. "GOD", "OGD",
 * "DOG", "GDO", "ODG", and "DGO".
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N34_StrPermutations implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        printPermutations("123");
    }

    private static void printPermutations(String str) {
        recursivePermutation("", str);
    }

    private static void recursivePermutation(String fixed, String variable) {
        if(variable == null || variable.isEmpty()) {
            System.out.println(fixed);
            return;
        }
        for(int i = 0; i < variable.length(); i++) {
            String newfixed = fixed + variable.charAt(i);
            String newVariable = variable.substring(0, i) + variable.substring(i+1, variable.length());
            recursivePermutation(newfixed, newVariable);
        }
    }
}
