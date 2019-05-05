package DataStructures.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraverser {

    //<editor-fold desc="Recursive">
    public String RecursivePreOrder(BTree.TreeNode node) {
        String result = "";
        if(node == null) {
            return result;
        }
        result += node.getValue();
        result += RecursivePreOrder(node.getLeft());
        result += RecursivePreOrder(node.getRight());
        return result;
    }

    public String RecursiveInOrder(BTree.TreeNode node) {
        String result = "";
        if(node == null) {
            return result;
        }
        result += RecursiveInOrder(node.getLeft());
        result += node.getValue();
        result += RecursiveInOrder(node.getRight());
        return result;
    }

    public String RecursivePostOrder(BTree.TreeNode node) {
        String result = "";
        if(node == null) {
            return result;
        }
        result += RecursivePostOrder(node.getLeft());
        result += RecursivePostOrder(node.getRight());
        result += node.getValue();
        return result;
    }
    //</editor-fold>

    //<editor-fold desc="Iterative">
    public String IterativePreOrder(BTree.TreeNode node) {
        String result = "";
        if(node == null || node.getValue() == null) {
            return result;
        }
        Stack<BTree.TreeNode> stack = new Stack<BTree.TreeNode>();
        stack.push(node);
        while(!stack.isEmpty()) {
            BTree.TreeNode currentNode = stack.pop();
            result += currentNode.getValue();
            // Push right node first if it exists.
            if(currentNode.getRight() != null) {
                stack.push(currentNode.getRight());
            }
            if(currentNode.getLeft() != null) {
                stack.push(currentNode.getLeft());
            }
        }
        return result;
    }
    public String IterativeInOrder(BTree.TreeNode node) {
        String result = "";
        if(node == null || node.getValue() == null) {
            return result;
        }
        // TODO: Implement me...
        return result;
    }
    public String IterativePostOrder(BTree.TreeNode node) {
        String result = "";
        if(node == null || node.getValue() == null) {
            return result;
        }
        // TODO: Implement me...
        return result;
    }
    public String IterativeBreathFirst(BTree.TreeNode node){
        String result = "";
        if(node == null || node.getValue() == null) {
            return result;
        }
        List<BTree.TreeNode> children = new ArrayList<BTree.TreeNode>();
        children.add(node);
        while(!children.isEmpty()) {
            List<BTree.TreeNode> nextChildren = new ArrayList<BTree.TreeNode>();
            for (BTree.TreeNode child: children) {
                result += child.getValue();
                nextChildren.addAll(child.getChildren());
            }
            children = nextChildren;
        }
        return result;
    }
    //</editor-fold>
}
