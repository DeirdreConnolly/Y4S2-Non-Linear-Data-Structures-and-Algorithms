// ****************************************************************
//
// Implements the Square interface with methods to create and read in
// info for a square matrix with the data structure array of linked lists
// and to compute the sum of a row, a col, either diagonal, and whether it is magic.
//
// ****************************************************************

import java.util.LinkedList;
import java.util.Scanner;

public class MyArrayLinkedListsSquare implements Square{
   
    //-------------
    // Attributes 
    //-------------
    // TO-DO

    //--------------------------------------
    //create new square of given size
    //--------------------------------------
     // TO-DO

    //--------------------------------------
    //return the sum of the values in the given row
    //--------------------------------------
    // TO-DO

    //--------------------------------------
    //return the sum of the values in the given column
    //--------------------------------------
    // TO-DO
    
    //--------------------------------------
    //return the sum of the values in the main diagonal
    //--------------------------------------
    // TO-DO

    //--------------------------------------
    //return the sum of the values in the other ("reverse") diagonal
    //--------------------------------------
    // TO-DO

    //--------------------------------------
    //return true if the square is magic (all rows, cols, and diags have
    //same sum), false otherwise
    //--------------------------------------
      // TO-DO

    //--------------------------------------
    //read info into the square from the standard input.
    //--------------------------------------
    public void readSquare(Scanner scan) {
        for (int row = 0; row < square.length; row++)
            for (int col = 0; col < square.length; col++)
                square[row].add(new Integer(scan.nextInt()));
    }


    //--------------------------------------
    //print the contents of the square, neatly formatted
    //--------------------------------------
   // TO-DO
} 