package Problems.Top50.group20;

import DataStructures.Lists.LinkedList;
import Utility.IProblem;

/**
 * Finding Middle element of linked list in one pass
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N22_MiddleOfLinkedList implements IProblem {
    private static final int LIST_SIZE = 11;

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        FindMiddle();
    }

    private void FindMiddle() {
        LinkedList list = new LinkedList(LIST_SIZE);
        int index = 0;
        LinkedList.Node ref = list.getHead(), middleRef = list.getHead();;
        while(ref != null) {
            ref = ref.getNext();
            if(index % 2 == 0 && ref != null) {
                middleRef = middleRef.getNext();
            }
            index++;
        }
        System.out.println("List: " + list);
        System.out.println("List size: " + index);
        System.out.println("Middle element: " + middleRef);
    }
}