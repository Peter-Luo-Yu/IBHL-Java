
import java.io.*;

public class IntegerDoubleLinkedList implements IntegerList //do not remove implements List.
{
    private Node<Integer> head;
    private int size;

    public IntegerDoubleLinkedList()
    {
        //initialize all the instance variables.
        head = null;
        size = 0;
    }
    @Override
    public void add(Integer value)
    {
        add(size, value);
    }
    @Override
    public void add(int index, Integer value)
    {  //complete this method.  If statements are set up for some cases, but you still need to implement
        Node<Integer> n = new Node<>(value);
        
        if (index == 0) {
            //handle case:  we are adding to position 0 of the list
			//make sure this also handles the case where we are adding to an empty list.  These two cases can be handled by the same code.
            if (head == null){
                head = n;
                size++;
            }
            else{
                n.setNext(head);
                head = n;
                size++; //we are tracking size as an instance variable.  Don't forget to update it where you need to.
            }
              
        }
        else if (0 < index && index <= size)
        {
            Node<Integer> current = head;
            int i = 0;
            while (i < index-1){
                current = current.getNext();
                i++;
            }
            if (index == size){
                current.setNext(n);
            }
            else{
                Node<Integer> temp = current.getNext();
                current.setNext(n);
                n.setNext(temp);
            }
            
            size++;
        }
        else{
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }

    @Override
    public void set(int index, Integer val) {
        if (index > size - 1 || index < 0){
            throw new IndexOutOfBoundsException("index: " + index);
        }
        Node<Integer> current = head;
        int i = 0;
        while (i < index){
            current = current.getNext();
            i++;
        }
        current.setValue(val);
    }
    @Override
    public void clear()
    {   
        size = 0;
        head = null;
    }

    @Override
    public Integer remove(int index) {
        if (index == 0 && head != null){
            head = head.getNext();
            size--;
        }
        else if (0 < index && index < size){
            Node<Integer> current = head;
            Node<Integer> prev = null;
            int i = 0;
            while (i < index){
                prev = current;
                current = current.getNext();
                i++;
            }

            prev = current.getNext();
            size--;
            return current.getValue();
            
        }
        else{
            throw new IndexOutOfBoundsException("index: " + index);
        }
        return null;
    }

    @Override
    public Integer get(int index) {
        if (index >= 0 && index < size){
            Node<Integer> current = head;
            int i = 0;
            while (i < index){
                current = current.getNext();
                i++;
            }
            return current.getValue(); 
        }
        else{
            throw new IndexOutOfBoundsException("index: " + index);
        }
        
       
    }

    @Override
    public int size()
    {
        return size; //replace this
    }
    @Override
    public boolean isEmpty()
    {
        return (head == null); //replace this
    }

    @Override
    public boolean contains(Integer val) {
        Node<Integer> current = head;
        while (current != null){
            if (current.getValue() == val){
                return true;
            }
            current = current.getNext();
        }
        return false; //replace this
    }

    @Override
    public int indexOf(Integer val) {
        Node<Integer> current = head;
        int i = 0;
        while (current != null){
            if (current.getValue() == val){
                return i;
            }
            current = current.getNext();
            i++;
        }
        return -1; //replace this
    }

    @Override
    public String toString()
    {
        Node<Integer> current = head;
        String list = "";
        while(current != null){
            list += current.getValue() + ", ";
            current = current.getNext();
        }
        return list;//replace this
    }

    public boolean equals(IntegerDoubleLinkedList otherList)
    {
        if (otherList.size() != size){
            return false;
        }
        Node<Integer> current = head;
        int i = 0;
        while (current != null){
            if (current.getValue() != otherList.get(i)){
                return false;
            }
            current = current.getNext();
            i++;
        }
        
        return true;
        
    }
    //this method is complete.  It just calls the other equals method.  This method technically implements the method from List
    @Override
    public boolean equals(List<Integer> otherList)
    {
        return this.equals((IntegerDoubleLinkedList)otherList);
    }
}