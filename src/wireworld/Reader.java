/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.exit;

/**
 *
 * @author Charles
 */
public class Reader {
    
    public static int readRows(File file) throws IOException{
        int rows = 0;
        String path = file.getAbsolutePath();
        FileInputStream buffer = new FileInputStream(path);
        int c = 0;
        while((c = buffer.read()) != -1) {
            if(c == ' ' || c == '\n' || c == '0' || c == '1' || c == '2' || c == '3' || c == 13)
            {
                if(c == '\n')
                    rows++;
            }
            else
            {
                System.out.println("Wrong data in files: " + c);
                exit(1);
            }
        }       
        return rows;
    }
    public static int readCols(File file) throws IOException{
        int cols = 0;
        String path = file.getAbsolutePath();
        FileInputStream buffer = new FileInputStream(path);
        int c = 0;
        while((c = buffer.read()) != -1) {
            if(c == ' ' || c == '\n' || c == '0' || c == '1' || c == '2' || c == '3' || c == 13)
            {
                if(c == ' ')
                    cols++;
                else if(c == '\n')
                    break;
            }
            else
            {
                System.out.println("Wrong data in file: " + c);
                exit(1);
            }
        }
        
         buffer = new FileInputStream(path);
          c = 0;
          int colsCheck = 0;
          while((c = buffer.read()) != -1) {
            if(c == ' ' || c == '\n' || c == '0' || c == '1' || c == '2' || c == '3' || c == 13)
            {
                if(c == ' ')
                    colsCheck++;
                else if(c == '\n')
                {
                    if(colsCheck != cols)
                    {
                        System.out.println("Wrong Format!");
                        exit(2);
                    }
                    colsCheck = 0;
                }
            }
            else
            {
                System.out.println("Wrong data in file:" + c);
                exit(1);
            }
        }
        
        
        
        
        return cols;
    }
    public static int[][] readBoard(File file, int rows, int cols) throws IOException{
        
    
        int[][]board = new int[rows][cols];
        int i = 0;
        int j = 0;
        String path = file.getAbsolutePath();
        FileInputStream buffer = new FileInputStream(path);
        int c = 0;
        while((c = buffer.read()) != -1) {
            if(c == ' ' || c == '\n' || c == '0' || c == '1' || c == '2' || c == '3' || c == 13)
            {
                if(c == '0')
                    board[i][j] = 0;
                if(c == '1')
                    board[i][j] = 1;
                if(c == '2')
                    board[i][j] = 2;
                if(c == '3')
                    board[i][j] = 3;
                if(c == ' ')
                    j++;
                if(c == '\n')
                {
                    i++;
                    j = 0;
                }
               
            }
            else
            {
                System.out.println("Wrong data in file:" + c);
                exit(1);
            }
        }    
        return board;
    }
    
}
