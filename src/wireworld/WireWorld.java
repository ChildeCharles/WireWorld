/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author Charles
 */
public class WireWorld {
    
            public static void main(String[] args) throws IOException{
            EventQueue.invokeLater(new Runnable() {
           

            @Override
            public void run() {
            WireworldFrame frame = new WireworldFrame();
            }
        });
    }
}
        
    
