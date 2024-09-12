
/**
 * Tests an implementation of the Collections Interface by calling static methods from the CollectionUtils class
 *
 * @author Gesell
 * @version 09/05/2022
 */
public class Test
{
    public static void main(String[] args)
    {
        int[] testValues = {10, -4, 18, 36, 54, 12};
        Collection<Integer> c = new ArrayCollection<Integer>();
        for (int i: testValues)
            c.addItem(i);
        
        //Note: The CollectionUtils class only knows about the Collection interface.
        //It has no knowledge of any particular class that implements the Collection Interface
        System.out.println("The minimum value is: " + CollectionUtils.minimum(c));
        System.out.println("The maximum value is: " + CollectionUtils.maximum(c));
        
    }
}
