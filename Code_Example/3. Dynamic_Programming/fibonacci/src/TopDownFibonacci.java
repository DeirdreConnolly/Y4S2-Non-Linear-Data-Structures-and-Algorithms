/******************************************************************************
 *  Computes and prints the first n Fibonacci numbers.
 *  This program uses top-down dynamic programming.
 *   
 *   Examples of Fibonacci numbers:
 *   1: 1
 *   2: 1
 *   3: 2
 *   4: 3
 *   5: 5
 *   6: 8
 *   7: 13
 *
 *
 ******************************************************************************/

public class TopDownFibonacci {
    private static long [] fib;

    public static long fibonacci(int n) {
        
        if (n == 0) 
            return 0;
        if (n == 1) 
            return 1;

        // return cached value (if previously computed)
        if (fib[n] > 0) 
            return fib[n];

        // compute and cache value
        fib[n] = fibonacci(n-1) + fibonacci(n-2);
        return fib[n];
    }


    public static void main(String[] args) {
        int n = 10000;
        
        for(int i=0; i<n;i+=10)
        {
        	fib=new long[i+1];
        	System.out.println("fibonacci("+i+")" + "= " + fibonacci(i));
        }
    }
}