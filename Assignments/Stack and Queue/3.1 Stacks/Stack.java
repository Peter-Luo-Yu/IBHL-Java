public interface Stack<E>
{
    //Note:  "top" of the stack should simply be the easiest to access location within the
    //underlying data structure.
    public boolean isEmpty(); // return true if Stack is empty
    public void push(E obj); //place d on top of the stack
    public E pop( ); //returns top item in the stack and then remove from stack
    public E peek( ); //sometimes called top()  - return the top item in the stack and leave the stack intact
    public int size( ); //returns the size (depth) of the stack
    public void clear(); //clears all elements from the Stack.  Results in an empty stack.

}
