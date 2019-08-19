package Problems.Top50.group40;


import DataStructures.Lists.LinkedList;
import Utility.IProblem;

/**
 * Write a program to check if given linked list has a loop or not. Sometimes a linked
 * list get corrupt and two nodes point to the same node, which forms the loop or cycle
 * in the linked list.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N41_LinkedLoopCheck implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        LinkedList list = new LinkedList(7);
        list.getTail().setNext(list.getHead());
        // System.out.println(list);
        System.out.println("Has loop: " + hasLoop(list));
    }

    private boolean hasLoop(LinkedList list) {
        LinkedList.Node slow = list.getHead();
        LinkedList.Node fast = list.getHead();
        while(fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
}
