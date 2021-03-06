/** Assignment #4.
 * This program simulates a game of 3D tic tac toe with a 
 * computer that plays with strategy.
 * Note: some of the instance variables and methods were taken
 * from the BoardTest java file that was provided for us under resources
 * on ecommons.
 * 
 * Author: Samuel Shin (sayshin@ucsc.edu) 
 **/

import java.util.*;
import java.io.*;
public class TTT3D{
    static int[][][] board = new int[4][4][4];
    static int[] sums = new int[76];
    static final boolean win = false;
    static final int USER_VAL = 5;
    static final int COMP_VAL = 1;
    static final int[][][] lines = {
            {{0,0,0},{0,0,1},{0,0,2},{0,0,3}},  //lev 0; row 0   rows in each level
            {{0,1,0},{0,1,1},{0,1,2},{0,1,3}},  //       row 1
            {{0,2,0},{0,2,1},{0,2,2},{0,2,3}},  //       row 2
            {{0,3,0},{0,3,1},{0,3,2},{0,3,3}},  //       row 3
            {{1,0,0},{1,0,1},{1,0,2},{1,0,3}},  //lev 1; row 0
            {{1,1,0},{1,1,1},{1,1,2},{1,1,3}},  //       row 1
            {{1,2,0},{1,2,1},{1,2,2},{1,2,3}},  //       row 2
            {{1,3,0},{1,3,1},{1,3,2},{1,3,3}},  //       row 3
            {{2,0,0},{2,0,1},{2,0,2},{2,0,3}},  //lev 2; row 0
            {{2,1,0},{2,1,1},{2,1,2},{2,1,3}},  //       row 1
            {{2,2,0},{2,2,1},{2,2,2},{2,2,3}},  //       row 2
            {{2,3,0},{2,3,1},{2,3,2},{2,3,3}},  //       row 3
            {{3,0,0},{3,0,1},{3,0,2},{3,0,3}},  //lev 3; row 0
            {{3,1,0},{3,1,1},{3,1,2},{3,1,3}},  //       row 1
            {{3,2,0},{3,2,1},{3,2,2},{3,2,3}},  //       row 2
            {{3,3,0},{3,3,1},{3,3,2},{3,3,3}},  //       row 3
            {{0,0,0},{0,1,0},{0,2,0},{0,3,0}},  //lev 0; col 0   columns in each level
            {{0,0,1},{0,1,1},{0,2,1},{0,3,1}},  //       col 1
            {{0,0,2},{0,1,2},{0,2,2},{0,3,2}},  //       col 2
            {{0,0,3},{0,1,3},{0,2,3},{0,3,3}},  //       col 3
            {{1,0,0},{1,1,0},{1,2,0},{1,3,0}},  //lev 1; col 0
            {{1,0,1},{1,1,1},{1,2,1},{1,3,1}},  //       col 1
            {{1,0,2},{1,1,2},{1,2,2},{1,3,2}},  //       col 2
            {{1,0,3},{1,1,3},{1,2,3},{1,3,3}},  //       col 3
            {{2,0,0},{2,1,0},{2,2,0},{2,3,0}},  //lev 2; col 0
            {{2,0,1},{2,1,1},{2,2,1},{2,3,1}},  //       col 1
            {{2,0,2},{2,1,2},{2,2,2},{2,3,2}},  //       col 2
            {{2,0,3},{2,1,3},{2,2,3},{2,3,3}},  //       col 3
            {{3,0,0},{3,1,0},{3,2,0},{3,3,0}},  //lev 3; col 0
            {{3,0,1},{3,1,1},{3,2,1},{3,3,1}},  //       col 1
            {{3,0,2},{3,1,2},{3,2,2},{3,3,2}},  //       col 2
            {{3,0,3},{3,1,3},{3,2,3},{3,3,3}},  //       col 3
            {{0,0,0},{1,0,0},{2,0,0},{3,0,0}},  //cols in vert plane in front
            {{0,0,1},{1,0,1},{2,0,1},{3,0,1}},
            {{0,0,2},{1,0,2},{2,0,2},{3,0,2}},
            {{0,0,3},{1,0,3},{2,0,3},{3,0,3}},
            {{0,1,0},{1,1,0},{2,1,0},{3,1,0}},  //cols in vert plane one back
            {{0,1,1},{1,1,1},{2,1,1},{3,1,1}},
            {{0,1,2},{1,1,2},{2,1,2},{3,1,2}},
            {{0,1,3},{1,1,3},{2,1,3},{3,1,3}},
            {{0,2,0},{1,2,0},{2,2,0},{3,2,0}},  //cols in vert plane two back
            {{0,2,1},{1,2,1},{2,2,1},{3,2,1}},
            {{0,2,2},{1,2,2},{2,2,2},{3,2,2}},
            {{0,2,3},{1,2,3},{2,2,3},{3,2,3}},
            {{0,3,0},{1,3,0},{2,3,0},{3,3,0}},  //cols in vert plane in rear
            {{0,3,1},{1,3,1},{2,3,1},{3,3,1}},
            {{0,3,2},{1,3,2},{2,3,2},{3,3,2}},
            {{0,3,3},{1,3,3},{2,3,3},{3,3,3}},
            {{0,0,0},{0,1,1},{0,2,2},{0,3,3}},  //diags in lev 0
            {{0,3,0},{0,2,1},{0,1,2},{0,0,3}},
            {{1,0,0},{1,1,1},{1,2,2},{1,3,3}},  //diags in lev 1
            {{1,3,0},{1,2,1},{1,1,2},{1,0,3}},
            {{2,0,0},{2,1,1},{2,2,2},{2,3,3}},  //diags in lev 2
            {{2,3,0},{2,2,1},{2,1,2},{2,0,3}},
            {{3,0,0},{3,1,1},{3,2,2},{3,3,3}},  //diags in lev 3
            {{3,3,0},{3,2,1},{3,1,2},{3,0,3}},
            {{0,0,0},{1,0,1},{2,0,2},{3,0,3}},  //diags in vert plane in front
            {{3,0,0},{2,0,1},{1,0,2},{0,0,3}},
            {{0,1,0},{1,1,1},{2,1,2},{3,1,3}},  //diags in vert plane one back
            {{3,1,0},{2,1,1},{1,1,2},{0,1,3}},
            {{0,2,0},{1,2,1},{2,2,2},{3,2,3}},  //diags in vert plane two back
            {{3,2,0},{2,2,1},{1,2,2},{0,2,3}},
            {{0,3,0},{1,3,1},{2,3,2},{3,3,3}},  //diags in vert plane in rear
            {{3,3,0},{2,3,1},{1,3,2},{0,3,3}},
            {{0,0,0},{1,1,0},{2,2,0},{3,3,0}},  //diags left slice
            {{3,0,0},{2,1,0},{1,2,0},{0,3,0}},
            {{0,0,1},{1,1,1},{2,2,1},{3,3,1}},  //diags slice one to right
            {{3,0,1},{2,1,1},{1,2,1},{0,3,1}},
            {{0,0,2},{1,1,2},{2,2,2},{3,3,2}},  //diags slice two to right
            {{3,0,2},{2,1,2},{1,2,2},{0,3,2}},
            {{0,0,3},{1,1,3},{2,2,3},{3,3,3}},  //diags right slice
            {{3,0,3},{2,1,3},{1,2,3},{0,3,3}},
            {{0,0,0},{1,1,1},{2,2,2},{3,3,3}},  //cube vertex diags
            {{3,0,0},{2,1,1},{1,2,2},{0,3,3}},
            {{0,3,0},{1,2,1},{2,1,2},{3,0,3}},
            {{3,3,0},{2,2,1},{1,1,2},{0,0,3}}
        };
    //utility display game array
    static void printBoard(){
        for (int lev=3; lev >= 0; lev--){
            for (int row=3; row >= 0; row--){
                System.out.print(lev);
                System.out.print(row);
                for (int col=0; col<4; col++){
                    if(board[lev][row][col] == 0)
                    {
                        System.out.printf(" " + "_");
                    }
                    else if(board[lev][row][col] == COMP_VAL) 
                    {
                        System.out.printf(" " + "O");
                    }
                    else if(board[lev][row][col] == USER_VAL)
                    {
                        System.out.printf(" " + "X");
                    }
                }
                System.out.printf("\n");
            }
            System.out.printf("\n");
        }
        System.out.print("   " + "0" + " " + "1" + " " + "2" + " " + "3");
    }
    //utility display sums array
    static void printSums(){
        for (int i=0; i<sums.length; i++){
            System.out.println("line " +i+ "is " + sums[i]);
        }
    }

