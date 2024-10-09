package solutions.pack10_bst;

public class TreeNode_660019 {
    int data;
    TreeNode_660019 left, right, parent;
    public TreeNode_660019(int d){
        data = d;
    }
    @Override
    public String toString(){
        if (left == null && right == null){
            return "null<-" + data + "->null";
        }
        if (left == null){
            return "null<-" + data + "->" +right.data;
        }
        if (right == null){
            return left.data + "<-" + data + "->null";
        }
        return left.data + "<-" + data + "->" + right.data;

        
    }
}
