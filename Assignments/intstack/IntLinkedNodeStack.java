//IntLinkedNode.java
import java.util.EmptyStackException;

class IntLinkedNode
{
   public int value;
   public IntLinkedNode next;
}

//IntLinkedNodeStack.java
public class IntLinkedNodeStack
{
   private IntLinkedNode top;
   private int size;
   
   public IntLinkedNodeStack(){
      top = null;
      size = 0;
   }

   public void push(int x){
      IntLinkedNode newNode = new IntLinkedNode();
      newNode.value = x;
      newNode.next = top;
      top = newNode;
      size++;
   }

   public int pop(){
      if (isEmpty()){
         throw new EmptyStackException();
      }
      int value = top.value;
      top = top.next;
      size--;
      return value;
   }

   
   public int peek(){
      if (isEmpty()){
         throw new EmptyStackException();
      }
      return top.value;
   }

   public int size(){
      return size;
   }

   public boolean isEmpty(){
      return top == null;
   }

   public String toString() {
      String returnString = "[";
      IntLinkedNode current = top;
      while (current != null && current.next != null){
         returnString += current.value + ",";
         current = current.next;
      }
      if (current != null){
         returnString += current.value;
      }
      returnString += "]";

      return returnString;
   }

   public void clear() {
      top = null;
      size = 0;
   }

}


