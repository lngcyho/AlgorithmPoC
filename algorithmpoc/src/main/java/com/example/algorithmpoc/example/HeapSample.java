package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.model.TreeNode;
import com.example.algorithmpoc.sample.SampleAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Cyho on 15/01/2017.
 */
public class HeapSample implements SampleAction {

    //Construct a heap and balance and heapify

    @Override
    public void action() {
        //Construct max heap
        TreeNode node40 = new TreeNode(40);
        TreeNode node20 = new TreeNode(20);
        TreeNode node10 = new TreeNode(10);
        TreeNode node30 = new TreeNode(30);
        TreeNode node60 = new TreeNode(60);
        TreeNode node50 = new TreeNode(50);
        TreeNode node70 = new TreeNode(70);

        node40.left = node20;
        node20.left = node10;
        node20.right = node30;
        node40.right = node60;
        node60.left = node50;
        node60.right = node70;

        constructHeap(node40);
    }

    private void constructHeap(TreeNode node) {
        List<Integer> levelOrder = getLevelOrderTraveral(node);

        //check the root with child via (2n+1) & (2n+2) relationship

        //
        Log.e(getClass().getName() + " Before", Arrays.toString(levelOrder.toArray()));
        Double iterationLength = Math.ceil((levelOrder.size() - 1) / 2);
        for (int index = iterationLength.intValue() ; index >= 0; index--) {
            heapify(levelOrder, index);
        }
        Log.e(getClass().getName() + " After", Arrays.toString(levelOrder.toArray()));
    }

    private void heapify(List<Integer> levelOrder, int index) {
        //check parent and child, find max
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        Integer maxIndex = findMax(levelOrder, index, leftIndex, rightIndex);
        swap(levelOrder, maxIndex, index, leftIndex, rightIndex);
    }

    private void swap(List<Integer> levelOrder, Integer maxIndex, Integer rootIndex, Integer leftChildIndex, Integer rightChildIndex) {
        // if maxIndex == root, do nothing
        if (maxIndex == leftChildIndex) {
            Collections.swap(levelOrder, rootIndex, leftChildIndex);
            heapify(levelOrder, leftChildIndex);
        } else if (maxIndex == rightChildIndex) {
            Collections.swap(levelOrder, rootIndex, rightChildIndex);
            heapify(levelOrder, rightChildIndex);
        }
    }

    private Integer findMax(List<Integer> levelOrder, Integer rootIndex, Integer leftChildIndex, Integer rightChildIndex) {
        Integer root = levelOrder.get(rootIndex);
        Integer leftChild = (leftChildIndex <  levelOrder.size()) ? levelOrder.get(leftChildIndex) : null;
        Integer rightChild = (rightChildIndex < levelOrder.size()) ? levelOrder.get(rightChildIndex) : null;

        Integer indexAtMax = rootIndex;
        Integer max = root;
        if (leftChild != null && leftChild > max) {
            indexAtMax = leftChildIndex;
        }
        if (rightChild!= null && rightChild > max) {
            indexAtMax = rightChildIndex;
        }
        return indexAtMax;
    }

    private List<Integer> getLevelOrderTraveral(TreeNode node) {
        // Generate a arraylist representation of this and this can be build by level order.

        Queue<TreeNode> list = new LinkedList<>();

        List<Integer> levelOrderList = new ArrayList<>();

        list.add(node);
        while (!list.isEmpty()) {
            TreeNode item = list.remove();
            levelOrderList.add(item.value);

            if (item.left != null) {
                list.add(item.left);
            }
            if (item.right != null) {
                list.add(item.right);
            }
        }
        return levelOrderList;
    }


}
