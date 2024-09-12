package solutions.pack10_bst;

import java.util.ArrayList;

public class BST_660019 {
    TreeNode_660019 root;
    public BST_660019(){
        root = null;
    }
    public TreeNode_660019 getRoot(){
        return root;
    }
    public void insert(int d) {
        if(root == null) {
            root = new TreeNode_660019(d);
            return;
        }
        TreeNode_660019 current = root;
        while (current != null) {
            if (d < current.data) {
                if (current.left != null){
                    current = current.left;
                } 
                else {
                    /* your code 1*/
                    current.left = new TreeNode_660019(d);
                    current.left.parent = current;
                    return;
                }
            } 
            else { //! (d < p.data)
                if (current.right != null){
                    /*your code 2*/
                    current = current.right;
                }
                else {
                    current.right = new TreeNode_660019(d);
                    current.right.parent = current;
                    return;
                }
            }
        } //while
    }
    public TreeNode_660019 search(int d){
        return searchRecurse(d, root);

    }
    private TreeNode_660019 searchRecurse(int d, TreeNode_660019 node){
        if (node == null) return null;
        if (d == node.data) return node;
        if (d < node.data){
            return searchRecurse(d, node.left);
        }
        return searchRecurse(d, node.right);
    }
    public void delete(int d){
        delete(d, root);
    }
    private void delete(int d, TreeNode_660019 node) {
        if(node==null) return; //not found
        if(d < node.data){
            delete(d, node.left);
        }
        else if(d > node.data){
            delete(d, node.right);
        }
        else { // found!! now, time to delete
            if((node.left==null)||(node.right==null)) { // 0 or 1 child
                TreeNode_660019 q = (node.left==null)?node.right:node.left;
                if(node.parent.left==node){ // this node is a left child
                    node.parent.left = q;
                }
                else{
                    node.parent.right = q;
                }
                if(q!=null) q.parent = node.parent;
            } 
            else { // 2 children
                // see next slide
                TreeNode_660019 q = findMaxFrom(node.left);
                delete(q.data, node.left);
                if(node.parent.left==node){
                    node.parent.left = q;
                }
                else{
                    node.parent.right = q;
                    q.left = node.left;
                    q.right = node.right;
                }
            }
        } // else for delete
    }
    private TreeNode_660019 findMaxFrom(TreeNode_660019 toBeDelete){
        TreeNode_660019 cur = toBeDelete.left;
        while (cur.right != null) {
            cur = cur.right;
            
        }
        return cur;
    }
    // Printing
    public void printInOrder(){
        printInOrderRecurse(root);
        System.out.println();
    }
    private void printInOrderRecurse(TreeNode_660019 node){
        if (node == null) return;
        printInOrderRecurse(node.left);
        System.out.print(node.data + " ");
        printInOrderRecurse(node.right);
    }
    public void printPreOrder(){
        printPreOrderRecurse(root);
        System.out.println();
    }
    private void printPreOrderRecurse(TreeNode_660019 node){
        if (node == null) return;
        System.out.print(node.data + " ");
        printPreOrderRecurse(node.left);
        printPreOrderRecurse(node.right);
    }
    public void printPostOrder(){
        printPostOrderRecurse(root);
        System.out.println();
    }
    private void printPostOrderRecurse(TreeNode_660019 node){
        if (node == null) return;
        printPostOrderRecurse(node.left);
        printPostOrderRecurse(node.right);
        System.out.print(node.data + " ");
    }
    public TreeNode_660019 findMax(){
        TreeNode_660019 cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }
    public TreeNode_660019 findMin(){
        TreeNode_660019 cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
    public int height(){
        return heightRecurse(root);
    }
    private int heightRecurse(TreeNode_660019 node){
        if (node == null) return 0;
        int left = heightRecurse(node.left);
        int right = heightRecurse(node.right);
        return Math.max(left, right) + 1;
    }
    public int count(){
        return countRecurse(root);
    }
    private int countRecurse(TreeNode_660019 node){
        if (node == null) return 0;
        return 1+countRecurse(node.left)+countRecurse(node.right);
    }
    public Double findMedian(){
        TreeNode_660019 node = root;
        ArrayList<Integer> arr = new ArrayList<>();
        addArray(node, arr);
        int length = arr.size();
        System.out.println(arr);
        if (length % 2 != 0){
            return (double) arr.get(length / 2);
        }
        else{
            return (double) ((arr.get((length / 2) - 1)) + (arr.get(length/ 2))) / 2; 
        }
    }
    void addArray(TreeNode_660019 node, ArrayList<Integer> arr){
        if (node == null) return;
        addArray(node.left, arr);
        arr.add(node.data);
        addArray(node.right, arr);
    }
    public int findRank(int x){
        ArrayList<Integer> arr = new ArrayList<>();
        TreeNode_660019 node = root;
        addArray(node, arr);
        System.out.println(arr);
        for (int i = 0; i < arr.size(); i++){
            if (x == arr.get(i)){
                return i + 1;
            }
        }
        return -1;

    }
}
