/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.Box.createRigidArea;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Charles
 */
public class OptionPanel extends JPanel implements ActionListener{
    
    public static int speed = 1;
    private String[] structures = {"-----", "Diode", "DiodeReversed", "GateOR", "GateXOR"};
    private String[] state = {"-----", "Empty", "Wire", "Electron Head", "Electron Tail"};
    public static String selectedClicker;
    private int generationNumber = 5;
    
    public static JButton start = new JButton("START");
    private JButton load = new JButton("Load from file");
    private JButton save = new JButton("Save to file");
    private static JButton transisionSpeed = new JButton(Integer.toString(speed));
    private JComboBox selectStructure = new JComboBox(structures);
    private JComboBox selectState = new JComboBox(state);
    private JTextField genNumber = new JTextField("100");
    private JLabel transisionSpeedLabel = new JLabel("Select transision speed:");
    private JLabel selectStructureLabel = new JLabel("Select premade part of circuit:");
    private JLabel selectStateLabel = new JLabel("Select state of cell:");
    private JLabel genNumberLabel = new JLabel("Enter number of generations:");
    
    public OptionPanel(){
        setPreferredSize(new Dimension(460,800));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        add(load);
        add(createRigidArea(new Dimension(0, 20)));
        add(save);
        add(createRigidArea(new Dimension(0, 20)));
        add(selectStructureLabel);
        add(createRigidArea(new Dimension(0, 10)));
        add(selectStructure);
        add(createRigidArea(new Dimension(0, 20)));
        add(selectStateLabel);
        add(createRigidArea(new Dimension(0, 10)));
        add(selectState);
        add(createRigidArea(new Dimension(0, 20)));
        add(genNumberLabel);
        add(createRigidArea(new Dimension(0, 10)));
        add(genNumber);
        add(createRigidArea(new Dimension(0, 20)));
        add(transisionSpeedLabel);
        add(createRigidArea(new Dimension(0, 10)));
        add(transisionSpeed);
        add(createRigidArea(new Dimension(0, 20)));
        add(start);
        add(createRigidArea(new Dimension(0, 400)));
        
        
        start.addActionListener(this);
        load.addActionListener(this);
        save.addActionListener(this);
        transisionSpeed.addActionListener(this);
        selectStructure.addActionListener(this);
        selectState.addActionListener(this);
        genNumber.addActionListener(this);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == start)
        {
           String textFieldValue = genNumber.getText(); 
            try { 
                generationNumber = Integer.parseInt(textFieldValue); 
            } catch (NumberFormatException | NullPointerException ex) { 
                showMessageDialog(null, "Field is empty or isn't integer. Setting generationNumber to 50"); 
                generationNumber = 50;
                 genNumber.setText("50");
            }  
            
            Animator animate = new Animator(generationNumber);
            animate.start();
        }
        if(source == load)
        {
            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try {
                    int rows = Reader.readRows(file);
                    int cols = Reader.readCols(file);
                    int board[][] = new int[rows][cols];
                    board = Reader.readBoard(file, rows, cols);
                    if(rows == Board.rows && cols == Board.cols);
                    Board.board = board;
                    Painter.Painter(Board.rows, Board.cols, Board.board);
                            } catch (IOException ex) {
                    Logger.getLogger(OptionPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
               showMessageDialog(null, "Nie udało się wczytać pliku."); 
        }
        if(source == save)
        {
           JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
               try {
                   Saver.SaveCurrentGeneration(file, Board.rows, Board.cols, Board.board);
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(OptionPanel.class.getName()).log(Level.SEVERE, null, ex);
               } catch (UnsupportedEncodingException ex) {
                   Logger.getLogger(OptionPanel.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
            else
               showMessageDialog(null, "Nie udało się zapisać do pliku.");  
        }
        if(source == transisionSpeed)
        {
            speed++;
            if(speed == 6)
                speed = 1;
           transisionSpeed.setText(Integer.toString(speed));
        }
        if(source == selectState)
        {
            selectedClicker = (String)selectState.getSelectedItem();
            if("-----".equals(selectStructure.getSelectedItem()));
            else
            {
                selectState.setSelectedIndex(0);
                showMessageDialog(null, "Structure selected. Set it to ''-----'' if you want to select state of cell!");
            }
        }
        if(source == selectStructure)
        {
            selectedClicker = (String)selectStructure.getSelectedItem();
            if("-----".equals(selectState.getSelectedItem()));
            else
            {
                selectStructure.setSelectedIndex(0);
                showMessageDialog(null, "State of cell selected. Set it to ''-----'' if you want to select structure!");
            }
        }
      
        
    }
    
}
