/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Charles
 */
public class BoardPanel extends JPanel implements ActionListener {

    JButton cell = new JButton();
    public static JButton cells[][] = new JButton[Board.rows][Board.cols];

    public BoardPanel() {
        setPreferredSize(new Dimension(800, 800));
        setLayout(new GridLayout(Board.rows, Board.cols));

        for (int i = 0; i < Board.rows; i++) {
            for (int j = 0; j < Board.cols; j++) {
                cell = new JButton();
                cells[i][j] = cell;
                add(cells[i][j]);
                cells[i][j].setBackground(Color.BLACK);
                cells[i][j].addActionListener(this);
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        for (int i = 0; i < Board.rows; i++) {
            for (int j = 0; j < Board.cols; j++) {
                if (source == cells[i][j]) 
                {
                    if("Empty".equals(OptionPanel.selectedClicker))
                    {
                        Board.board[i][j] = 0;
                        cells[i][j].setBackground(Color.BLACK);
                    }
                    if("Wire".equals(OptionPanel.selectedClicker))
                    {
                        Board.board[i][j] = 1;
                        cells[i][j].setBackground(Color.YELLOW);
                    }
                    if("Electron Head".equals(OptionPanel.selectedClicker))
                    {
                        Board.board[i][j] = 2;
                        cells[i][j].setBackground(Color.BLUE);
                    }
                    if("Electron Tail".equals(OptionPanel.selectedClicker))
                    {
                        Board.board[i][j] = 3;
                        cells[i][j].setBackground(Color.RED);
                    }
                    if("Diode".equals(OptionPanel.selectedClicker))
                    {
                        Diode.DiodeInsert(i, j);
                    }
                    if("DiodeReversed".equals(OptionPanel.selectedClicker))
                    {
                        DiodeReversed.DiodeReversedInsert(i, j);
                    }
                    if("GateOR".equals(OptionPanel.selectedClicker))
                    {
                        GateOR.GateORInsert(i, j);
                    }
                    if("GateXOR".equals(OptionPanel.selectedClicker))
                    {
                        GateXOR.GateXORInsert(i, j);
                    }
                }
            }
        }
    }
}
