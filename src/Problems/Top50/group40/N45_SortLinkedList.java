package Problems.Top50.group40;


import DataStructures.Lists.LinkedList;
import Utility.IProblem;

/**
 * You need to given an unsorted linked list and you need to write a program in Java to
 * sort them in ascending order of the values in each node.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N45_SortLinkedList implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        LinkedList list = LinkedList.getRandomList(5);
        System.out.println(list);
        linkedBuble(list);
        System.out.println(list);
    }

    private void linkedBuble(LinkedList list) {
        boolean changesWereMade = true;
        while(changesWereMade) {
            changesWereMade = false;
            LinkedList.Node previous = null;
            LinkedList.Node node = list.getHead();
            while(node != null && node.getNext() != null) {
                if(node.isGreaterThan(node.getNext())) {
                    linkedSwap(node, node.getNext(), previous, list);
                    changesWereMade = true;
                }
                previous = node;
                node = node.getNext();
            }
        }
    }

    private void linkedSwap(LinkedList.Node a, LinkedList.Node b, LinkedList.Node prevA, LinkedList list) {
        if(prevA != null) {
            prevA.setNext(b); // used to be a
        } else {
            list.setHead(b);
        }
        a.setNext(b.getNext());
        b.setNext(a);
    }
}
