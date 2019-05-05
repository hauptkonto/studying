package Problems;

import DataStructures.Trees.BTree;
import DataStructures.Trees.TreeTraverser;

public class TreeTraversal implements IProblem{

    public void Run() {
        TreeTraverser tt = new TreeTraverser();
        BTree tree = new BTree();
        System.out.println("Tree Traversals: ");
        System.out.println("Recursive Pre Order:    " + tt.RecursivePreOrder(tree.getRoot()));
        System.out.println("Recursive In Order:     " + tt.RecursiveInOrder(tree.getRoot()));
        System.out.println("Recursive Post Order:   " + tt.RecursivePostOrder(tree.getRoot()));
        System.out.println("Iterative Pre Order:    " + tt.IterativePreOrder(tree.getRoot()));
        System.out.println("Iterative In Order:     " + tt.IterativeInOrder(tree.getRoot()));
        System.out.println("Iterative Post Order:   " + tt.IterativePostOrder(tree.getRoot()));
        System.out.println("Iterative Breath First: " + tt.IterativeBreathFirst(tree.getRoot()));
    }
}
