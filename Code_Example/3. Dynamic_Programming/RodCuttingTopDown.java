import java.util.Arrays;

public class RodCuttingTopDown {

    private static int rodLength = 4;  // Try changing this parameter, what happens with very long rods?  Max rodLength=10.
    private static int prices[] = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
    private static int cuts[] = new int[rodLength + 1];
    private static int optimalPrices[] = new int[rodLength + 1];


    private static int rodCut(int length) {

        if (optimalPrices[length] >= 0) { // checking the optimal sol. for a rod of length=length
            System.out.print("Optimal Prices[" + length + "] -> " + optimalPrices[length] + "\t");
            return optimalPrices[length]; // Note that we avoid computing this rodCut because
        }                                 // the result was previously stored in the array

        int bestPrice = -1000;

        System.out.println("Computation for rod of length = " + length);
        for (int i = 1; i <= length; i++) {  // i iterates over all the possible lengths
            int firstCutPrice = prices[i];
            int leftOverRodPrice = rodCut(length - i);
            System.out.print("\tPrices[" + i + "] -> " + prices[i] + "  ");
            int totalPrice = firstCutPrice + leftOverRodPrice;
            System.out.println("\tTotal = " + totalPrice + "\n");
            if (totalPrice > bestPrice) {
                bestPrice = totalPrice;
                cuts[length] = i;  // We store the best piece-length (i) for a rod of length=length
            }
        }

        optimalPrices[length] = bestPrice; // storing the optimal sol. for a rod of length=length
        printArrays();
        System.out.print("Optimal Prices[" + length + "] -> " + optimalPrices[length] + "\t");

        return bestPrice;
    }


//    /**
//     * @param args
//     */


    public static void printArrays() {
        System.out.println("Optimal Prices: \t" + Arrays.toString(optimalPrices));
        System.out.println("Cuts: \t\t\t\t" + Arrays.toString(cuts) + "\n");
    }


    public static void main(String[] args) {

        printArrays();
        optimalPrices[0] = 0; // revenue of piece of length 0 is 0
        cuts[0] = 0;
        for (int i = 1; i <= rodLength; i++) {
            optimalPrices[i] = -1;
            cuts[i] = -1;
        }
        printArrays();

        System.out.println("\n\nBEST PRICE: \n€" + rodCut(rodLength) + " for a rod of length " + rodLength);

        int length = rodLength;
        System.out.println("\nPIECES CUT: ");
        while (length > 0) {
            int item = cuts[length];
            System.out.println("A piece of length " + item + " with price €" + prices[item]);
            length -= item;
        }
    }
}
