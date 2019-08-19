package Problems.Top50.group10;

import Utility.IProblem;

/**
 * Printing Patterns.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N10_PrintingPatterns implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        piramid(5);
    }

    public void piramid(int levels) {
        for(int curentLevel = 0; curentLevel < levels; curentLevel++) {
            for(int k = 0; k < levels - curentLevel; k++) {
                System.out.print(" ");
            }
            for(int j = 0; j <= curentLevel; j++) {
                System.out.print(j + " ");
            }
            System.out.println("");
        }
    }

    public void printTriangle(int levels) {
        for(int i = 0; i < levels; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
}