package Problems.Top50.group10;


import Utility.IProblem;

/**
 * GCD of two numbers.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N12_GlobalCommonDenominator implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        printGCD(2351315, 1461357);
    }

    public void printGCD(int a, int b) {
        System.out.println("[GCD of " + a + " and " + b + "]: " + euclideanGCD(a, b));
    }

    /**
     * My version...
     */
    public int GCD(int n1, int n2) {
        int lesser = n1 < n2 ? n1 : n2;
        for(int i = 2; i <= lesser; i++) {
            if(n1 % i == 0 && n2 % i == 0) {
                return i;
            }
        }
        return 1;
    }

    /**
     * Much faster recursive version.
     */
    public int euclideanGCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        return euclideanGCD(b, a%b);
    }
}