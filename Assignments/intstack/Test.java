import java.util.*;

public class Test {

    public static int reverseInt(int x){
        IntArrayStack stack = new IntArrayStack();
        int number = x;
        int reversed = 0;
        int factor = 0;

        while (number > 0){
            stack.push(number%10);
            number /= 10;
        }
        while(!(stack.isEmpty())){
            reversed += stack.pop() * Math.pow(10,factor);
            factor++;
        }
        return reversed;
    } 

    public static boolean balanced(String s){
        IntLinkedNodeStack stack = new IntLinkedNodeStack();
        char[] input = s.toCharArray();
        int i = 0;
        int prev = -1;
        int current = -1;
        while (i < input.length){
            if (stack.size() > 0){
                prev = stack.peek();
            } 
            else{
                prev = -1;
            }
            
            current = input[i];
            // System.out.println((char)prev + " " + (char)current);
            stack.push(current);

            if (((char) current == ')' && (char) prev == '(') || ((char) current == ']' && (char) prev == '[') || ((char) current == '}' && (char) prev == '{')){
                stack.pop();
                stack.pop();
                // System.out.println("Popped!");
            }
            i++;
            // System.out.println(stack);
        }
        
        return stack.size() == 0;
    }

    public static int toBinary(int x){
        IntArrayStack stack = new IntArrayStack();
        int ans = 0;
        
        while (x > 0){
            stack.push(x%2);
            x /= 2;
        }

        int index = stack.size()-1;
        while (!(stack.isEmpty())){
            ans += stack.pop() * Math.pow(10, index); 
            index--;
        }
        return ans;
    }
    


    public static void main(String args[]){   
        int a = 123456789;
        int rev = reverseInt(a);

        int b = 365;
        int bin = toBinary(b);

        System.out.println(a + " Reversed: " + rev);
        System.out.println(b + " To Binary: " + bin);

        String test1 = "[()]{}{[()()]()}";
        String test2 = "[(])";
        boolean c = balanced(test2);   // change here to test1 or test2

        if (c){
            System.out.println("Balanced!");
        } else {
            System.out.println("Not Balanced!");
        }

    }
}