public class Test{

    public static void main(String[] args){
        MyList<Integer> list = new MyList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i+1);
        }
        System.out.println("Initiate list: " + list);

        list.add(10,100);
        System.out.println("Added 100 to index 10: " + list);
        
        list.remove(4);
        System.out.println("Removed 4th element: " + list);

        list.add(9,999);
        System.out.println("Added 999 to the 5th index: " + list);
        
        list.set(9, 69);
        System.out.println("Set the element at index 9 to 69: " + list);
      
        System.out.println("The 9th element is: " + list.get(9));

        System.out.println("The size of the list is: " + list.size());
        
        System.out.println("The index of 10 is: " + list.indexOf(10));

        System.out.println("Does the list contain 1111: " + list.contains(1111));

        MyList<Integer> otherList = new MyList<>();
        otherList.add(1);
        otherList.add(2);
        otherList.add(3);
        otherList.add(4);
        otherList.add(6);
        otherList.add(7);
        otherList.add(8);
        otherList.add(9);
        otherList.add(10);
        otherList.add(69);
        otherList.add(100);

        System.out.println("Otherlist: " + otherList);

        System.out.println("The list is equal to another identical list: " + list.equals(otherList));

    }

}