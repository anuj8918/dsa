/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                Node node = q.poll();
                
                if(i==0){
                    res.add(node.data);
                }
                
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
        }
        return res;
    }
}