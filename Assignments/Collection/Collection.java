/**
 * Collections store a set of elements. The elements may be of any type (numbers, objects, arrays,
 * Strings, etc.).
 * A collection provides a mechanism to iterate through all of the elements that it contains. The
 * following code is guaranteed to retrieve each item in the collection exactly once.
 * 
 * @author Gesell - taken from IB standard Collection pseudocode
 * @version 09/05/2022
 */
public interface Collection<E>
{
    /* Add item to the Collection
     * Adds an element that contains the argument,whether it is a value, String, object, etc.*/
    public void addItem(E item);

    /* Get the next item
     * getNext() will return the first item in the collection when it is first called.
     * Note: getNext() does not remove the item from the collection.
     */
    public E getNext();

    /* Go back to the start of the collection
     * Restarts the iteration through the collection.
     * The two lines shown will retrieve the first item in the collection:
     * myCollection.resetNext()
     * myCollection.getNext()
     */
    public void resetNext();

    /* Test: has next item
     * Returns TRUE if there are one or more elements in the collection that have not been accessed by the
     * present iteration: The next use of getNext() will return a valid element.
     */
    public boolean hasNext();

    /* Test: collection is empty
     * Returns TRUE if the collection does not contain any elements.
     */
    public boolean isEmpty();   
}
