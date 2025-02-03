[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/DNP_-lqI)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=16075384)
# IntegerLinkedList

Please use the starter code, and build on it, as this will allow me to test your code easily.

(If you are doing something above and beyond the requirements, like building a generic LinkedList (LinkedList) inistead of an IntegerLinkedList, then you may need to make some changes - just indicate this in Schoology when you submit.)

In this lab, we will create our own IntegerLinkedList class from scratch. We will implement it as a Singly Linked List.

I have provided a class called Node which includes an int value, and a reference to the next Node.  Please make sure you understand the code in this class as well.

Our IntegerLinkedList should have a reference to a head Node as instance data.  If its reference to the head Node is null, we will consider this to be an empty list.  It should also keep track of its own size.

We should provide

a Constuctor (no parameters)
as well as the following methods:

* .add(int x) (adds to the end of the list.)
* .add(int index, int x) (which inserts at position index, and shifts everything else to the right as necessary.  Should only allow adding to positions 0 through size.  Otherwise, should throw in IndexOutOfBoundsException.
* .set(int index, int x) (which replaces the element at position index with x.)
* .clear() (results in .size() returning 0) and .get(0) throwing a new IndexOutOfBoundsException()
* .remove(int index) (removes the value at position index.  Shifts everything else to the left as necessary)
* .get(int index) (returns the value at position index, or throws a new IndexOutOfBoundsException)
* .size() (returns the number of items in the list.)
* .isEmpty() (returns true if .size() is 0)
* .contains(int val) (returns true if the List contains the given val, false otherwise)
* .indexOf(int val) (returns the index of the first instance of val that appears in the List, or -1 if it does not appear)
* .equals(IntegerLinkedList other) (returns true if this IntegerLinkedList and the other IntegerLinkedList have all of the same elements in the same order.
* .toString() returns a nice representation of all of the elements in the IntegerLinkedList with commons, and square brackets.


LinkedLists have some disadvantages.  For one thing, you find yourself traversing them linearly frequently.  For example, to get to the end of the list, you might do something like this:

            Node current = first;
            while (current.next() != null)
            {
                current = current.next();
            }
Note that adding to the BEGINNING of the list, is a much faster operation than adding to the end of the list.
