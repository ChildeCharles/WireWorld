/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wireworld;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Charles
 */

public class GateXOR extends Structures {
   public static void GateXORInsert(int i, int j){
       if(i < 2 || i > Board.rows-3 || j > Board.cols-5)
       {
           showMessageDialog(null, "Can't place GateXOR here. Not enough space.");        
       }
       else
       {
           Board.board[i-2][j] = 0;
           Board.board[i-2][j+1] = 1;
           Board.board[i-2][j+2] = 0;
           Board.board[i-2][j+3] = 0;
           Board.board[i-2][j+4] = 0;
           
           Board.board[i-1][j] = 1;
           Board.board[i-1][j+1] = 1;
           Board.board[i-1][j+2] = 1;
           Board.board[i-1][j+3] = 1;
           Board.board[i-1][j+4] = 0;
           
           Board.board[i][j] = 1;
           Board.board[i][j+1] = 0;
           Board.board[i][j+2] = 0;
           Board.board[i][j+3] = 1;
           Board.board[i][j+4] = 1;
           
           Board.board[i+1][j] = 1;
           Board.board[i+1][j+1] = 1;
           Board.board[i+1][j+2] = 1;
           Board.board[i+1][j+3] = 1;
           Board.board[i+1][j+4] = 0;
           
           Board.board[i+2][j] = 0;
           Board.board[i+2][j+1] = 1;
           Board.board[i+2][j+2] = 0;
           Board.board[i+2][j+3] = 0;
           Board.board[i+2][j+4] = 0;

           
           
           Painter.Painter(Board.rows, Board.cols, Board.board);
       }
   }
    
}