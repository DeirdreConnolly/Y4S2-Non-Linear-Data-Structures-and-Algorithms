/******************************************************************************
 *  Computes and prints the first n Fibonacci numbers.
 *  This program uses only recursion. It does not use dynamic programming.
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


public class RecursionFibonacci {

	
	//-------------------------------------------------------------------
		// 3. fibonacci --> Computes an element of the fibonacci series 
		//-------------------------------------------------------------------	
		/**
		 * Computes an element of the fibonacci series.
		 * @param n: The index of the element of the serie we want to compute.	  
		 * @return: The fibonacci element for that index.
		 */	
		public static long fibonacci(int n){
			//-----------------------------
			//Output Variable --> InitialValue
			//-----------------------------
			long res = 0;

			//-----------------------------
			//SET OF OPS
			//-----------------------------

			//-----------------------------
			// I. SCENARIO IDENTIFICATION
			//-----------------------------
			int scenario = 0; 
			
			//Rule 1. We look for the index 0 
			if (n == 0) 
				scenario = 1;
			else{
				//Rule 2. We look for the index 1
				if (n == 1)
					scenario = 2; 
				//Rule 3. We look for an index bigger than 1
				else
					scenario = 3;	
			}

			//-----------------------------
			// II. SCENARIO IMPLEMENTATION 
			//-----------------------------
			switch(scenario){	
					
			//Rule 1. We look for the index 0 
			case 1: 
				//1. We assign res to 0
				res = 0;
				
				break;

			//Rule 2. We look for the index 1 
			case 2: 
				//1. We assign res to 1
				res = 1;
					
				break;	
				
			//Rule 3. We look for an index bigger than 1
			case 3: 
				//1. We recursively solve the the smaller problem of computing n-1
				long n1 = fibonacci(n-1);
				
				//2. We recursively solve the the smaller problem of computing n-2
				long n2 = fibonacci(n-2);
				
				//3. We compute the final result 
				res = n1 + n2; 
				
				break;
			}		
				
			//-----------------------------
			//Output Variable --> Return FinalValue
			//-----------------------------		
			return res;	
		}
		public static void main(String[] args) {
		    int n = 20000;
	        
	        for(int i=0; i<n;i+=1)
	            System.out.println("fibonacci("+i+")" + "= " + fibonacci(i));
		
	    }	
	
}
