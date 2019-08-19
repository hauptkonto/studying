package Problems.Top50.group10;


import Utility.IProblem;

/**
 * You need to write a program to calculate the square root of a number without using
 * the Math.sqrt() function of JDK. You need to write your logic and method to calculate
 * the square root. You can though use popular algorithm e.g. Newton's method.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N13_SqrtOfANumber implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        printSqrt(248531);
    }

    public void printSqrt(int n) {
        System.out.println("Sqrt(" + n + "): " + sqrt(n));
    }

    /**
     * Newton–Raphson sqrt method. The idea is to minimize x*x - n, being x the
     * sqrt. To perform the minimization, we need to apply this formula:
     *                  f[x(i)] - n
     * x(i+1) = x(i) - --------------
     *                 df[x(i)]/dx(i)
     * Then we calculate the convergence rate as:
     * cr = |f[x(i)] - n| (simplified)
     * That's a pretty simplified version either way, but when cr is close to 0
     * we can assume that xi has the proper sqrt value.
     */
    public double sqrt(int n) {
        double xi = n / 2; // Initial guess
        double convergenceRate = 1;
        while (convergenceRate > 0.000001) {
            //                  x(i)^2 - n
            // x(i+1) = x(i) - ------------
            //                   2 * x(i)
            xi = xi - (xi * xi - n) / (2 * xi);
            convergenceRate = Math.abs((xi * xi - n)); // Simplified
        }
        return xi;
    }
}
