public class PipelineNode {
    public int position;
    public String description;
    public PipelineNode nextNode; 

    public PipelineNode(int pos, String descr, PipelineNode ptr) {
        position = pos;
        description = descr;
        nextNode = ptr;
    }
}