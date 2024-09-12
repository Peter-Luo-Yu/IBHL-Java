import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class ArrayCollection here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayCollection<E> implements Collection<E>
{
    private List<E> internalList;
    private int currentElement;
    
    public ArrayCollection()
    {
        internalList = new ArrayList<>();
        currentElement = 0;
    }

    public void addItem(E item) {
        internalList.add(item);
    }

    public E getNext() {
        int temp = currentElement++;
        return internalList.get(temp);
    }
    
    public void resetNext() {
        currentElement = 0;
    }

    public boolean hasNext() {
        if (currentElement + 1 < internalList.size()){
            currentElement++;
            return true;   
        }
        return false;
    }

    public boolean isEmpty() {
        return (internalList.size() == 0);
    }

}
