public class IntArrayStack
{
  private int[] stack;
  private int top;

  public IntArrayStack(){
    stack=new int[50];
    top=-1;
  }

  public void push(int x){
    top++;
    stack[top] = x;
  }

  public int pop(){
    int val = stack[top];
    top--;
    return val;
  }


  public int peek(){
    return stack[top];
  }

  public int size(){
    return top+1;
  }

  public boolean isEmpty(){
    return top < 0;
  }

  public boolean isFull(){
    return top >= 49;
  }

  public String toString(){
    String returnString = "";
    for (int i = 0; i < top-1; i++){
      returnString += stack[i] + " ";
    }
    returnString += stack[top];
    return returnString;
  }

  public void clear() {
    top = -1;
  }
}
