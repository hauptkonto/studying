package Problems.Top50.group00;


import Utility.IProblem;

/**
 * Write a simple Java program which will print Fibonacci series
 * e.g. 1 1 2 3 5 8 13 ... . up to a given number. Be prepare for
 * cross questions like using iteration over recursion and how to
 * optimize the solution using caching and memoization.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N01_Fibonacci implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        int[] instances = {1,2,3,4,5,6,7};
        for(int i : instances) {
            System.out.println(i + ": " + fib_formula(i));
        }
    }

    /**
     * The recursive approach is not very good since it will re calculate
     * many fibs values multiple times as n grows.
     */
    public int fib_recursive(int n) {
        if (n < 2) {
            return n;
        } else {
            return fib_recursive(n - 1) + fib_recursive(n - 2);
        }
    }

    /**
     * Iterative way. It's simple and won't calculate values twice.
     */
    public int fib_loop(int n) {
        int[] raw = {0, 1};
        if(n < 2) {
            return raw[n];
        }
        int minusTwo = 0;
        int minusOne = 1;
        int current = minusOne + minusTwo;

        for(int i = 2; i <= n; i++) {
            current = minusOne + minusTwo;
            minusTwo = minusOne;
            minusOne = current;
        }
        return current;
    }

    /**
     * This method applies a mathematical formula for calculating a fib value.
     * This is the most effective and performant method.
     */
    public int fib_formula(int n) {
        double phi = (1 + Math.sqrt(5))/2;
        int value = (int) Math.round(Math.pow(phi, n) / Math.sqrt(5));
        return value;
    }
}
