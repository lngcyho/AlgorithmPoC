package com.example.algorithmpoc.example;

import com.example.algorithmpoc.model.TreeNode;
import com.example.algorithmpoc.sample.SampleAction;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Cyho on 16/01/2017.
 */
public class ConstructTreeFromArray implements SampleAction {


    @Override
    public void action() {
        List<Integer> listOfNumbers = Arrays.asList(40, 20, 10, 30, 60, 50, 70);

        TreeNode root = constructTree(listOfNumbers);

        TreeInOrderTraversal treeInOrderTraversal  = new TreeInOrderTraversal();
        treeInOrderTraversal.levelOrderTraversal(root);
    }

    private TreeNode constructTree(List<Integer> listOfNumbers) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(listOfNumbers.get(0));
        queue.add(root);

        TreeNode currentRoot = root;
        boolean left = true;
        for (int index = 1; index < listOfNumbers.size(); index++) {
            // for every N is root
            // 2N +1 & 2n+2 is child
            TreeNode node = new TreeNode(listOfNumbers.get(index));
            if (beginningOfLevel(currentRoot)) {
                currentRoot = queue.remove();
            }
            if (shouldInsertLeft(currentRoot, left)) {
                currentRoot.left = node;
                queue.add(node);
            } else {//shouldInsertRight
                currentRoot.right = node;
                queue.add(node);
            }
            left = !left;   //toggle
        }
        return root;
    }

    private boolean shouldInsertLeft(TreeNode root, boolean left) {
        if (root.left == null && left) {
            return true;
        }
        return false;
    }

    private boolean shouldInsertRight(TreeNode root, boolean left) {
        if (root.right == null && !left) {
            return true;
        }
        return false;
    }

    private boolean beginningOfLevel(TreeNode root) {
        return (root.left == null && root.right == null) || (root.left != null && root.right != null);
    }
}
