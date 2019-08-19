package Problems.Top50.group40;


import DataStructures.Lists.LinkedList;
import DataStructures.Trees.BTree;
import DataStructures.Trees.TreeTraverser;
import Utility.IProblem;

/**
 * It's possible to convert a doubly linked list to a binary tree, you need to write a
 * Java program which takes a doubly linked list and returns a binary tree.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N44_2_LinkedToBTree implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        LinkedList list = setupList();
        BTree result = toBTree(list);
        System.out.println("Tree: ");
        TreeTraverser tt = new TreeTraverser();
        tt.IterativeInOrder(result.getRoot());
    }

    private LinkedList setupList() {
        LinkedList list = new LinkedList();
        LinkedList.Node node = new LinkedList.Node("5");
        list.setHead(node);
        list.setTail(node);
        for(int i = 0; i < 10; i++) {
            int number = (int) (Math.random() * 10.0);
            list.add(new LinkedList.Node("" + number));
        }

        System.out.println("List: ");
        System.out.println(list);
        return list;
    }

    private BTree toBTree(LinkedList list) {
        BTree tree = new BTree();
        LinkedList.Node node = list.getHead();
        BTree.TreeNode root = tree.getRoot();
        while(node != null) {
            root = add(root, node.getData());
            node = node.getNext();
        }
        tree.setRoot(root);
        return tree;
    }

    private BTree.TreeNode add(BTree.TreeNode node, String element) {
        if(node == null) {
            return new BTree.TreeNode(element);
        }
        int comparison = ((String)node.getValue()).compareTo(element);
        if(comparison > 0) {
            node.setLeft(add(node.getLeft(), element));
        } else if (comparison < 0){
            node.setRight(add(node.getRight(), element));
        }
        return node;
    }
}
