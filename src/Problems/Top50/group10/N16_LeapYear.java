package Problems.Top50.group10;

import Utility.IProblem;

/**
 * Leap year.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N16_LeapYear implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        int[] years = { 1900, 1901, 2000, 2012, 2019 };
        for (int i = 0; i < years.length; i++) {
            System.out.println(years[i] + " is leap: " + isLeap(years[i]));
        }
    }

    public boolean isLeap(int year) {
        boolean isLeap = (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
        return isLeap;
    }
}