    //is a cell at specified adr empty
    static boolean isEmpty(int[] celAdr){
        if (board[celAdr[0]][celAdr[1]][celAdr[2]] == 0){
            return true;
        }
        else{
            return false;
        }
    }

    //place a move on the board by cell adr array
    static void move(int[] celAdr, int val){
        move(celAdr[0], celAdr[1], celAdr[2], val);
    }

    //place a move on the board explicit coordinates
    static void move(int lev, int row, int col, int val){
        board[lev][row][col] = val;
    }

    //clear board to a value
    static void setAll(int val){
        for (int lev = 0; lev < 4; lev++){
            for (int row = 0; row < 4; row++){
                for (int col = 0; col < 4; col++){
                    move(lev, row, col, val);
                }
            }
        }
    }

    //are two cell addresses the same
    static boolean isEqual(int[] a, int[] b){
        for (int i=0; i<a.length; i++){
            if (a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

    //fine empty cell in a line
    static int[] findEmptyCel(int[][]line){
        for (int i=0; i<4; i++){
            if ( isEmpty(line[i]) ) return line[i];
        }
        return null;
    }

    //find common empty cell to two lines
    static int[] findComMtCel(int[][]line1, int[][]line2){
        for (int i=0; i<line1.length; i++ ){
            for (int j=0; j<line1.length; j++ ){
                if (isEqual(line1[i], line2[j]) &&
                isEmpty(line1[i]) &&
                isEmpty(line2[j])) {

                    return line1[i];
                }
            }
        }
        return null;
    }

    static void compLineSums(){
        for (int i=0; i<sums.length; i++){
            sums[i] = 0;
            for (int j=0; j<4; j++){
                sums[i] += board[lines[i][j][0]]
                [lines[i][j][1]]
                [lines[i][j][2]];
            }
        }
    }

    //find line with a specific sum
    static int findLineSum(int sum){
        for (int i=0; i<sums.length; i++){
            if (sums[i] == sum) return i; // line i has the sum
        }
        return -1; //no such sum found
    }

    static boolean checkUserWin()//checks if the human has won
    {
        for (int line = 0; line < 76; line++)
        {
            int value = 0;
            int[] array = new int[3];
            for (int celAdr = 0; celAdr < 4; celAdr++)
            {
                for (int i = 0; i < 3; i++)
                {                   
                    array[i] = lines[line][celAdr][i];

                }
                value += board[array[0]][array[1]][array[2]];
                if(value == 20)
                {
                    System.out.println();
                    System.out.println("Congratulations! You won!");
                    return true;
                }
            }

        }
        return false;
    }

    static boolean checkCompWin()//checks if the cpu has won
    {
        for (int line = 0; line < 76; line++)
        {
            int value = 0;
            int[] array = new int[3];
            for (int celAdr = 0; celAdr < 4; celAdr++)
            {
                for (int i = 0; i < 3; i++)
                {                   
                    array[i] = lines[line][celAdr][i];

                }
                value += board[array[0]][array[1]][array[2]];
                if(value == 4)
                {
                    System.out.println();
                    System.out.println("Computer wins again!");
                    return true;
                }
            }

        }
        return false;
    }


    static void cpuMove()//cpu picks a random spot on the board that is unoccupied
    {
        int seed = 1234;
        Random rand = new Random();
        int address = 0;
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++)
        {
            address = rand.nextInt(3) + 1;
            arr[i] = address;
        }
        if (isEmpty(arr) == true)
        {
            move(arr, COMP_VAL);
        }
        else 
        {
            cpuMove();
        }
    }

     static boolean isCpuOpportunity()//checks if there is a spot that will allow the cpu to win
    {
        compLineSums();
        int line = 0;
        line = findLineSum(3);
        if (line != -1)
        {
            return true;
        }
        return false;
    }

     static void cpuOpportunity()//plays a spot where the cpu will immediately win
    {
	compLineSums();
        int line = 0;
        line = findLineSum(3);
        int[][] coord = new int[4][3];
        int[] empty = new int[3];
        for (int cel = 0; cel < 4; cel++)
        {
            for (int a = 0; a < 3; a++)
            {
                coord[cel][a] = lines[line][cel][a];
            }
        }
        empty = findEmptyCel(coord);
        move(empty, COMP_VAL);
    }
    
    static boolean isBlockHmn()//checks if there is a spot where the human can instantly win
    {
        compLineSums();
        int line = 0;
        line = findLineSum(15);
        if (line != -1)
        {
            return true;
        }
        return false;
    }
    
    static void blockHmn()//blocks human from getting four marks in a row
    {
        compLineSums();
        int line = 0;
        line = findLineSum(15);
        int[][] coord = new int[4][3];
        int[] empty = new int[3];

        for (int cel = 0; cel < 4; cel++)
        {
            for (int a = 0; a < 3; a++)
            {
                coord[cel][a] = lines[line][cel][a];
            }
        }
        empty = findEmptyCel(coord);
        move(empty, COMP_VAL);
    }

    static boolean isCpuFork()//checks if there is a spot where the cpu can make a fork
    {
        compLineSums();
        int line = 0;
        int line2 = 0;
        line = findLineSum(2);
        line2 = findLineSum(2);
        if (line != -1 && line2 != -1)
        {
            return true;
        }
        return false;
    }
    
    static void cpuFork()//makes a fork for the cpu
    {
        compLineSums();
        int line = 0;
        int line2 = 0;
        line = findLineSum(2);
        line2 = findLineSum(2);
        int[][] coord = new int[4][3];
        int[][] coord2 = new int[4][3];
        int[] empty = new int[3];
        
        for (int cel = 0; cel < 4; cel++)
        {
            for (int a = 0; a < 3; a++)
            {
                coord[cel][a] = lines[line][cel][a];
                coord2[cel][a] = lines[line2][cel][a];
            }
        }
        empty = findComMtCel(coord, coord2);
        move(empty, COMP_VAL);
    }

    static boolean isBlockHmnFork()//checks if there is a spot where the human can make a fork
    {
        compLineSums();
        int line = 0;
        int line2 = 0;
        line = findLineSum(10);
        line2 = findLineSum(10);
        if (line != -1 && line2 != -1)
        {
            return true;
        }
        return false;
    }
    
    static void blockHmnFork()//blocks the player from creating a fork
    {
        compLineSums();
        int line = 0;
        int line2 = 0;
        line = findLineSum(10);
        line2 = findLineSum(10);
        int[][] coord = new int[4][3];
        int[][] coord2 = new int[4][3];
        int[] empty = new int[3];
        
        for (int cel = 0; cel < 4; cel++)
        {
            for (int a = 0; a < 3; a++)
            {
                coord[cel][a] = lines[line][cel][a];
                coord2[cel][a] = lines[line2][cel][a];
            }
        }
        empty = findComMtCel(coord, coord2);
        move(empty, COMP_VAL);
    }

    static boolean draw()//checks if game is a draw
    {
	int val;
        for (int lev = 0; lev < 4; lev++)
        {
            for (int cel = 0; cel < 4; cel++)
            {
                for (int i = 0; i < 4; i++)
                {
		    val = board[lev][cel][i];
                    if (val == 0)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //main routine for testing
    public static void main(String[] args) throws FileNotFoundException{
	if (args.length != 0)//checks if there is a setup file or not
	{
        Scanner dataIn = new Scanner(new FileInputStream(args[0]));
        int size = dataIn.nextInt();//reads how many lines there are in file
        int[] file = new int[3];
        int value = 0;
            for (int s = 0; s < size + 1; s++)
            {
                String startUp = dataIn.nextLine();//reads the line as a string
                for (int j = 0; j < startUp.length(); j++)
                {
                    char x = startUp.charAt(j);//convert whole string to indiv char's
                    int y = Character.getNumericValue(x);//convert the chars to int's
                    if (j!= startUp.length() - 1)
                    {
                        file[j] = y;//put the first three int's in an array
                    }
                    else 
                    {
                        value = y;//saves the last int on the line (always 1 or 5)
                    }
                }
                move(file, value);//sets up the board before the game is played
            }
	}
        printBoard();
        while(checkUserWin() == false && checkCompWin() == false && draw() == false)
        //terminates if the user wins, the cpu wins, or the game is a draw
        {
            Scanner scan = new Scanner(System.in);
            System.out.println();
            System.out.println("Type your move as one three digit number(lrc)");
            String loc = scan.nextLine();
            int[] cell = new int[3];
            for(int i = 0; i < cell.length; i++)
            {
                char x = loc.charAt(i);
                int y = Character.getNumericValue(x);
                cell[i] = y;
            }
            if(isEmpty(cell) == true)//checks if the spot is open or not
            {
                move(cell, USER_VAL);//human move
            }
            else
            {
                System.out.println("Sorry that cell is occupied");
                continue;
            }
	    if (draw() == false)//if it's a draw, else statement will skip the cpu's turn to move
            {
                if (isCpuOpportunity() == true)
                {
                    cpuOpportunity();
                }
                else if (isBlockHmn() == true)
                {
                    blockHmn();
                }
                else if (isCpuFork() == true)
                {
                    cpuFork();
                }
                else if (isBlockHmnFork() == true)
                {
                    blockHmnFork();
                }
                else
                {
                    cpuMove();
                }
            }
            else
            {
                System.out.println("The game is a draw!");
            } 
            printBoard(); 

        }
    }
}
