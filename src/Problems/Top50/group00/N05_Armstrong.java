package Problems.Top50.group00;

import Utility.IProblem;

/**
 * A number is called an Armstrong number if it is equal to the cube of its each digit.
 * for example, 153 is an Armstrong number because 153= 1+ 125+27 which is equal to
 * 1^3+5^3+3^3. You need to write a program to check if given number is Armstrong number or not.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N05_Armstrong implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        int[] data = {371, 1221, 1331, 1234, 4567};
        for(int i = 0; i < data.length; i++) {
            System.out.println(data[i] + ": " + IsArmstrong(data[i]));
        }
    }

    public boolean IsArmstrong(int number) {
        int toUse = number;
        int armstrong = 0;
        while(toUse > 0) {
            int restou = toUse % 10;
            armstrong += (restou * restou * restou);
            toUse = toUse / 10;
        }
        return armstrong == number;
    }

}