import java.util.Scanner;

public class ReversePolishCalculator
{
    public static void main(String[] args)
    {
        Stack<Double> expressionStack = new ArrayListStack<Double>();
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        do
        {
            System.out.println("Enter number, math operation(+,-,*, or /), or Q to quit:");
            input = keyboard.nextLine().trim();
            double num = -1;
            
            try{
                num = Double.parseDouble(input);
                expressionStack.push(num);
                continue;

            }
            catch (Exception e){
                
            };

            if (input.equals("+")){
                if (expressionStack.size() < 2){
                    System.out.println("Error! Invalid RPN Expression!");
                }
                double a = expressionStack.pop();
                double b = expressionStack.pop();
                expressionStack.push(a+b);
            }
            else if (input.equals("-")){
                if (expressionStack.size() < 2){
                    System.out.println("Error! Invalid RPN Expression!");
                }
                double a = expressionStack.pop();
                double b = expressionStack.pop();
                expressionStack.push(b-a);
            }
            else if (input.equals("*")){
                if (expressionStack.size() < 2){
                    System.out.println("Error! Invalid RPN Expression!");
                }
                double a = expressionStack.pop();
                double b = expressionStack.pop();
                expressionStack.push(a*b);
            }
            else if (input.equals("/")){
                if (expressionStack.size() < 2){
                    System.out.println("Error! Invalid RPN Expression!");
                }
                double a = expressionStack.pop();
                double b = expressionStack.pop();
                expressionStack.push(b/a);
            }
            else if (!(input.equals("q")) || input.equals("Q")){
                System.out.println("invalid input!");
            }

            expressionStack.toString();

        }while (!input.toUpperCase().trim().equals("Q"));
    
        System.out.println("Solution: " + expressionStack.peek());
    
        
    }
}
