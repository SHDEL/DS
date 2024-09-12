package solutions.pack10_bst;

import java.util.Arrays;

public class BST {
    TreeNode root;
    public BST(){
        root = null;
    }
    public TreeNode getRoot(){
        return root;
    }
    public void insert(int d) {
        if(root == null) {
            root = new TreeNode(d);
            return;
        }
        TreeNode current = root;
        while (current != null) {
            if (d < current.data) {
                if (current.left != null){
                    current = current.left;
                } 
                else {
                    /* your code 1*/
                    current.left = new TreeNode(d);
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
                    current.right = new TreeNode(d);
                    current.right.parent = current;
                    return;
                }
            }
        } //while
    }
    public TreeNode search(int d){
        return searchRecurse(d, root);

    }
    public TreeNode searchRecurse(int d, TreeNode node){
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
    public void delete(int d, TreeNode node) {
        if(node==null) return; //not found
        if(d < node.data){
            delete(d, node.left);
        }
        else if(d > node.data){
            delete(d, node.right);
        }
        else { // found!! now, time to delete
            if((node.left==null)||(node.right==null)) { // 0 or 1 child
                TreeNode q = (node.left==null)?node.right:node.left;
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
                TreeNode q = findMaxFrom(node.left);
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
    private TreeNode findMaxFrom(TreeNode toBeDelete){
        TreeNode cur = toBeDelete.left;
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
    private void printInOrderRecurse(TreeNode node){
        if (node == null) return;
        printInOrderRecurse(node.left);
        System.out.print(node.data + " ");
        printInOrderRecurse(node.right);
    }
    public void printPreOrder(){
        printPreOrderRecurse(root);
        System.out.println();
    }
    public void printPreOrderRecurse(TreeNode node){
        if (node == null) return;
        System.out.print(node.data + " ");
        printPreOrderRecurse(node.left);
        printPreOrderRecurse(node.right);
    }
    public void printPostOrder(){
        printPostOrderRecurse(root);
        System.out.println();
    }
    public void printPostOrderRecurse(TreeNode node){
        if (node == null) return;
        printPostOrderRecurse(node.left);
        printPostOrderRecurse(node.right);
        System.out.print(node.data + " ");
    }
    public TreeNode findMax(){
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }
    public TreeNode findMin(){
        TreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
    public int height(){
        return heightRecurse(root);
    }
    public int heightRecurse(TreeNode node){
        if (node == null) return 0;
        int left = heightRecurse(node.left);
        int right = heightRecurse(node.right);
        return Math.max(left, right) + 1;
    }
    public int count(){
        return countRecurse(root);
    }
    public int countRecurse(TreeNode node){
        if (node == null) return 0;
        return 1+countRecurse(node.left)+countRecurse(node.right);
    }
    public Double findMedian(){
        TreeNode node = root;
        int length = count();
        int [] arr = new int[length];
        int idx = 0;
        addArray(node, arr, idx);
        System.out.println(Arrays.toString(arr));
        if (length % 2 != 0){
            return (double) arr[length / 2];
        }
        else{
            return (double) ((arr[(length / 2) - 1] ) + (arr[length / 2])) / 2; 
        }
    }
    void addArray(TreeNode node, int[] arr, int idx){
        if (node == null) return;
        addArray(node.left, arr, idx + 1);
        arr[idx] = node.data;
        addArray(node.right, arr, idx + 1);
    }
}
