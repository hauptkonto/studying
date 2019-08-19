package Problems.Top50.group20;

import DataStructures.Trees.BTree;
import DataStructures.Trees.TreeTraverser;
import Utility.IProblem;

/**
 * Problems related to tree traversal.
 *
 * This problem was obtained from the following url:
 * https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
 *
 * @author Marcelo
 */
public class N23_to_N29_BTree implements IProblem {

    @Override
    public String GetName() {
        return this.getClass().getName();
    }

    @Override
    public void Execute() {
        TreeTraverser tt = new TreeTraverser();
        BTree tree = new BTree();
        // N23
        tt.RecursivePreOrder(tree.getRoot());
        // N24
        tt.IterativePreOrder(tree.getRoot());
        // N25
        tt.RecursiveInOrder(tree.getRoot());
        // N26
        tt.IterativeInOrder(tree.getRoot());
        // N27
        tt.RecursivePostOrder(tree.getRoot());
        // N28
        tt.IterativePostOrderDualStack(tree.getRoot()); // Beautiful
        tt.IterativePostOrderSingleStack(tree.getRoot());
        // N29
        TreeTraverser.printLeaves(new BTree());
    }

}