public class Node<E extends Comparable>
{
    //instance data  (you can remove the visibility modifier private, if you want to access this directly from IntegerLinkedList class.
    private E val;
    private Node<E> next;

    //Constructor
    public Node (E value)
    {
        val = value;
        next =  null;
    }

    public Node (E value, Node<E> next)
    {
        val = value;
        this.next = next;
    }

    //Two Accessor methods
    public Node<E> getNext()
    {
        return next;
    }

    public E getValue()
    {
        return val;
    }

    //Two Mutator methods
    public void setNext(Node<E> n)
    {
        this.next = n;
    }

    public void setValue(E value)
    {
        this.val = value;
    }
}
