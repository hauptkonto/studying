package Problems.Top50.group00;

import Utility.IProblem;

/**
 * This is one of the simplest programs you can expect on interviews. It is generally asked
 * to see if you can code or not. Sometimes interviewer may also ask about changing a recursive
 * solution to iterative one or vice-versa.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */

public class N07_Factorial implements IProblem {
    private static final int LIMIT = 5;

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        for(int i = 0; i < LIMIT; i++) {
            System.out.println(i + ": " + factorial(i));
        }
    }

    public int factorial(int i) {
        if(i < 0)
            return -1;
        int acc = 1;

        while(i > 0) {
            acc*=i;
            i--;
        }
        return acc;
    }
}
