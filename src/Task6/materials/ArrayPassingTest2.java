import java.util.*;
public class ArrayPassingTest2 {    
    public static void main (String[] args) {
		ArrayPassingTest tester;
        tester = new ArrayPassingTest( );
        tester.test( );
		
    }
    public void  test( ){
		
		int size = 10;
		double[] arrayOne;
		

        //return a double array to arrayOne
        arrayOne = readDoubles(size);

        
        //get the index of the smallest element of arrayOne
        int minOne = searchMinimum(arrayOne);
		
		//output the result
        System.out.print("Mimimum value in Array One is ");
        System.out.print(arrayOne[minOne] + " at position " + minOne);
        
    }
	
	   /**
     * Inputs the double values and returns an array of double
     *
     * @return an array of double values entered
     */
    public double[] readDoubles(int N) {
		Scanner scanner = new Scanner(System.in);
        double[] number;      
        number = new double[N];

        for (int i = 0; i < N; i++) {            
            System.out.print("Number " + (i+1) + ": ");
            number[i] = scanner.nextDouble();
        }

        return number;
    }


	
	
    /**
     * Returns the index to the smallest element in the
     * passed array.
     *
     * @param number an array of double to search for the
     *               smallest element
     *
     * @return the index to the smallest element
     */
	public int searchMinimum(double[] number) {
		int indexOfMinimum = 0;
		for (int i = 1; i < number.length; i++) {
			if (number[i] < number[indexOfMinimum]) { //found a
				indexOfMinimum = i; //smaller element
			}
		}
		return indexOfMinimum;
   }
}