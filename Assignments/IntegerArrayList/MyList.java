import java.io.*;
@SuppressWarnings("unchecked")
public class MyList<E> implements List<E> {
    //no code needed, just a specific version of List that works with Integer values.
    //this will be easier for us to implement, because we won't have to worry about Generics.
    //You will implement the methods from List in IntegerArrayList, however, you can just replace every instance of E with Integer
    // when implmenting them in your IntegerArrayList class.
    
    private E[] list;
    private int current;
    
    
    public MyList()
    {
        list = (E[]) new Object[10]; //can't create generic array
        current = 0;
    }

    public void add(E val){
        if (current >= list.length){
            E[] biggerlist = (E[]) new Object[list.length * 2];
            for (int i = 0; i < current; i++) {
                biggerlist[i] = list[i];
            }
            list = biggerlist;
        }
        
        list[current] = val;
        current++;
    }

    public void add(int index, E val){
        if (index < 0 || index > current){
            
            throw new IndexOutOfBoundsException();
        }

        if (current >= list.length){
            E[] biggerlist = (E[]) new Object[list.length * 2];
            for (int i = 0; i < current; i++){
                biggerlist[i] = list[i];
            }
            list = biggerlist;
        }
        
        for (int i = current; i > index; i--) {
            list[i] = list[i-1];
        }
        list[index] = val;
        current++;
    }

    public void set(int index, E val){
        if (index < 0 || index >= list.length){
            throw new IndexOutOfBoundsException();
        }

        list[index] = val;
    }

    public void clear(){
        current = 0;
    }
    public E remove(int index){
        if (index < 0 || index >= list.length){
            throw new IndexOutOfBoundsException();
        }

        list[index] = null;

        for (int i = index; i < list.length-1; i++) {
            list[i] = list[i+1];
        }

        current--;
        return null;
    }
    public E get(int index){
        if (index < 0 || index >= list.length){
            throw new IndexOutOfBoundsException();
        }
        
        return list[index];
    }
    public int size(){
        return current;
    }
    public boolean isEmpty(){
        return (list.length == 0);
    }
    public boolean contains(E val){
        for (int i = 0; i < current; i++) {
            if (list[i].equals(val)){
                return true;
            }
        }
        return false;
    }
    public int indexOf(E val){
        for (int i = 0; i < current; i++) {
            if (list[i].equals(val)){
                return i;
            }
        }
        return -1;
    }
    public boolean equals(List<E> other){

        if (other.size() != current){
            return false;
        }

        for (int i = 0; i < current; i++){
            if (list[i] != other.get(i)){
                return false;
            }
        }
        return true;
    }

    public String toString(){
        String output = "";
        for (int i = 0; i < current; i++){
            output += list[i] + " ";
        }
        return output;
    }


}