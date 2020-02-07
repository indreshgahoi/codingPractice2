package com.coding2.practice.recurrsion;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class SuDokuSolver {


    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
       new SuDokuSolver().solveSudoku(board);
    }

    private BitSet rows, cols, blocks;

    public void solveSudoku(char[][] board) {
        rows = new BitSet(81);
        cols = new BitSet(81);
        blocks = new BitSet(81);

        for(int i = 0 ; i < 9; ++i){
            for(int j = 0 ; j < 9; ++j){
                 final char ch = board[i][j];
                 if(ch != '.'){
                     rows.set(9*i + ch - '1' + 1);
                     cols.set(9*j + ch - '1' + 1);
                     blocks.set(( ((i/3) * 27) + ((j/3) * 9)) + ch - '1' + 1);
                 }
            }
        }
        debug(board, "problem");
        solve(board, 0);
        debug(board, "solution");

    }
    public boolean solve(char[][] board, int index){
        while(index < 81 && board[index/9][index%9] != '.') index++;
        if(index >= 81) return true;
        int row = index/9;
        int col = index%9;
        int block = (row / 3) * 3 + col/3 ;

        for(int i = 1 ; i < 10 ; i++){
            int ch = '1' + i - 1;
            if(rows.get((row * 9) + i) || cols.get(col * 9 + i) || blocks.get(block * 9 + i)){
                continue;
            }
            board[row][col] = (char)ch;
            rows.set((row * 9) + i);
            cols.set(col * 9 + i);
            blocks.set(block * 9 + i);
            if(solve(board, index + 1)){
                return true;
            }
            rows.clear ((row * 9) + i);
            cols.clear(col * 9 + i);
            blocks.clear(block * 9 + i);
            board[row][col] = '.';
        }
        return false;
    }

    private void debug(char [][] board, String tag){
        System.out.println("--------------------" +  tag + "--------------------------------");
        System.out.println("rows: " +  rows);
        System.out.println("cols: " +  cols);
        System.out.println("blocks: " +  blocks);
        for (char [] r: board) {
            System.out.println(Arrays.toString(r));
        }
    }
}
