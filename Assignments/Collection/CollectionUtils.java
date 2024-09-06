/**
 * This class will contain a set of utilities that can be used with collection objects
 * For example, a method that returns the minimum value from a Collection
 * 
 * NOTE: this utility class works on all Collection objects.
 * Collection is an interface - so it works on all classes that implement Collection
 * 
 * This utility class has no knowledge of any particular class that implements the Collection Interface.
 * 
 * @author Gesell
 * @version 09/05/2022
 */

public class CollectionUtils
{
    //If the Collection contains Comparable Elements, then this metbhod will return the minimum element in the collection
    public static <E extends Comparable> E minimum(Collection<E> collection)
    {
        E min = collection.getNext();
        while (collection.hasNext())
        {
            E val = collection.getNext();
            
            if (val.compareTo(min) < 0)
                min = val;
        }
        return min;
    }
    
    public static <E extends Comparable> E maximum(Collection<E> collection)
    {
        E min = collection.getNext();
        while (collection.hasNext())
        {
            E val = collection.getNext();
            
            if (val.compareTo(min) > 0)
                min = val;
        }
        return min;
    }
}
