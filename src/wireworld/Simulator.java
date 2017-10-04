/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

/**
 *
 * @author Charles
 */
public class Simulator {
    
    private static int countHeads(int i, int j, int rows, int cols, int[][] board){
        int headNumber = 0;
        /*UpperLeft*/
        if(i == 0 && j == 0)
        {
            if(board[i+1][j] == 2)
                headNumber++;
            if(board[i][j+1] == 2)
                headNumber++;
            if(board[i+1][j+1] == 2)
                headNumber++;      
        }
        /*UpperRight*/
        if(i == 0 && j == cols-1)
        {
            if(board[i][j-1] == 2)
                headNumber++;
            if(board[i+1][j-1] == 2)
                headNumber++;
            if(board[i+1][j] == 2)
                headNumber++;      
        }
        /*LowerLeft*/
        if(i == rows-1 && j == 0)
        {
            if(board[i-1 ][j] == 2)
                headNumber++;
            if(board[i-1][j+1] == 2)
                headNumber++;
            if(board[i][j+1] == 2)
                headNumber++;      
        }
        /*LowerRight*/
        if(i == rows-1 && j == cols-1)
        {
            if(board[i-1][j-1] == 2)
                headNumber++;
            if(board[i-1][j] == 2)
                headNumber++;
            if(board[i][j-1] == 2)
                headNumber++;      
        }
        /*UP*/
        if(i == 0 && j > 0 && j < cols-1)
        {
            if(board[i][j-1] == 2)
                headNumber++;
            if(board[i][j+1] == 2)
                headNumber++;
            if(board[i+1][j-1] == 2)
                headNumber++;
            if(board[i+1][j] == 2)
                headNumber++;  
            if(board[i+1][j+1] == 2)
                headNumber++;  
        }
        /*DOWN*/
        if(i == rows-1 && j > 0 && j < cols-1)
        {
            if(board[i-1][j-1] == 2)
                headNumber++;
            if(board[i-1][j] == 2)
                headNumber++;
            if(board[i-1][j+1] == 2)
                headNumber++;
            if(board[i][j-1] == 2)
                headNumber++;  
            if(board[i][j+1] == 2)
                headNumber++;  
        }
        /*LEFT*/
        if(i > 0 && i < rows-1 && j == 0)
        {
            if(board[i-1][j] == 2)
                headNumber++;
            if(board[i+1][j] == 2)
                headNumber++;
            if(board[i-1][j+1] == 2)
                headNumber++;
            if(board[i][j+1] == 2)
                headNumber++;  
            if(board[i+1][j+1] == 2)
                headNumber++;  
        }
        /*RIGHT*/
        if(i > 0 && i < rows-1 && j == cols-1)
        {
            if(board[i-1][j] == 2)
                headNumber++;
            if(board[i+1][j] == 2)
                headNumber++;
            if(board[i-1][j-1] == 2)
                headNumber++;
            if(board[i][j-1] == 2)
                headNumber++;  
            if(board[i+1][j-1] == 2)
                headNumber++;  
        }
        /*CENTER*/
        if(i > 0 && i < rows-1 && j > 0 && j < cols-1)
        {
            if(board[i-1][j-1] == 2)
                headNumber++;
            if(board[i-1][j] == 2)
                headNumber++;
            if(board[i-1][j+1] == 2)
                headNumber++;
            if(board[i][j-1] == 2)
                headNumber++;  
            if(board[i][j+1] == 2)
                headNumber++; 
            if(board[i+1][j-1] == 2)
                headNumber++;
            if(board[i+1][j] == 2)
                headNumber++;  
            if(board[i+1][j+1] == 2)
                headNumber++; 
        }    
        return headNumber;
    }
    private static int WireworldRules(int headNumber, int state){
        int nextState = 0;
        if(state == 0)
            nextState = 0;
        if(state == 1)
        {
            if(headNumber == 1 || headNumber == 2)
                nextState = 2;
            else
                nextState = 1;
        }
        if(state == 2)
            nextState = 3;
        if(state == 3)
            nextState = 1;
        return nextState;
    }
    public static int[][] NextGeneration(int rows, int cols, int[][] board)
    {
        int[][] newBoard = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                newBoard[i][j] = WireworldRules(countHeads(i, j, rows, cols, board), board[i][j]);
            }
        }
        return newBoard;
    }
    
}
