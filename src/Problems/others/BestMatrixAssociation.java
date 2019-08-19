package Problems.others;


import Utility.*;

import java.util.ArrayList;
import java.util.List;

public class BestMatrixAssociation implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }
    public void Execute() {
        Integer[] p = {40, 20, 30, 10, 30};
        calculateBestAssociation(p);
    }

    /**
     * Input:  p[] = {40, 20, 30, 10, 30}
     *   Output: Optimal parenthesization is  ((A(BC))D)
     *           Optimal cost of parenthesization is 26000
     *   There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
     *   Let the input 4 matrices be A, B, C and D.  The minimum number of
     *   multiplications are obtained by putting parenthesis in following way
     *   (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30
     * @param p
     * @return
     */
    private int calculateBestAssociation(Integer[] p) {
        // Create factors
        final int ASCII_OFFSET = 65;
        List<String> factors = new ArrayList<>();
        for (int i = 0; i < p.length - 1; i++) {
            String factor = (char)(i + ASCII_OFFSET) + "";
            factors.add(factor);
        }
        // Call the association method
        int bestAssoc = associate(Utility.array2List(p), factors);

        // Print results
        System.out.println("p: " + Utility.arrayToString(p));
        System.out.println("Best Association: " + factors.get(0) + " (" + bestAssoc + ") operations");
        return bestAssoc;
    }

    private int associate(List<Integer> p, List<String> factors) {
        // TODO: Fix this!
        // It actually doesn't work...
        if(p.size() < 3) {
            // 4) If less than 3 values remain, that's it.
            return 0;
        }
        // 1) Find group of three that produces the lesser multiplication result
        int lesserGroupIndex = -1;
        int lesserGroupValue = Integer.MAX_VALUE;
        int[] groupValues = new int[p.size() - 2];
        for (int i = 0; i < p.size() - 2; i++) {
            groupValues[i] = p.get(i) * p.get(i + 1) * p.get(i + 2);
            if(groupValues[i] < lesserGroupValue) {
                lesserGroupValue = groupValues[i];
                lesserGroupIndex = i;
            }
        }
        // 2) find out which letters compose such group. Then build string with parenthesis and replace
        //    values in the original string.
        String newFactor = "(" + factors.get(lesserGroupIndex) + factors.get(lesserGroupIndex + 1) + ")";
        factors.set(lesserGroupIndex, newFactor);
        factors.remove(lesserGroupIndex + 1);
        p.remove(lesserGroupIndex + 1); // erase middle value

        // 3) Perform recursive call and return result.
        lesserGroupValue += associate(p, factors);
        return lesserGroupValue;
    }
}
