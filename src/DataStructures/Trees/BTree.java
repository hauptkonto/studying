package DataStructures.Trees;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BTree {
    private TreeNode root;

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
    public class TreeNode {
        private String value;
        private TreeNode left, right;

        public TreeNode(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
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
