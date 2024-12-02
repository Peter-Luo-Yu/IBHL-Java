import java.io.IOException;

@SuppressWarnings("unchecked")
public class ArrayListQueue<E> implements Queue<E> {
    private E[] array;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public ArrayListQueue(int initialCapacity) {
        size = 0;
        front = 0;
        rear = -1;
        array = (E[])new Object[initialCapacity];
        capacity = initialCapacity;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E obj) {
        if (size >= capacity){
            E[] temp = (E[]) new Object[capacity * 2];
            for (int i = 0; i < size; i++){
                temp[i] = array[front];
                front = (front + 1) % capacity;
            }
            array = temp;
            capacity *= 2;
            front = 0;
            rear = size - 1;
        }
        rear = (rear + 1) % capacity;
        array[rear] = obj;
        size++;
    }

    @Override
    public E dequeue() {
        if (size < 1){
            throw new IllegalStateException("Cannot dequeue from empty list.");
        }
        E val = array[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }

    @Override
    public E peekFront() {
        if (size < 1){
            throw new IllegalStateException("Queue is empty?");
        }
        return array[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public String toString(){
        String result = "Front ";
        for (int i = 0; i < array.length; i++){
            result += array[i];
            result += " ";
        }
        result += "End";

        return result;
    }

}