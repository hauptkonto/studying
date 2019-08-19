package Problems.Top50.group20;
import Utility.IProblem;

/**
 * Reverse a number.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N20_ReverseNumber implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        int[] numbers = {123, 456, 789};
        for(int i = 0; i < numbers.length; i++) {
            System.out.println("Reverse of " + numbers[i] + " is: " + reverseNumber(numbers[i]));
        }
    }

    private int reverseNumber(int number) {
        int reverse = 0;
        while(number > 0) {
            reverse = reverse * 10 + (number % 10);
            number = number / 10;
        }
        return reverse;
    }
}
