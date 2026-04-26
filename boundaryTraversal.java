/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> res = new ArrayList<>();
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        if(root==null){
            return res;
        }
        res.add(root.data);
        leftBoundary(root.left);
        leafBoundary(root.left);
        leafBoundary(root.right);
        rightBoundary(root.right);
        return res;
    }
    void leftBoundary(Node curr){
        if(curr==null || isLeaf(curr)){
            return;
        }
        res.add(curr.data);
        if(curr.left!=null){
            leftBoundary(curr.left);
        }
        else{
            leftBoundary(curr.right);
        }
    }
    void rightBoundary(Node curr){
        if(curr==null || isLeaf(curr)){
            return;
        }
        if(curr.right!=null){
            rightBoundary(curr.right);
        }
        else{
            rightBoundary(curr.left);
        }
        res.add(curr.data);
    }
    void leafBoundary(Node curr){
        if(curr==null){
            return;
        }
        if(isLeaf(curr)){
            res.add(curr.data);
        }
        leafBoundary(curr.left);
        leafBoundary(curr.right);
    }
    boolean isLeaf(Node curr){
        return curr.left==null && curr.right==null;
    }
}