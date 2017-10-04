/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Charles
 */
public class Saver {
    public static void SaveCurrentGeneration(File file, int rows, int cols, int[][] board) throws FileNotFoundException, UnsupportedEncodingException{
        String path = file.getAbsolutePath();
        PrintWriter writer = new PrintWriter(path, "UTF-8");
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                writer.print(board[i][j] + " ");
            }
         writer.println("");
        }
        writer.close();
    }
    
}
