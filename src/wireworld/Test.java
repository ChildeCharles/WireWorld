/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Charles
 */
public class Test {
    public static void main(String[] args) throws IOException{
        /*Reader Test*/
        Reader readTestThing =  new Reader();
        File filename = new File("C:\\Users\\Charles\\Documents\\NetBeansProjects\\WireWorld\\test\\ReaderTestData.txt");
        int rows = readTestThing.readRows(filename);
        System.out.println("rows = " + rows);
        int cols = readTestThing.readCols(filename);
        System.out.println("cols = " + cols);
        int[][] matrix = new int[rows][cols];
        matrix = readTestThing.readBoard(filename, rows, cols);
        int i,j;
        System.out.println("Test matrix");
        for(i= 0; i< rows; i++){
            for(j= 0; j< cols; j++){
                System.out.print(matrix[i][j]+ " ");
            }
        System.out.println();
        }
        /*Saver Test*/
        System.out.println("Current state of matrix saved to file SaverTestData.txt in ...\\NetBeansProjects\\WireWorld\\test");
        File file = new File("C:\\Users\\Charles\\Documents\\NetBeansProjects\\WireWorld\\test\\SaverTestData.txt");
        Saver.SaveCurrentGeneration(file, rows, cols, matrix);
        /*Simulator Test*/
        int[][] newMatrix = new int[rows][cols];
        newMatrix = Simulator.NextGeneration(rows, cols, matrix);
        System.out.println("Test matrix after 1 generation");
        for(i= 0; i< rows; i++){
            for(j= 0; j< cols; j++){
                System.out.print(newMatrix[i][j]+ " ");
            }
        System.out.println();
        }
    }
}