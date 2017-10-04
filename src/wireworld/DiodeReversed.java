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

public class DiodeReversed extends Structures {
   public static void DiodeReversedInsert(int i, int j){
       if(i == 0 || i == Board.rows-1 || j > Board.cols-2)
       {
           showMessageDialog(null, "Can't place DiodeReversed here. Not enough space.");        
       }
       else
       {
           Board.board[i-1][j] = 1;
           Board.board[i-1][j+1] = 1;
           
           Board.board[i][j] = 0;
           Board.board[i][j+1] = 1;
           
           Board.board[i+1][j] = 1;
           Board.board[i+1][j+1] = 1;
           
           Painter.Painter(Board.rows, Board.cols, Board.board);
       }
   }
    
}
