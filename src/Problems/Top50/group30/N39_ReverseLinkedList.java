package Problems.Top50.group30;


import DataStructures.Lists.LinkedList;
import Utility.IProblem;

/**
 * Write a program to reverse a singly linked list in Java. You can use iteration and
 * recursion to solve this problem but you should reverse linked list in place.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N39_ReverseLinkedList implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        LinkedList list = new LinkedList(7);
        System.out.println(list);
        System.out.println(reverse(list));
    }

    private LinkedList reverse(LinkedList list) {
        LinkedList.Node previous = null;
        LinkedList.Node current = list.getHead();
        LinkedList.Node next = null;
        LinkedList.Node head = list.getHead();
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        list.setHead(previous);
        list.setTail(head);
        return list;
    }
}
