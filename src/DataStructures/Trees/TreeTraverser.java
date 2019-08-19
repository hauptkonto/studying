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

    public static void printLeaves(BTree tree) {
        System.out.print("Leaves: ");
        printLeavesRecursive(tree.getRoot());
        System.out.println();
    }
    private static void printLeavesRecursive(BTree.TreeNode node) {
        if(node == null) {
            return;
        }
        if(node.isLeaf()) {
            System.out.print(node.getValue());
            return;
        }
        printLeavesRecursive(node.getLeft());
        printLeavesRecursive(node.getRight());
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
        Stack<BTree.TreeNode> stack = new Stack<>();
        // The while condition changes since this time we don't add an initial node to the stack.
        while(!stack.isEmpty() || node != null) {
            if(node != null) {
                // If the current node is not null, we push it into the stack and set it's left child as current.
                stack.push(node);
                node = node.getLeft();
            } else {
                // if the current node is null, we get one from the stack and visit it. Then we set the right child
                // of the current node as the new current node.
                node = stack.pop();
                result += node.getValue();
                node = node.getRight();
            }
        }
        return result;
    }

    public String IterativePostOrderDualStack(BTree.TreeNode node) {
        String result = "";
        if(node == null || node.getValue() == null) {
            return result;
        }
        // Dual Stack implementation
        Stack<BTree.TreeNode> mainStack = new Stack<>();
        Stack<BTree.TreeNode> auxStack = new Stack<>();
        mainStack.push(node);
        while(!mainStack.isEmpty()) {
            // Get the current node and put it into the aux stack
            BTree.TreeNode currentNode = mainStack.pop();
            auxStack.push(currentNode);
            // Add the current node's children to the main stack for future iterations.
            if(currentNode.getLeft() != null) {
                mainStack.push(currentNode.getLeft());
            }
            if(currentNode.getRight() != null) {
                mainStack.push(currentNode.getRight());
            }
        }
        // Print second stack. Amazing result.
        while(!auxStack.isEmpty()){
            result += auxStack.pop().getValue();
        }
        return result;
    }

    /**
     * Source: https://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
     * 1.1 Create an empty stack
     * 2.1 Do following while root is not NULL
     *     a) Push root's right child and then root to stack.
     *     b) Set root as root's left child.
     * 2.2 Pop an item from stack and set it as root.
     *     a) If the popped item has a right child and the right child
     *        is at top of stack, then remove the right child from stack,
     *        push the root back and set root as root's right child.
     *     b) Else print root's data and set root as NULL.
     * 2.3 Repeat steps 2.1 and 2.2 while stack is not empty.
     */
    public String IterativePostOrderSingleStack(BTree.TreeNode node) {
        String result = "";
        if(node == null || node.getValue() == null) {
            return result;
        }
        Stack<BTree.TreeNode> stack = new Stack<BTree.TreeNode>();
        while (!stack.isEmpty() || node != null) {
            if(node != null) {
                if(node.getRight() != null) {
                    stack.push(node.getRight());
                }
                stack.push(node);
                node = node.getLeft();
            } else {
                node = stack.pop();
                if(node.getRight() != null && stack.size() > 0 && node.getRight() == stack.peek()) {
                    // Current node has a right child that is also the
                    // one at the top of the stack
                    stack.pop();
                    stack.push(node);
                    node = node.getRight();
                } else {
                    result += node.getValue();
                    node = null;
                }
            }
        }
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

    /**
     * Used for debugging.
     */
    public String stackToString(Stack<BTree.TreeNode> stack) {
        String result = "";
        for (BTree.TreeNode node : stack ) {
            result += node.getValue();
        }
        return result;
    }
}
