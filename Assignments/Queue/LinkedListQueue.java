
import java.util.LinkedList;
// LIFO Queue which can store Element type E (where Element is any Object type)
@SuppressWarnings("unchecked")
public class LinkedListQueue<E> implements Queue<E>
{
    // private LinkedList<E> - can store Element type E (where Element is any Object type)
    private LinkedList<E> list;

    public LinkedListQueue( ) //constructor
    { 
        list = new LinkedList<E>(); 
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E obj) {
        list.add(obj);
    }

    @Override
    public E dequeue() {
        if (list.size() < 1){
            throw new IllegalStateException("Cannot dequeue from empty list.");
        }
        E val = list.getFirst();
        list.removeFirst();
        return val;
    }

    @Override
    public E peekFront() {
        if (list.size() < 1){
            throw new IllegalStateException("Cannot dequeue from empty list.");
        }
        return list.getFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < list.size()-1; i++){
            result += list.get(i) + " ";
        }
        if (list.size() > 0){
            result += list.get(list.size()-1);
        }
        return result;
    }


}
