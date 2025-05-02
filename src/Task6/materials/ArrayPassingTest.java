import java.util.*;
public class ArrayPassingTest {    
    public static void main (String[] args) {
		ArrayPassingTest tester;
        tester = new ArrayPassingTest( );
        tester.test( );
		
    }
    public void  test( ){
		Scanner scanner = new Scanner(System.in);
		
		double[] arrayOne;

        double number;

        int size = 10;

        //create and assign values to arrayOne
        arrayOne = new double[size];

        for ( int i = 0; i < size; i++ ) {
            System.out.print("Number " + (i+1) + ": ");
            number = scanner.nextDouble();
            arrayOne[i] = number;
        }
        //get the index of the smallest element of arrayOne
        int minOne = searchMinimum(arrayOne);
		
		//output the result
        System.out.print("Mimimum value in Array One is ");
        System.out.print(arrayOne[minOne] + " at position " + minOne);
        
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