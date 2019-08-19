package Problems.Top50.group20;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import Utility.IProblem;

/**
 *  The first non-repeated character of a String.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N21_FirstNonRepeatedChar implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        String s = "Habia una vez una Silja!";
        System.out.println(s);
        System.out.println("First non repeated char is: " + GetFirstNonRepeated(s));
    }

    private String GetFirstNonRepeated(String s) {
        Map<Character, Integer> repeated = new LinkedHashMap<Character, Integer>();
        List<Character> nonRepeated = new ArrayList<Character>();
        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(!repeated.containsKey(c)) {
                if(!nonRepeated.contains(c)) {
                    nonRepeated.add(c);
                } else {
                    nonRepeated.remove((Character)c);
                    repeated.put(c, 1);
                }
            }
        }

        if(nonRepeated.size() > 0) {
            return nonRepeated.get(0) + "";
        }
        return "";
    }
}
