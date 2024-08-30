import static java.lang.System.*;
/*
 * Class to represent a spiral matrix.
 * Matrix should be stored internally as a 2D array.
 * 2 constructors provided - one where the size of the matrix size is 
 * specified, and one where it is set to a 1x1
 * method provided to fill in the numbers of the spiral matrix
 * method provided to print an ascii text String nicely representing the 
 * sprial matrix which can easily be printed to standard output.
 *
*/
public class SpiralMatrix
{
    //declare a matrix private instance variable
	private int size;
	private int[][] matrix;


	private int side = 0;
	private	int n = 0;
		
	private int index = 0;	
	/* constructor which simply instantiates a matrix of size 1x1
	* values will be auto-initialized to zeros.
	*/
	public SpiralMatrix()
	{
		size = 1;
		matrix = new int[1][1];
	}
	/* overloaded version of the constructor, which
	* allows specification of the matrix size
	* (matrix will always be square)  Should just
	* instantiate the matrix - values will auto-initialized
	* to zeros.
	*/
    public SpiralMatrix(int s)
    {
		size = s;
		matrix = new int[s][s];
    }
    
	/* mutator method to modify the size of the Spiral
	* matrix.
	*/
    public void setSize(int s)
    {
		size = s;
		matrix = new int[s][s];
    }

	/* Method to fill in all of the values of the
	* spiral matrix
	*/
    public void createSpiral()
    {
		side = 0;
		n = 1;
		index = 0;// let index be the current iteration

		while (index < size){

			if (side % 4 == 0) // down i increasing
			{
				for (int i = index; i < size - index; i++) {
					matrix[i][index] = n;
					n++;
				}
				side++;
			}
			if (side % 4 == 1) // right j increasing
			{
				for (int j = index+1; j < size - index - 1; j++) {
					matrix[size-index-1][j] = n;
					n++;
				}
				side++;
			}
			if (side % 4 == 2) //up i decreasing
			{
				for (int i = size-index-1; i > index; i--) {
					matrix[i][size-1-index] = n;
					n++;
				}
				side++;
			}
			if (side % 4 == 3) //left
			{
				for (int j = size-index-1; j > index; j--) {
					matrix[index][j] = n;
					n++;
				}
				side++;
			}
			index++;
			
		}
    }

    /* method to return a nice String of output
	* of the SprialMatrix which may be printed to
	* a terminal.  Should have correct spacing to handle at least up to
	* 3 digit numbers.
	*/
	public String toString( )
    {
        String output="";

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				output += matrix[i][j];
				if (matrix[i][j] < 10){
					output += " ";
				}
				if (matrix[i][j] < 100){
					output += " ";
				}
				output += " "; 
			}
			output += ("\n");
		}

        return output;
    }
}