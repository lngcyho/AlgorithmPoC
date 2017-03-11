package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.SampleAction;

/**
 * Created by Cyho on 17/02/2017.
 */

public class TicTacToe implements SampleAction {
    private final char emptyChar = '-';

    @Override
    public void action() {
        int size = 3;
        char[][] board = new char[size][size];
        char playerX = 'X';
        char playerO = 'O';

        initBoard(board, size);
        Boolean didIWin = playTicTacToe(board, size, playerX, playerO);
        Log.e(getClass().getName(), didIWin.toString());
    }

    private void initBoard(char[][] board, int size) {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                board[row][column] = emptyChar;
            }
        }
    }

    private boolean playTicTacToe(char[][] board, int size, char player, char previousPlayer) {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (canSelectSlot(board, row, column)) {
                    //select slot
                    board[row][column] = player;
                    if (playerWin(board, size, player) || !playTicTacToe(board, size, previousPlayer, player)) {
                        clearSpot(board, row, column);
                        return true;
                    }
                    clearSpot(board, row, column);
                }
            }
        }
        return false;
    }

    private void clearSpot(char[][] board, int row, int column) {
        board[row][column] = emptyChar;
    }

    private boolean playerWin(char[][] board, int size, char player) {
        if (checkVertical(board, size, player) || checkHorizontal(board, size, player) || checkDiagonal(board, size, player)) {
            return true;
        }
        return false;
    }

    private boolean checkDiagonal(char[][] board, int size, char player) {
        boolean isLeftUpToRightDownDiag = true;
        for (int column = 0; column < size; column++) {
            if (board[column][column] != player) {
                isLeftUpToRightDownDiag = false;
            }
        }
        if (isLeftUpToRightDownDiag) {
            return true;
        }

        boolean isLeftDownToRightUp = true;
        for (int column = 0; column < size; column++) {
            if (board[size - 1 - column][column] != player) {
                isLeftDownToRightUp = false;
            }
        }
        if (isLeftDownToRightUp) {
            return true;
        }
        return false;
    }

    private boolean checkHorizontal(char[][] board, int size, char player) {
        for (int row = 0; row < size; row++) {
            boolean isHorizontal = true;
            for (int column = 0; column < size; column++) {
                if (board[row][column] != player) {
                    isHorizontal = false;
                }
            }
            if (isHorizontal) {
                return true;
            }
        }
        return false;
    }

    private boolean checkVertical(char[][] board, int size, char player) {
        for (int column = 0; column < size; column++) {
            boolean isVertical = true;
            for (int row = 0; row < size; row++) {
                if (board[row][column] != player) {
                    isVertical = false;
                }
            }
            if (isVertical) {
                return true;
            }
        }
        return false;
    }

    private boolean canSelectSlot(char[][] board, int row, int column) {
        if (board[row][column] == emptyChar) {
            return true;
        }
        return false;
    }
}
