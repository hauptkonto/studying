package Problems.Top50.group40;

import DataStructures.Lists.LinkedList;
import Utility.IProblem;

/**
 * Just write a program in Java to find the length of a singly linked list in one pass i.e.
 * in just one iteration of singly linked list.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */

public class N40_LinkedLength implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        LinkedList list = new LinkedList(7);
        System.out.println(list);
        System.out.println(getLength(list));
    }

    private int getLength(LinkedList list) {
        LinkedList.Node node = list.getHead();
        int count = 0;
        while(node != null) {
            node = node.getNext();
            count++;
        }
        return count;
    }

}