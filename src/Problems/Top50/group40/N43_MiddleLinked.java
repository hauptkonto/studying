package Problems.Top50.group40;


import DataStructures.Lists.LinkedList;
import Utility.IProblem;

/**
 * Find middle element of linked list.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N43_MiddleLinked implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        LinkedList list = new LinkedList(8);
        System.out.println(list);
        System.out.println("Middle: " + getMiddle(list));
    }

    private String getMiddle(LinkedList list) {
        LinkedList.Node fast = list.getHead();
        LinkedList.Node slow = list.getHead();
        while(fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow.getData();
    }

}
