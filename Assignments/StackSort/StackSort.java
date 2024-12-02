import java.util.*;

public class StackSort {
    
    public static Stack<Integer> sort(Stack<Integer> input){
        Stack<Integer> temp = new Stack<Integer>();
        while(!input.isEmpty())
        {
            int tmp = input.pop();

            while(!temp.isEmpty() && temp.peek() < tmp)
            {
                input.push(temp.pop());
            }
            temp.push(tmp);
        }
        return temp;
    }
    
    public static void main(String args[])
    {
        Stack<Integer> input = new Stack<Integer>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);
     
        // This is the temporary stack
        Stack<Integer> tmpStack = sort(input);
        System.out.println("Sorted numbers are:");
        
        System.out.print("[");
        while (tmpStack.size() > 1)
        {
            System.out.print(tmpStack.pop() + ", ");
        } 
        System.out.println(tmpStack.pop() + "]");
    }
}
