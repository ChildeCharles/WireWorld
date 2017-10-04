/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Charles
 */
public class WireworldFrame extends JFrame{
    JFrame frame = new JFrame();
    JPanel rightPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    
    
    public WireworldFrame(){
        super("WireWorld");
        frame.setSize(1280,800);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        rightPanel =  new BoardPanel();
        leftPanel = new OptionPanel();
        
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(leftPanel, BorderLayout.WEST);
    }
    
}
