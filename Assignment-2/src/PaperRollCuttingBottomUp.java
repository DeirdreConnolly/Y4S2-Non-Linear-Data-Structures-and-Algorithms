/*
 * Name:    Deirdre Connolly
 * ID:      R00112962
 */

import java.util.Arrays;

public class PaperRollCuttingBottomUp {

    public static double max(double x, double y) {
        if (x > y)
            return x;
        return y;
    }

    public static double paperRollCut(int n) {
        double prices[] = new double[5 + n];                            // Store prices

        prices[1] = 1.2;
        prices[2] = 3;
        prices[3] = 5.8;
        prices[4] = 0;                                                  // Cut of 4 not included in question, price = 0
        prices[5] = 10.1;

        double[] optimalPrices = new double[n + 1];                     // Store best prices
        optimalPrices[0] = 0;
        int cuts[] = new int[n + 1];
        int i, j;

        for (j = 1; j <= n; j++) {
            double maximumRevenue = -1000;                              // Big negative number, used in max function to compare highest price
            double bestPrice = -1000;

            for (i = 1; i <= j; i++) {                                  // i iterates through each possible cut, j will always be length
                maximumRevenue = max(maximumRevenue, prices[i] + optimalPrices[j - i]);
                /*
                 * Let's say n = 4                         prices[i]            oP[j - i]
                 *
                 * j = 1    i = 1       maxRev = -1000     prices[1] = 1.2      oP[1 - 1] = oP[0] = 0       -->     (-1000, 1.2  +  0)        -->     (-1000  <    1.2)       -->     >>1.2<<
                 *
                 * j = 2    i = 1       maxRev = -1000     prices[1] = 1.2      oP[2 - 1] = oP[1] = 1.2     -->     (-1000, 1.2  +  1.2)      -->     (-1000  <   2.4)        -->     2.4
                 * j = 2    i = 2       maxRev = 2.4       prices[2] = 3        oP[2 - 2] = oP[0] = 0       -->     (2.4,   3    +  0)        -->     (2.4    <   3)          -->     >>3<<
                 *
                 * j = 3    i = 1       maxRev = -1000     prices[1] = 1.2      oP[3 - 1] = oP[2] = 3       -->     (-1000, 1.2  +  3)        -->     (-1000  <   4.2)        -->     4.2
                 * j = 3    i = 2       maxRev = 4.2       prices[2] = 3        oP[3 - 2] = oP[1] = 1.2     -->     (4.2,   3    +  1.2)      -->     (4.2    <   4.2)        -->     4.2
                 * j = 3    i = 3       maxRev = 4.2       prices[3] = 5.8      oP[3 - 3] = oP[0] = 0       -->     (4.2,   5.8  +  0)        -->     (4.2    <   5.8)        -->     >>5.8<<
                 *
                 * j = 4    i = 1       maxRev = -1000     prices[1] = 1.2      oP[4 - 1] = oP[3] = 5.8     -->     (-1000, 1.2  +  5.8)      -->     (-1000  <   7)          -->     7
                 * j = 4    i = 2       maxRev = 7         prices[2] = 3        oP[4 - 2] = oP[2] = 3       -->     (7,     3    +  3)        -->     (7      >   6)          -->     7
                 * j = 4    i = 3       maxRev = 7         prices[3] = 5.8      oP[4 - 3] = oP[1] = 1.2     -->     (7,     5.8  +  1.2)      -->     (7      =   7)          -->     7
                 * j = 4    i = 4       maxRev = 7         prices[4] = 0        oP[4 - 4] = oP[0] = 0       -->     (7,     0    +  0)        -->     (7      >   0)          -->     >>7<<
                 *
                 * j = 5    i = 1       maxRev = -1000     prices[1] = 1.2      oP[5 - 1] = oP[4] = 7       -->     (-1000, 1.2  +  7)        -->     (-1000  <   8.2)        -->     8.2
                 * j = 5    i = 2       maxRev = 8.2       prices[2] = 3        oP[5 - 2] = oP[3] = 5.8     -->     (8.2,   3    +  5.8)      -->     (8.2    <   8.8)        -->     8.8
                 * j = 5    i = 3       maxRev = 8.8       prices[3] = 5.8      oP[5 - 3] = oP[2] = 3       -->     (8.8,   5.8  +  3)        -->     (8.8    =   8.8)        -->     8.8
                 * j = 5    i = 4       maxRev = 8.8       prices[4] = 0        oP[5 - 4] = oP[1] = 1.2     -->     (8.8,   0    +  1.2)      -->     (8.8    >   1.2)        -->     8.8
                 * j = 5    i = 5       maxRev = 8.8       prices[5] = 10.1     oP[5 - 5] = oP[0] = 0       -->     (8.8,   10.1 +  0)        -->     (8.8    <   10.1)       -->     >>10.1<<
                 */

                // To find highest price, check each price/cut combo against each other
                // Check this result against maximumRevenue
                if (maximumRevenue > bestPrice) {
                    bestPrice = maximumRevenue;
                    cuts[j] = i;                                        // We store the best piece-length (i) for a rod of length=length
                }

            }
            optimalPrices[j] = maximumRevenue;
            /*
             * optimalPrices[1] = 1.2
             * optimalPrices[2] = 3
             * optimalPrices[3] = 5.8
             * optimalPrices[4] = 7
             * optimalPrices[5] = 10.1
             */
        }

        int cutsTaken = n;                                              // Store number of cuts taken
        System.out.println("Length: n = " + n);

        while (cutsTaken != 0) {                                        // While a cut has been made

            System.out.println("Cuts taken: " + cuts[cutsTaken]);
            cutsTaken -= cuts[cutsTaken];
        }

        return optimalPrices[n];
    }


    public static void main(String[] args) {

        /*
         * Length:  0       1       2      3       4        5           // Include 0 cuts = 0 revenue
         * Price:   0       1.2     3      5.8     0        10.1        // Cut of 4 not included in question, price = 0
         */

        int n = 0;                                                      // Paper roll length

        System.out.println("Best Price: €" + paperRollCut(n));          // Output the best price available with the number of relevant cuts

    }
}





