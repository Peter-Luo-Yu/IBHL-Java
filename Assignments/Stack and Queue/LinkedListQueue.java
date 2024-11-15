import java.util.LinkedList;
// LIFO Queue which can store Element type E (where Element is any Object type)
public class LinkedListQueue<E> implements Queue<E>
{
    // private LinkedList<E> - can store Element type E (where Element is any Object type)
    private LinkedList<E> list;

    public LinkedListQueue( ) //constructor
    { 
        list = new LinkedList<E>( ); 
    }

}
