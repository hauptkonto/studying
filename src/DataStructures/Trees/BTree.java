package DataStructures.Trees;

import java.util.ArrayList;
import java.util.List;

public class BTree<T> {
    private TreeNode<T> root;

    public BTree() {
        setupExampleData(15);
    }

    public TreeNode getRoot() {
        return root;
    }

    private void setupExampleData(int size) {
        int ASCII_OFFSET = 65;
        for (int i = 0; i < size; i++) {
            char letter = (char)(ASCII_OFFSET + i);
            breathFirstAdd(letter + "");
        }
    }

    public void balancedAdd(Integer element) {
        root = recursiveBalancedAdd(element, root);
    }

    private TreeNode recursiveBalancedAdd(Integer element, TreeNode node) {
        if(node == null) {
            return new TreeNode(element);
        } else {
            Integer value = (Integer)node.getValue();
            if(element < value) {
                return recursiveBalancedAdd(element, node.getLeft());
            } else if(value < element) {
                return recursiveBalancedAdd(element, node.getRight());
            }
        }
        return node;
    }

    public void breathFirstAdd(String value) {
        TreeNode newNode = new TreeNode(value);
        if(value == null)
            return;
        if(root == null) {
            root = newNode;
            return;
        }
        List<TreeNode> currentChildren = new ArrayList<TreeNode>();
        currentChildren.add(root);
        while(true) {
            List<TreeNode> nextChildren = new ArrayList<TreeNode>();
            for (TreeNode node : currentChildren) {
                if(node.left == null) {
                    node.left = newNode;
                    return;
                }
                if(node.right == null) {
                    node.right = newNode;
                    return;
                }
                nextChildren.addAll(node.getChildren());
            }
            currentChildren = nextChildren;
        }
    }

    /**
     * Node used within this tree class.
     */
    public class TreeNode<T> {
        private T value;
        private TreeNode left, right;

        public TreeNode(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public String toString() {
            return this.value + "";
        }

        public boolean isLeaf() {
            return this.left == null && this.right == null;
        }

        /**
         * Required for Breath First traverse and adding.
         */
        public List<TreeNode> getChildren() {
            List<TreeNode> children = new ArrayList<TreeNode>();
            if(left != null) {
                children.add(left);
            }
            if(right != null) {
                children.add(right);
            }
            return children;
        }
    }
}
