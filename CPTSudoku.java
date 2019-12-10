/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpt.sudoku;

import java.util.ArrayList;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author e.ruiya
 */
public class CPTSudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        Scanner in = new Scanner(System.in);
        //From here to line 100 something is drawing a board ish....
        int[][] Sudoku_grid = new int[9][9];
            /*    { 
         
            {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
         {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
         {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
         {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
         {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
         {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
         {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
         {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
         {0, 0, 5, 2, 0, 6, 3, 0, 0}, 
           
         };
        */
        //Entering the grid
        for (int i = 0; i < 9; i++) {
         System.out.println("Enter sudoku line");
        for (int j = 0; j < 9; j++) {
         Sudoku_grid[i][j] = in.nextInt();
        }
        }
        //Now we are done drawing ish....
        int num = Sudoku_grid.length;
        printing(Sudoku_grid);
        System.out.println("");
        System.out.println("");
        if (Done(Sudoku_grid, num)) {
            printing(Sudoku_grid);
        } else {
            System.out.println("Not a valid board");
        }
    }
//The idea is to solve...

    public static boolean Safe(int[][] grid, int row, int column, int num) {

        for (int i = 0; i < grid.length; i++) {//see if the same number appears in the given row
            if (grid[row][i] == num) {
                return false;//False if number repeats in row
            }
        }


        for (int i = 0; i < grid.length; i++) {//check if same number appears in given column
            if (grid[i][column] == num) {//False if number repeats in column
                return false;
            }
        }
        int boxRow = row - row % 3;
        int boxColumn = column - column % 3;

        for (int i = boxRow; i < boxRow + 3; i++) {//Check to see if same number appears in the box
            for (int j = boxColumn; j < boxColumn + 3; j++) {
                if (grid[i][j] == num) {
                    return false;//False if number repeats in the square
                }
            }
        }
        // if there is no falses it's safe to put the number in --> in Done method
        return true;
    }

    public static boolean Done(int[][] grid, int num) {
        int row = -1;
        int column = -1;
        boolean isEmpty = true;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (grid[i][j] == 0) {
                    row = i;
                    column = j;
                    isEmpty = false;//Not empty, therefore there are still values remaining

                    break;//No need to check any more values
                }
            }
            if (isEmpty == false) {

                break;//Break again to be sure? Might remove...

            }
        }
        if (isEmpty == true) {
            return true;
        }
        for (int k = 1; k <= num; k++) { //num equals 9
            if (Safe(grid, row, column, k)) {
                grid[row][column] = k;
                if (Done(grid, num)) {
                    return true;
                } else {
                    grid[row][column] = 0;
                }
            }
        }
        return false;
    }

    public static void printing(int[][] grid) {
        int i;
        int j;
        for (i = 0; i < 9; i++) {

            for (j = 0; j < 9; j++) {

                System.out.print(grid[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
