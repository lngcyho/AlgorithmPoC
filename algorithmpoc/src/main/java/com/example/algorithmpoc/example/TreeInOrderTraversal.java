package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.model.TreeNode;
import com.example.algorithmpoc.sample.Sample;
import com.example.algorithmpoc.sample.SampleAction;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Cyho on 07/01/2017.
 */
public class TreeInOrderTraversal extends Sample implements SampleAction {
    @Override
    public void action() {
        //Assume graph as follows in pre-order : 40, 20, 10, 30, 60, 50, 70

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

        inOrderTraversal(node40);
        preOrderTravel(node40);
        postOrderTravel(node40);
        levelOrderTraversal(node40);
        zigZagOrderTraversal(node40);

    }

    //Left, Middle, Right
    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        Log.e("InOrderTravsal", Integer.toString(node.value));
        inOrderTraversal(node.right);
    }

    //Middle, Left, Right
    public void preOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }
        Log.e("preOrder", Integer.toString(node.value));
        preOrderTravel(node.left);
        preOrderTravel(node.right);
    }

    //Middle, Left, Right
    public void postOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrderTravel(node.left);
        postOrderTravel(node.right);
        Log.e("postOrderTravel", Integer.toString(node.value));
    }

    public void zigZagOrderTraversal (TreeNode node) {
        //create 2 stack, called LR stack and RL stack

        Stack<TreeNode> leftToRightStack = new Stack<>();
        Stack<TreeNode> rightToLeftStack = new Stack<>();

        leftToRightStack.add(node);

        while(!leftToRightStack.isEmpty() || !rightToLeftStack.isEmpty()) {

            while (!leftToRightStack.isEmpty()) {
                //On case where we start from LR Stack
                TreeNode current = leftToRightStack.pop();
                Log.e("zigZagOrderTraversal", Integer.toString(current.value));

                //Add right left to rightToLeftStack
                if (current.right != null) {
                    rightToLeftStack.add(current.right);
                }
                if(current.left != null) {
                    rightToLeftStack.add(current.left);
                }

            }

            while(!rightToLeftStack.isEmpty()) {
                //In cases where we start from RL Stack
                TreeNode current = rightToLeftStack.pop();
                Log.e("zigZagOrderTraversal", Integer.toString(current.value));

                //Add left right to leftToRightStack
                if (current.left != null) {
                    leftToRightStack.add(current.left);
                }

                if (current.right!= null) {
                    leftToRightStack.add(current.right);
                }
            }
        }

    }

    public void levelOrderTraversal(TreeNode node) {
        //Push node to queue
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);

        while (!queue.isEmpty()) {
            //remove current item, output it
            TreeNode current = queue.remove();
            Log.e("levelOrderTraversal", Integer.toString(current.value));

            //add left and right to queue
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}

