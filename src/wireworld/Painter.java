/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import java.awt.Color;

/**
 *
 * @author Charles
 */
public class Painter {
    public static void Painter(int rows, int cols, int[][] board){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 0)
                {
                    BoardPanel.cells[i][j].setBackground(Color.BLACK);
                }
                if(board[i][j] == 1)
                {
                    BoardPanel.cells[i][j].setBackground(Color.YELLOW);
                }
                if(board[i][j] == 2)
                {
                    BoardPanel.cells[i][j].setBackground(Color.BLUE);
                }
                if(board[i][j] == 3)
                {
                    BoardPanel.cells[i][j].setBackground(Color.RED);
                }
            }
        }
    }
    
}
