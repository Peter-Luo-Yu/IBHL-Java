public class Test {

    public static IntegerDoubleLinkedList initializeList(int size) {
        IntegerDoubleLinkedList list = new IntegerDoubleLinkedList();
        for (int val = 10; val <= 10 * size; val += 10)
        {
            list.add(val);
        }
        return list;
    }

    public static void test_add_val()
    {
        IntegerDoubleLinkedList list = new IntegerDoubleLinkedList();
        System.out.println("Test add(val):  add 5 values to list");
        System.out.println("Expected: 10 20 30 40 50 size: 5" );
        for (int val = 10; val <= 50; val +=10)
        {
            list.add(val);
        }
        System.out.println("Output:  " + list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Test add(val): add the 11th item to the list (causes a array resize)");
        System.out.println("Expected: 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110  size: 11");
        for (int val = 60; val <= 110; val +=10)
        {
            list.add(val);
        }
        System.out.println("Output:  " + list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");
    }

    public static void test_get()
    {
        System.out.println("Test get(index):  get all values from the list");
        System.out.println("Expected: 10 20 30 40 50" );
        IntegerDoubleLinkedList list = initializeList(5);
        System.out.print("Output:   ");
        for (int i=0; i < 5; i++ )
        {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Test get(index): Try to get the item at invalid index (position 5) from the List");
        System.out.println("Expected:  IndexOutOfBoundsException: 5");
        try {
            System.out.println(list.get(5));
        }catch(IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Test get(index): Try to get the item at invalid index (position -1) from the List");
        System.out.println("Expected:  IndexOutOfBoundsException: -1");
        try {
            System.out.println(list.get(-1));
        }catch(IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println("-----------------------------------------------------------------");
    }

    public static void test_add_index_val()
    {
        IntegerDoubleLinkedList list = initializeList(10);
        System.out.println("Test add(index, val): add item to position 0");
        System.out.println("Expected: 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100  size: 11");
        list.add(0,1);
        System.out.println("Output:  " + list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Test add(index, val): add item to position 5");
        System.out.println("Expected: 1, 10, 20, 30, 40, 45, 50, 60, 70, 80, 90, 100  size: 12");
        list.add(5,45);
        System.out.println("Output:  " + list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Test add(index, val): add item to position size");
        System.out.println("Expected: 1, 10, 20, 30, 40, 45, 50, 60, 70, 80, 90, 100, 110  size: 13");
        list.add(list.size(),110);
        System.out.println("Output:  " + list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Test add(index, val): add item to position -1");
        System.out.println("Expected:  IndexOutOfBoundsException: -1");
        try {
            list.add(-1, 120);
        }catch(IndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
        System.out.println("Output:  " + list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Test add(index, val): add item to position size() + 1");
        System.out.println("Expected:  IndexOutOfBoundsException: 15");
        try {
            list.add(15, 120);
        }catch(IndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
        System.out.println(list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");
    }

    public static void test_size()
    {
        IntegerDoubleLinkedList list = new IntegerDoubleLinkedList();
        System.out.println("Test size() on an empty list:  ");
        System.out.println("Expected: [] size: 0");
        System.out.println("Output:  " + list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");
        list = initializeList(5);
        System.out.println("Test size() on a list of size 5:  ");
        System.out.println("Expected: [10, 20, 30, 40, 50] size: 5");
        System.out.println("Output:  " + list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");
    }

    public static void test_clear()
    {
        IntegerDoubleLinkedList list = new IntegerDoubleLinkedList();
        System.out.println("Test clear() on an empty list:  ");
        System.out.println("Expected: [] size: 0");
        System.out.println("Output:  " + list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Test clear() on a non-empty list:  ");
        list = initializeList(10);
        System.out.println(list + " size: " + list.size());
        System.out.println("Expected: 0");
        list.clear();
        System.out.println(list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");
    }

    public static void test_set()
    {
        IntegerDoubleLinkedList list = initializeList(10);
        System.out.println("Test set(index, val): set position 0 to a value");
        System.out.println("Expected: 5, 20, 30, 40, 50, 60, 70, 80, 90, 100  size: 10");
        list.set(0,5);
        System.out.println("Output:  " + list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Test set(index, val): set position 5 to a value");
        System.out.println("Expected: 5, 20, 30, 40, 50, 55, 70, 80, 90, 100  size: 10");
        list.set(5,55);
        System.out.println("Output:  " + list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Test set(index, val): set position size()-1 to a value");
        System.out.println("Expected: 5, 20, 30, 40, 50, 55, 70, 80, 90, 95  size: 10");
        list.set(list.size()-1,95);
        System.out.println("Output:  " + list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Test set(index, val): set position -1 to a value");
        System.out.println("Expected:  IndexOutOfBoundsException: -1");
        try {
            list.set(-1, 120);
        }catch(IndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
        System.out.println(list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Test set(index, val): set position size() to a value");
        System.out.println("Expected:  IndexOutOfBoundsException: 10");
        try {
            list.set(list.size(), 120);
        }catch(IndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
        System.out.println(list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");
    }

    public static void test_remove()
    {
        IntegerDoubleLinkedList list = initializeList(10);
        System.out.println("Test remove(index): remove item at index 0");
        System.out.println("Expected: 20, 30, 40, 50, 60, 70, 80, 90, 100  size: 9");
        list.remove(0);
        System.out.println("Output:  " + list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Test remove(index): remove item at index 5");
        System.out.println("Expected: 20, 30, 40, 50, 60, 80, 90, 100  size: 8");
        list.remove(5);
        System.out.println("Output:  " + list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Test remove(index): remove item at size()-1");
        System.out.println("Expected: 20, 30, 40, 50, 60, 80, 90  size: 7");
        list.remove(list.size()-1);
        System.out.println("Output:  " + list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Test remove(index): remove item at position -1");
        System.out.println("Expected:  IndexOutOfBoundsException: -1");
        try {
            list.remove(-1);
        }catch(IndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
        System.out.println(list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Test remove(index): remove item at position size()");
        System.out.println("Expected:  IndexOutOfBoundsException: 7");
        try {
            list.remove(list.size());
        }catch(IndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
        System.out.println(list + " size: " + list.size());
        System.out.println("-----------------------------------------------------------------");
    }

    public static void test_isEmpty()
    {
        IntegerDoubleLinkedList list = new IntegerDoubleLinkedList();
        System.out.println("Test isEmpty() on an empty list:  ");
        System.out.println(list + " size: " + list.size());
        System.out.println("Expected: true");
        System.out.println("Output:  " + list.isEmpty());
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Test isEmpty() on a non-empty list:  ");
        list = initializeList(10);
        System.out.println(list + " size: " + list.size());
        System.out.println("Expected: false");
        System.out.println("Output:  " + list.isEmpty());
        System.out.println("-----------------------------------------------------------------");
    }

    public static void test_contains()
    {
        IntegerDoubleLinkedList list = new IntegerDoubleLinkedList();
        System.out.println("Test contains() on an empty list:  ");
        System.out.println("Expected: false");
        System.out.println("Output:   " + list.contains(10));
        System.out.println("-----------------------------------------------------------------");
        list = initializeList(10);
        System.out.println("Test contains() on an non-empty list when item IS in list:  ");
        System.out.println("Expected: true");
        System.out.println("Output:   " + list.contains(10));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Test contains() on an non-empty list when item is NOT in list:  ");
        System.out.println("Expected: false");
        System.out.println("Output:   " + list.contains(110));
        System.out.println("-----------------------------------------------------------------");
    }

    public static void test_indexOf()
    {
        IntegerDoubleLinkedList list = new IntegerDoubleLinkedList();
        System.out.println("Test indexOf() on an empty list:  ");
        System.out.println("Expected: -1");
        System.out.println("Output:   " + list.indexOf(10));
        System.out.println("-----------------------------------------------------------------");
        list = initializeList(10);
        System.out.println("Test indexOf() on an non-empty list when item IS in list:  ");
        System.out.println("Expected: 0");
        System.out.println("Output:   " + list.indexOf(10));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Test indexOf() on an non-empty list when item IS in list:  ");
        System.out.println("Expected: 4");
        System.out.println("Output:   " + list.indexOf(50));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Test indexOf() on an non-empty list when item is NOT in list:  ");
        System.out.println("Expected: -1");
        System.out.println("Output:   " + list.indexOf(110));
        System.out.println("-----------------------------------------------------------------");
    }

    public static void test_equals()
    {
        IntegerDoubleLinkedList list = new IntegerDoubleLinkedList();
        IntegerDoubleLinkedList list2 = new IntegerDoubleLinkedList();

        System.out.println("Test equals() on two EMPTY lists:  ");
        System.out.println("Expected: true");
        System.out.println("Output:   " + list.equals(list2));
        System.out.println("-----------------------------------------------------------------");

        list = initializeList(10);
        list2 = initializeList(10);
        System.out.println("Test equals() on two non-empty lists with the same values in each:  ");
        System.out.println("Expected: true");
        System.out.println("Output:   " + list.equals(list2));
        System.out.println("-----------------------------------------------------------------");

        list2.remove(list2.size()-1);
        System.out.println("Test equals() on two non-empty lists of unequal size with the same values in corresponding positions:  ");
        System.out.println("Expected: false");
        System.out.println("Output:   " + list.equals(list2));
        System.out.println("-----------------------------------------------------------------");

        list.remove(list.size()-1);
        list.remove(list.size()-1);
        System.out.println("Test equals() on two non-empty lists of unequal size with the same values in corresponding positions:  ");
        System.out.println("Expected: false");
        System.out.println("Output:   " + list.equals(list2));
        System.out.println("-----------------------------------------------------------------");

        list = initializeList(10);
        list2 = initializeList(10);
        list2.set(list2.size()-1, -30);
        System.out.println("Test equals() on two non-empty lists of equal size with different values:  ");
        System.out.println("Expected: false");
        System.out.println("Output:   " + list.equals(list2));
        System.out.println("-----------------------------------------------------------------");

    }

    public static void main(String[] args)
    {
        test_add_val();
        test_add_index_val();
        test_get();
        test_size();
        test_clear();
        test_set();
        test_remove();
        test_isEmpty();
        test_contains();
        test_indexOf();
        test_equals();
    }
}
