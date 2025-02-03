public class TowerOfHanoi
{
    /** instance variables
     * 1) I should have three Stack<Integer> objects:  stackA, stackB, and stackC
     * They are Stacks of Integer so that in a stack of 3, 3 would be the largest disk, 2 would be the middle disk
     * and 1 would be the smallest disk.  1 is always the smallest disk
     * 2) I should also have an int variable keeping track of how many moves have occured.
     */

    /**
     * Constructor for objects of class TowerOfHanoi
     * @param stackSize sets the number of disks in the puzzle.  They are initially in stack A.
     * constructs a Stack<Integer> with stackSize disks on stack A 
     * (in order by size with the largest on the bottom)
     * and constructs  Stack<Integer> objects with 0 disks for stack B and C
     * moves should initially be initialized to 0
	 * NOTE:  You can use your ArrayListStack<Integer> OR your LinkedListStack<Integer>, whichever you prefer.
    */
   
    int moves = 0;
    Stack<Integer> stackA = new ArrayListStack<Integer>();
    Stack<Integer> stackB = new ArrayListStack<Integer>();
    Stack<Integer> stackC = new ArrayListStack<Integer>();

    
    public TowerOfHanoi(int stackSize)
    {
        for (int i = 0; i < stackSize; i++){
            stackA.push(stackSize - i - 1);
        }
    }
    
	/*Note, this relies on your Stack class having a nice toString() method of its
	* own.  You may need to write one inside your ArrayListStack or LinkedListStack
	* class.
	*/
    public String toString()
    {
        String result = "Move: " + moves;
        result += "\nA: " + stackA;
        result += "\nB: " + stackB;
        result += "\nC: " + stackC;
        result += "\n------------------";
        
        return result;
    }
    
    /* public method solve is the method that can be called on a TowerOfHanoi object, to solve the puzzle.  
     * @param logMoves:  If this variable is true, then each stack in the process 
	 * should be displayed along the way.  If this variable is false, only the 
	 * last stack, and the number of moves required should be displayed.
     */
    public void solve(boolean logMoves)
    {
        move(stackA.size(), stackA, stackC, stackB, logMoves);
    }
    
	/* public method solve is the method that can be called on a TowerOfHanoi object, to solve the puzzle.  
	 * @param disks (the number of disks to be moved from Stack from to Stack to
	 * @param from (the Stack that you are moving disks from)
	 * @param to (the Stack that you are moving disks to)
	 * @param other (this Stack can be used to move the disks from from to to
	 *   but at the end of the function, it should be in the same state as 
	 *   when it began.
     * @param logMoves:  If this variable is true, then each stack in the process 
	 * should be displayed along the way.  If this variable is false, only the 
	 * last stack, and the number of moves required should be displayed.
     */
    private void move(int disks, Stack<Integer> from, Stack<Integer> to, Stack<Integer> other, boolean logMoves)
    {
        //Base Case:  the number of disks being moved is 1
        if (disks == 1){
            to.push(from.pop());
            moves++;

            if (logMoves){
                System.out.println(this.toString());
            }
        }
        //Recursive Case:  the number of disks being moved is > 1
        else{
            move(disks-1, from, other, to, logMoves);
            move(1, from, to, other, logMoves);
            move(disks-1, other, to, from, logMoves);

        }
    }

    public static void main(String[] args)
    {
        TowerOfHanoi toh5 = new TowerOfHanoi(5);
        System.out.println(toh5);
        toh5.solve(true); //change to false if you don't want to see the intermediate steps.
		System.out.println(toh5);
    }
}














