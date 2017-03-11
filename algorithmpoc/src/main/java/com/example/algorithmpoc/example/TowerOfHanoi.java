package com.example.algorithmpoc.example;

import android.util.Log;


import com.example.algorithmpoc.sample.SampleAction;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Cyho on 22/01/2017.
 */
public class TowerOfHanoi implements SampleAction {
    @Override
    public void action() {
        //Create 3 stacks
        Stack<Integer> origin = new Stack<Integer>();
        Stack<Integer> destination = new Stack<Integer>();

        int length = 5;
        for (int index = length; index > 0; index--) {
            origin.push(index);
        }

        Log.e(getClass().getName(), Arrays.toString(origin.toArray()));
        Log.e(getClass().getName(), Arrays.toString(destination.toArray()));

        moveStack(origin, destination);

        Log.e(getClass().getName(), Arrays.toString(origin.toArray()));
        Log.e(getClass().getName(), Arrays.toString(destination.toArray()));
    }

    private void moveStack(Stack<Integer> origin, Stack<Integer> destination) {
        Stack<Integer> buffer = new Stack<Integer>();
        moveStack(origin.size(), origin, buffer, destination);
    }

    private void moveStack(int size, Stack<Integer> origin, Stack<Integer> buffer, Stack<Integer> destination) {
        if (size > 0) {
            moveStack(size - 1, origin, destination, buffer);
            moveFromSourceToDestination(origin, destination);
            moveStack(size - 1, buffer, origin, destination);
        }
    }

    private void moveFromSourceToDestination(Stack<Integer> origin, Stack<Integer> destination) {
        Integer value = origin.pop();
        if (destination.size() == 0 || destination.peek() >  value) {
            destination.push(value);
        } else {
            Log.e(getClass().getName(), "ERROR, Insertion of value: " + value + " to destination " + destination.peek());
        }
    }
}
