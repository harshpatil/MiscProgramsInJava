package main.machineCoding;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * Write a program for Sudoku game
 * 1) each row and column should not have duplicate numbers
 * 2) Each grid(3*3) should not have duplicate values
 * 3) Number should be between 1 and 9
 *
 */
public class Sudoku {

    public static void main(String []args){

        LinkedHashMap<Integer, Integer> list = new LinkedHashMap<>();

        boolean valid;
        int[][] board = {{7,6,9,3,4,2,1,5,8},
                        {3,5,4,7,8,1,6,9,2},
                        {1,8,2,6,9,5,4,7,3},
                        {5,9,3,1,7,8,2,6,4},
                        {4,1,7,2,6,3,5,8,9},
                        {6,2,8,9,5,4,3,1,7},
                        {8,3,5,4,1,9,7,2,6},
                        {2,7,1,8,3,6,9,4,5},
                        {9,4,6,5,2,7,8,3,1}};

        boolean isRowAndColumnValid = checkRowAndColumnValidity(board);
        if(isRowAndColumnValid){
                boolean isGridValid = checkGridValidity(board);
                if (isGridValid){
                    System.out.println("Valid Sudoku");
                } else {
                    System.out.println("InValid Sudoku");
                }
        }else {
            System.out.println("InValid Sudoku");
        }
    }

    public static boolean checkGridValidity(int[][] board) {

        for (int block = 0; block < 9; block++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = (block / 3) * 3; i < (block / 3) * 3 + 3; i++) {
                for (int j = (block % 3) * 3; j < (block % 3) * 3 + 3; j++) {
                    if (map.containsKey(board[i][j]) || (board[i][j]<1 || board[i][j]>9)) {
                        return false;
                    } else {
                        map.put(board[i][j], 1);
                    }
                }
            }
        }
        return true;
    }

    public static boolean checkRowAndColumnValidity(int[][] board){

        for(int i=0;i<board.length; i++){
            HashMap<Integer, Integer> rowMap = new HashMap<>();
            HashMap<Integer, Integer> colMap = new HashMap<>();
            for (int j=0;j<board.length; j++){
                if(rowMap.containsKey(board[i][j]) || (board[i][j]<1 || board[i][j]>9)){
                    return false;
                } else {
                    rowMap.put(board[i][j], 1);
                }
                if(colMap.containsKey(board[j][i]) || (board[j][i]<1 || board[j][i]>9)){
                    return false;
                } else {
                    colMap.put(board[j][i], 1);
                }
            }
        }
        return true;
    }

}
