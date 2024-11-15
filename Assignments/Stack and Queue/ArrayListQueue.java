import java.util.ArrayList;
// LIFO Queue which can store Element type E (where Element is any Object type)
public class ArrayListQueue<E> implements Queue
{
    // private ArrayList<E> - can store Element type E (where Element is any Object type)
    private ArrayList<E> list;
    
    public LinkedListQueue( ) //constructor
    { 
        list = new ArrayList<E>( ); 
    }
}
