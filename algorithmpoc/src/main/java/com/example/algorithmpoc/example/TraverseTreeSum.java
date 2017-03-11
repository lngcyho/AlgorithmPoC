package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.model.TreeNode;
import com.example.algorithmpoc.sample.SampleAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Cyho on 10/01/2017.
 */
public class TraverseTreeSum implements SampleAction {
    List<List<Integer>> listOfPathsEqualsSum = new ArrayList<List<Integer>>();

    @Override
    public void action() {
        //[5,4,8,11,null,13,4,7,2,null,null,5,1]
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node11 = new TreeNode(11);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4_2 = new TreeNode(4);
        TreeNode node5_2 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);

        node5.left = node4;
        node5.right = node8;
        node4.left = node11;
        node11.left=node7;
        node11.right=node2;
        node8.left=node13;
        node8.right=node4_2;
        node4_2.left=node5_2;
        node4_2.right=node1;

        pathSum(node5, 22);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //Keep an Array to keep track of path
        //Only is total = sum, return array, otehrwise abandon, pass in sum as argument
        pathSum(root, sum, 0, new ArrayList<Integer>());

        Log.e(getClass().toString(), Arrays.toString(listOfPathsEqualsSum.toArray()));
        return listOfPathsEqualsSum;
    }

    public void pathSum(TreeNode node, int sum, int currentSum, List<Integer> soFar) {
        if (node == null) {
            return;
        }

        //Otherwise
        currentSum += node.value;
        soFar.add(node.value);

        if (currentSum > sum) {
            //no point to execute unless we have negative numbers
            soFar.remove(soFar.size()-1);
            return;
        } else if (currentSum == sum) {
            //we are done
            listOfPathsEqualsSum.add(new ArrayList<Integer>(soFar));        //Either create a new arrayList everytime or you have to keep track or add/remove
            soFar.remove(soFar.size() - 1);
            return;
        } else {
            pathSum(node.left, sum, currentSum, soFar);
            pathSum(node.right, sum, currentSum, soFar);
        }
        soFar.remove(soFar.size() - 1);
    }
}
