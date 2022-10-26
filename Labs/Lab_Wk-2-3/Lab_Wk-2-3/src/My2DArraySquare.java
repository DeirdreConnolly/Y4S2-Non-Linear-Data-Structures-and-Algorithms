// ****************************************************************
//
// Implements the Square interface with methods to create and read in
// info for a square matrix with the data structure 2D array
// and to compute the sum of a row, a col, either diagonal, and whether it is magic.
//
// ****************************************************************


import java.util.Scanner;

public class My2DArraySquare implements Square {

    //-------------
    // Attributes 
    //-------------

    int[][] square;


    //-------------
    // Constructor
    //-------------

    public My2DArraySquare(int size) {
        // L: object    R: parameter
        this.square = new int[size][size];      // [rows][columns]
    }


    //TO-DO

    //--------------------------------------
    //create new square of given size
    //--------------------------------------
    //TO-DO

    int[][] table = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
    };

    //--------------------------------------
    //return the sum of the values in the given row
    //--------------------------------------
    //TO-DO




    //--------------------------------------
    //return the sum of the values in the given column
    //--------------------------------------
    //TO-DO


    //--------------------------------------
    //return the sum of the values in the main diagonal
    //--------------------------------------
    //TO-DO

    //--------------------------------------
    //return the sum of the values in the other ("reverse") diagonal
    //--------------------------------------
    //TO-DO

    //--------------------------------------
    //return true if the square is magic (all rows, cols, and diags have
    //same sum), false otherwise
    //--------------------------------------
    //TO-DO

    //--------------------------------------
    //read info into the square from the standard input.
    //--------------------------------------
    public void readSquare(Scanner scan) {
        for (int row = 0; row < square.length; row++)
            for (int col = 0; col < square.length; col++)
                square[row][col] = scan.nextInt();
    }

    //--------------------------------------
    //print the contents of the square, neatly formatted
    //--------------------------------------
    //TO-DO
} 