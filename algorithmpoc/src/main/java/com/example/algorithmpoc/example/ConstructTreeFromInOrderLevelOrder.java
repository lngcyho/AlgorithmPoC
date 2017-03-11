package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.model.TreeNode;
import com.example.algorithmpoc.sample.Sample;
import com.example.algorithmpoc.sample.SampleAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Cyho on 07/01/2017.
 */
public class ConstructTreeFromInOrderLevelOrder extends Sample implements SampleAction {
    @Override
    public void action() {
        Log.e(getClass().toString(), "Beginning Execution of Code");


        //Given LevelOrder & InOrder, find tree
        List<Integer> inOrder = Arrays.asList(10, 20, 30, 40, 50, 60, 70);
        List<Integer> preOrder = Arrays.asList(40, 20, 10, 30, 60, 50, 70);
        List<Integer> postOrder = Arrays.asList(10, 30, 20, 50, 70, 60, 40);
        List<Integer> levelOrder = Arrays.asList(40, 20, 60, 10, 30, 50, 70);
        List<Integer> zigZag = Arrays.asList(40, 20, 60, 70, 50, 30, 10);


        TreeNode node = constructTree(levelOrder, inOrder);

        int[] numbers;
        TreeInOrderTraversal sample = new TreeInOrderTraversal();
        sample.inOrderTraversal(node);

        sortNumbers(inOrder);
    }

    private void sortNumbers(List<Integer> inOrder) {
        List<Integer> newList = new ArrayList<Integer>(inOrder);
        Collections.sort(newList, new Comparator<Integer>() {
            @Override
            public int compare(Integer lhs, Integer rhs) {
                return (lhs <= rhs) ? -1 : 1;
            }
        });
        Log.e(getClass().toString(), Arrays.toString(newList.toArray()));
    }

    private TreeNode constructTree(List<Integer> levelOrder, List<Integer> inOrder) {
        if (inOrder.size() == 0) {
            return null;
        }

        //retrieve first element of levelOrder, this is the root
        Integer root = levelOrder.get(0);

        //find index in inOrder and cut the list in half
        int index = inOrder.indexOf(root);

        TreeNode node = new TreeNode(root);

        //take left subList and recursive call
        List<Integer> leftInOrderSubList = inOrder.subList(0, index);
        List<Integer> leftLevelOrderSubList = getLevelOrderList(leftInOrderSubList, levelOrder);
        node.left = constructTree(leftLevelOrderSubList, leftInOrderSubList);

        //take right subList and recursive call
        List<Integer> rightInOrderSubList = inOrder.subList(index + 1, inOrder.size());
        List<Integer> rightLevelOrderSubList = getLevelOrderList(rightInOrderSubList, levelOrder);
        node.right = constructTree(rightLevelOrderSubList, rightInOrderSubList);

        return node;
    }

    private List<Integer> getLevelOrderList(List<Integer> inOrderSubList, List<Integer> levelOrder) {
        List<Integer> levelOrderSublist = new ArrayList<>();
        for (Integer value : levelOrder) {
            if (inOrderSubList.contains(value)) {
                levelOrderSublist.add(value);
            }
        }
        return levelOrderSublist;
    }
}


