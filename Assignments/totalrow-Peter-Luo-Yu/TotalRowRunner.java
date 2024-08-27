//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class TotalRowRunner
{
	public static void main( String args[] ) throws Exception
	{
		int[][] test1 = {{1,2,3},{5,5,5,5}};
		int[][] test2 = {{1,2,3},{5},{1},{2,2}};
		int[][] test3 = {{1,2},{5,5},{5,5},{4,5,6,7},{123124,12312}};

		int[] result = TotalRow.getRowTotals(test3);

		System.out.print("Row totals are :: [");
		for (int i = 0; i < result.length; i++)
		{
			if (i == result.length - 1){
				System.out.print(result[i]);
			} else {
				System.out.print(result[i] + ",");
			}
		}
		System.out.println("]");
	}
}



