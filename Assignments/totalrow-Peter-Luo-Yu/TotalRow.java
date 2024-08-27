//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;

public class TotalRow
{
    public static int[] getRowTotals(int[][] m)
    {
    	int[] sums = new int[m.length];

      for (int i = 0; i < m.length; i++)
      {
        int sum = 0;
        for (int j = 0; j < m[i].length; j++)
        {
          sum += m[i][j];
        }
        sums[i] = sum;
      }

      return sums;
    }

}
