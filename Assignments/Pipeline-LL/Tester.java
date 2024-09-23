public class Tester
{
    private static PipelineNode headNode = null;
    private static PipelineNode tailNode = null;

    //append a new node to the end of the list and adjust pointers
    public static void append(int pos, String descr)
    {
        PipelineNode newNode = new PipelineNode(pos, descr, null);
        if(headNode == null) //There are no nodes yet so the node we “append” will be both the head and the tail
        {
            headNode = newNode;
        }
        else
        {
            tailNode.nextNode = newNode; //update the old tailNode
        }
        
        tailNode = newNode; //specify a new tailNode
    }

     public static void traverseAndPrint( )
    {
        PipelineNode currentNode = headNode;
        int nodeNum = -1;
        do {
            nodeNum++;
            System.out.println("Node number: " + nodeNum);
            System.out.println("Position: " + currentNode.position);
            System.out.println("Description: " + currentNode.description);
            System.out.println(""); //gives a blank line between nodes
            currentNode = currentNode.nextNode;
        }while(currentNode != null); //We don't need to know ahead of time how many
    } 

    public static void insert(int pos, String descr, int nodeNum) {
        PipelineNode newNode = new PipelineNode(pos, descr, null);
        PipelineNode currentNode = headNode;
        PipelineNode previousNode = null;
        int index = 0;

        while (index < nodeNum){    // get currentNode to move once
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
            index++;
        }

        previousNode.nextNode = newNode;
        newNode.nextNode = currentNode;

    }


    public static void main(String args[])
    {
        //Creation of the nodes
        append(0, "Pump station");
        append(3050, "Hwy 35");
        append(4573, "Tank farm"); // 3050 + 1523 = 4573

        traverseAndPrint ( );

        System.out.println("******* now insert a node before old node 2 *******\n");
        insert(4040, "Cold Creek", 2); // 3050 + 990 = 4040
        traverseAndPrint( ); 
    }

}