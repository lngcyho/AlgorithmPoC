package com.example.algorithmpoc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.algorithmpoc.R;
import com.example.algorithmpoc.example.BestTimeToBuyAndSellStocks;
import com.example.algorithmpoc.example.BinarySearch;
import com.example.algorithmpoc.example.EggDrop;
import com.example.algorithmpoc.example.ExpressionAddSubtractMultipleOperator;
import com.example.algorithmpoc.example.ExpressionAddSubtractOperator;
import com.example.algorithmpoc.example.ExpressionAddSubtractOperatorWithSumOfSubset;
import com.example.algorithmpoc.example.FindSubsetOfSum;
import com.example.algorithmpoc.example.IncreasingSubSequence;
import com.example.algorithmpoc.example.JumpOneOrTwoOrThree;
import com.example.algorithmpoc.example.NumberOfPath;
import com.example.algorithmpoc.example.PartitionSample;
import com.example.algorithmpoc.example.PermutationSample;
import com.example.algorithmpoc.example.TicTacToe;
import com.example.algorithmpoc.example.TowerOfHanoi;
import com.example.algorithmpoc.example.TraverseTreeSum;
import com.example.algorithmpoc.example.TreeInOrderTraversal;
import com.example.algorithmpoc.gson.ParseGson;
import com.example.algorithmpoc.sample.Sample;
import com.example.algorithmpoc.sample.SampleAction;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Write sample code here :)
//        SampleAction sample = new SimpleStringProblem();
//        SampleAction sample = new ConstructTreeFromInOrderPreOrder();
//        SampleAction sample = new PermutationSample();
//        SampleAction sample = new ExclusionSample();
//        SampleAction sample = new TreeInOrderTraversal();
//        SampleAction sample = new MergeSort();
//        SampleAction sample= new QuickSort();
//        SampleAction sample = new FindSubsetOfSum();
//        SampleAction sample = new ConstructTreeFromInOrderLevelOrder();
//        SampleAction sample = new ComparatorSample();
//        SampleAction sample = new canIWin();
//        SampleAction sample = new PartitionSample();
//        SampleAction sample = new NestedIntegerSample();
//        SampleAction sample = new HeapSample();
//        SampleAction sample = new JumpSample();
//        SampleAction sample = new ConstructTreeFromArray();
//        SampleAction sample = new KnapsackProblem2();
//        SampleAction sample = new TowerOfHanoi();

//        SampleAction sample = new IncreasingSubSequence();
//        SampleAction sample = new TraverseTreeSum();
//        SampleAction sample = new ExpressionAddSubtractOperatorWithSumOfSubset();
//        SampleAction sample =  new ExpressionAddSubtractOperator();
//        SampleAction sample= new ExpressionAddSubtractMultipleOperator();
//        SampleAction sample = new NumberOfPath();
//        SampleAction sample = new JumpOneOrTwoOrThree();
//        SampleAction sample = new EggDrop();
//        SampleAction sample = new BinarySearch();
//        SampleAction sample = new BestTimeToBuyAndSellStocks();
//        SampleAction sample = new FindSubsetOfSum();
//        SampleAction sample = new TicTacToe();
//        sample.action();

        ParseGson sample = new ParseGson(this);
        sample.action();
    }

    private void comparitorSample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer lhs, Integer rhs) {
                return (lhs < rhs) ? -1 : 1;
            }
        });
    }

    private void stringParseToInt() {
        String name = "123123";
        for (Character c : name.toCharArray()) {
            Integer.parseInt(c.toString());
            System.out.println(c);
        }
    }

    private void appendObjectToArray() {
        StringBuilder[] sbArray = new StringBuilder[15];
        for (int i = 0; i < 15; i++) {
            sbArray[i] = new StringBuilder();
        }
        sbArray[0].append('a');
    }

    private void testStrings() {
        String value = "\tasd";
        Integer length = value.length();
        Integer index = value.indexOf('\t');
        Log.e(getClass().getName(), length.toString());
        Log.e(getClass().getName(), index.toString());
        findIndex(value, '\t');
    }

    private void findIndex(String value, char c) {
        //4 Characters in \tasd
        for (Character character : value.toCharArray()) {
            Log.e(getClass().getName(), character.toString());
        }
    }
}
