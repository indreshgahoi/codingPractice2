package com.coding2.practice.recurrsion;

import java.util.ArrayList;
import java.util.List;

public class PlaceNQueen {


    public static void main(String[] args) {
        System.out.println(new PlaceNQueen().solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int size){
        final Board board = new Board(size);
        final List<List<String>> results = new ArrayList<>();
        solve(board, 0, results);
        return results;
    }

    private void solve(Board board, int column, List<List<String>> solutions) {
        if (column == board.getSize()) {
            solutions.add(board.getBoard());
            return;
        }
        for (int row = 0; row < board.getSize(); ++row) {
            board.board.get(row).set(column, 'Q');
            if (isSafe(board.board, row, column)) {
                solve(board, column + 1, solutions);
            }
            board.board.get(row).set(column, '.');
        }
    }
    private boolean isSafe(List<List<Character>> board, int row, int column) {
        for(int c = 0 ; c < column; ++c){
            if(board.get(row).get(c)=='Q') return false;
        }
        int x = row - 1, y = column - 1;
        while(x>=0 && y >= 0){
            if(board.get(x).get(y)=='Q') return false;
            x--;y--;
        }

        int xx = row + 1, yy = column - 1;
        while(xx<board.size() && yy>=0){
            if((board.get(xx).get(yy)=='Q'))
                return false;
            xx++; yy--;
        }
        return true;
    }
    private static class Board{
        private List<List<Character>> board;
        private int size;
        Board(final int size){
            this.size = size;
            board = new ArrayList<>(this.size);
            for(int i = 0 ; i < this.size; ++i){
                List<Character> rowStr = new ArrayList<>();
                for(int j = 0; j < this.size; ++j){
                    rowStr.add('.');
                }
                board.add(rowStr);
            }
        }
        public List<String> getBoard(){
            List<String> results = new ArrayList<>();
            for(int i = 0 ; i < this.size ; ++i){
                StringBuilder rStr = new StringBuilder();
                for(int j = 0 ; j < this.size; ++j){
                    rStr.append(board.get(i).get(j));
                }
                results.add(rStr.toString());
            }
            return results;
        }
        public int getSize(){
            return this.size;
        }
    }
}
