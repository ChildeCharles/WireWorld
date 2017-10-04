/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import javax.swing.SwingUtilities;
import static wireworld.OptionPanel.start;

/**
 *
 * @author Charles
 */
public class Animator extends Thread{
    private int genNumber;
    public Animator(int genNumber){
        this.genNumber = genNumber;
    }
    public void run() {
        OptionPanel.start.setEnabled(false);
        OptionPanel.start.setText("In Progress...");
            for (int i = 0; i < genNumber; i++) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        Board.newBoard = Simulator.NextGeneration(Board.rows, Board.cols, Board.board);
                        Board.board = Board.newBoard;
                        Painter.Painter(Board.rows, Board.cols, Board.board);
                            }
                }
                );
                try {
                    Thread.sleep(100/OptionPanel.speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            OptionPanel.start.setText("START");
            OptionPanel.start.setEnabled(true);
        }
    
}
