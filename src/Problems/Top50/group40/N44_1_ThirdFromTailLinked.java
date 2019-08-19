package Problems.Top50.group40;

import DataStructures.Lists.LinkedList;
import Utility.IProblem;

/**
 * You need to write a program to find the 3rd element from the tail of a singly linked list.
 * You need to solve this problem without iterating twice. If you want more linked list questions
 * you can see the article about frequently asked linked list interview questions:
 * https://javarevisited.blogspot.com/2017/07/top-10-linked-list-coding-questions-and.html
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N44_1_ThirdFromTailLinked implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        LinkedList list = new LinkedList(8);
        System.out.println(list);
        System.out.println("Third from tail: " + fromTail(list, 3));
    }

    private String fromTail(LinkedList list, int offset) {
        LinkedList.Node fast = list.getHead();
        LinkedList.Node slow = list.getHead();
        int count = 0;
        while(fast != null) {
            fast = fast.getNext();
            if(count == offset) {
                slow = slow.getNext();
            } else {
                count++;
            }
        }
        if(count == offset) {
            return slow.getData();
        } else {
            return null;
        }
    }
}
