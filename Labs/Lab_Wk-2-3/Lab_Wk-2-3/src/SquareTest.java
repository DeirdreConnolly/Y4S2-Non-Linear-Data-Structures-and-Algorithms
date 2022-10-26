// ****************************************************************
// SquareTest.java
//
// Uses the Square class to read in square data and tell if
// each square is magic.
//
// ****************************************************************

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SquareTest {
    public static void main(String[] args) throws IOException {
        boolean type = true; // Change this to false for the dynamic implementation
        Scanner scan = new Scanner(new File("src/magicData"));      // Where it gets the data
        int count = 1; //count which square we're on
        int size = scan.nextInt(); //size of next square
        Square square;
        //Expecting -1 at bottom of input file
        while (size != -1) {
            //create a new Square of the given size
            if (type == true)
                square = new My2DArraySquare(size);
            else
//                square = new MyArrayLinkedListsSquare(size);
//            //call its read method to read the values of the square
//            square.readSquare(scan);

            System.out.println("\n******** Square " + count + " ********");
			 
             /* TO-DO:
			 //print the square
			 //print the sums of its rows
			 //print the sums of its columns
			 //print the sum of the main diagonal
			 //print the sum of the other diagonal
			 //determine and print whether it is a magic square
			 */

            //get size of next square
            size = scan.nextInt();
            count++;
        }
    }
} 