import java.util.LinkedList;

//FIFO Stack, which can store Elements of type E (Where E is any Object type)
//NOTE - technically java's implementation of LinkedList is a DoublyLinked List.
//However, for the purpose of this assignment, lets assume it is a singly linked list
// (because we will implement stack using a singly-linked Node structure later on in the Unit)

public class LinkedListStack<E> implements Stack<E>
{
    private LinkedList<E> list;
    
    public LinkedListStack()
    {
        list = new LinkedList<E>();
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public void push(E obj){
        list.addFirst(obj);
    }
    public E pop(){
        E val = list.getFirst();
        list.removeFirst();
        return val;
    } 
    public E peek(){
        return list.getFirst();
    }
    public int size(){
        return list.size();
    }
    public void clear(){
        list.clear();
    }
}

