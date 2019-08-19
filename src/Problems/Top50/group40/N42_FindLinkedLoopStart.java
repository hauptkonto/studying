package Problems.Top50.group40;


import DataStructures.Lists.LinkedList;
import Utility.IProblem;

import java.util.HashSet;

/**
 * Find the start of loop in linked list.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N42_FindLinkedLoopStart implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        LinkedList list = new LinkedList(7);
        list.getTail().setNext(list.getHead().getNext().getNext()); // create a loop
        System.out.println(findLoopStarter(list));
    }

    /**
     * When iterating over the list, the first node to be repeated would be the
     * start of the loop. Thinking things this way would make it easy with a set.
     * Another approach would be to define the node pointed to by two other nodes
     * is the start of the loop.
     * A final approach, and seems to be the most common one, would be to use a fast and slow pointer
     * and
     */
    private String findLoopStarter(LinkedList list) {
        HashSet<LinkedList.Node> set = new HashSet<LinkedList.Node>();
        LinkedList.Node current = list.getHead();
        while (current != null) { // Iterate over every node
            if(set.contains(current)) {
                return current.getData();
            }
            set.add(current);
            current = current.getNext();
        }
        return null;
    }
}
