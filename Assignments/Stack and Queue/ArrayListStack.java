import java.util.ArrayList;

//FIFO Stack, which can store Elements of type E (Where E is any Object type) 
public class ArrayListStack<E> implements Stack<E>
{
    private ArrayList<E> list;

    public ArrayListStack(){
        list = new ArrayList<E>();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public void push(E Obj){
        list.add(Obj);
    }

    @Override
    public E pop(){
        E val = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return val;
    }

    @Override
    public E peek(){
        return list.get(list.size() - 1);
    } 

    public int size(){
        return list.size();
    }

    @Override
    public void clear(){
        list.clear();
    }

}