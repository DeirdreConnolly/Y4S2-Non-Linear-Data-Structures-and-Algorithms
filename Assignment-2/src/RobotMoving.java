/*
 * Name:    Deirdre Connolly
 * ID:      R00112962
 */


public class RobotMoving {

    /*
     * Start -> [ ] [ ] [ ] [ ] [ ] [ ]
     *          [ ] [ ] [ ] [ ] [ ] [ ]
     *          [ ] [ ] [ ] [ ] [ ] [ ]
     *          [ ] [ ] [ ] [ ] [ ] [ ]
     *          [ ] [ ] [ ] [ ] [ ] [ ]
     *          [ ] [ ] [ ] [ ] [ ] [ ] <- End
     *
     * Movement                 Cost1       Cost2
     * → Right                    1.1         1.5
     * ↓ Down                     1.3         1.2
     * ↘ Diagonal (Right-Down)    2.5         2.3
     */

    public static void shortestPath(int choice) {

        /*
         * Least possible movements:
         * Cost1:   Right + Down
         * Cost2:   Diagonal
         */

        int n = 8;                                                      // Parameter to determine size of square, rows and columns will be the same

        double[][] magicSquare = new double[n][n];                      // Use 2D array to create perfect square
        double[] cost1 = {1.1, 1.3, 2.5};                               // Right, down, diagonal
        double[] cost2 = {1.5, 1.2, 2.3};                               // Right, down, diagonal
        double[] cost;                                                  // Store total cost of move

        if (choice == 1) {
            cost = cost1;

        } else {
            cost = cost2;
        }

        // [row][col]
        // [i]  [j]
        magicSquare[0][0] = 0;                                          // Start position at uppermost left corner of square

        for (int j = 1; j < n; j++) {                                   // j = position across each column
            magicSquare[0][j] = cost1[0] + magicSquare[0][j - 1];       // Move position across row, store cost of move plus cost of previous move, e.g. 1.1 + 1.1 = 2.2
        }

        for (int i = 1; i < n; i++) {
            magicSquare[i][0] = cost1[1] + magicSquare[i - 1][0];       // i = position down each row
            for (int j = 1; j < n; j++) {
                // Find the minimum cost of reaching [i,j]
                magicSquare[i][j] = Math.min(magicSquare[i][j - 1] + cost1[0], Math.min(magicSquare[i - 1][j] + cost[1], magicSquare[i - 1][j - 1] + cost[2]));     // Right, down, diagonal
            }
        }

        System.out.println("\nCost: " + magicSquare[n - 1][n - 1]);
        System.out.println("Steps taken: ");

        if ((cost[0] + cost[1]) < cost[2]) {                            // If cost of right + down is less than  diagonal
            for (int i = 0; i < n - 1; i++) {                           // Because we are using a perfect square, the movements needed to reach end position will be n - 1
                System.out.println("Right, Down");                      // Move right + down
            }
        } else {                                                        // If cost of diagonal is less than right + down
            for (int i = 0; i < n - 1; i++) {                           // Because we are using a perfect square, the movements needed to reach end position will be n - 1
                System.out.println("Diagonal");                         // Move diagonally
            }
        }
    }

    public static void main(String[] args) {

        shortestPath(1);                                        // Choose cost1 option
        shortestPath(2);                                        // Choose cost2 option
    }
}
