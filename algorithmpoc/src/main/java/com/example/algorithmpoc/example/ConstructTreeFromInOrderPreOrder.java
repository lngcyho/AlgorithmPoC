package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.model.TreeNode;
import com.example.algorithmpoc.sample.Sample;
import com.example.algorithmpoc.sample.SampleAction;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Cyho on 07/01/2017.
 */
public class ConstructTreeFromInOrderPreOrder extends Sample implements SampleAction {
    @Override
    public void action() {
        Log.e(getClass().toString(), "Beginning Execution of Code");

        //Given PreOrder & InOrder, find tree
        List<Integer> inOrder = Arrays.asList(10,20,30,40,50,60,70);
        List<Integer> preOrder = Arrays.asList(40,20,10,30,60,50,70);
        List<Integer> postOrder = Arrays.asList(10,30,20,50,70,60,40);

        TreeNode node = constructTree (inOrder, preOrder);

        //check if this is correct
        TreeInOrderTraversal treeTraversal = new TreeInOrderTraversal();
        treeTraversal.preOrderTravel(node);
        treeTraversal.inOrderTraversal(node);
    }

    private TreeNode constructTree(List<Integer> inOrder, List<Integer> preOrder) {
        // retrieve first value of preOrder as that is the 'root'
        // notice the value on the left or inOrder is on teh left hand side of the tree and the right of inOrder is the right hand side
        if (inOrder.size() == 0) {
            return null;
        }

        Integer root = preOrder.get(0);
        //Locate root in inOrder
        int index = inOrder.indexOf(root);
        //set node as root
        TreeNode node = new TreeNode(root);

        //pass in left set of list and left set of preOrder
        List<Integer> leftSubInOrderTree = inOrder.subList(0, index);
        List<Integer> leftSubPreOrderTree = preOrder.subList(1, index + 1);     //length of index
        node.left = constructTree(leftSubInOrderTree, leftSubPreOrderTree);

        //pass in right set of list and right set of PreOrder
        List<Integer> rightSubInOrderTree = inOrder.subList(index+1, inOrder.size());
        List<Integer> rightSubPreOrderTree = preOrder.subList(index + 1, preOrder.size());     //length of index
        node.right = constructTree(rightSubInOrderTree, rightSubPreOrderTree);

        return node;
    }
}
