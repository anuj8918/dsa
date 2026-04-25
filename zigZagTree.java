/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        int height = treeHeight(root);
        boolean lToRTrav=true;

        for(int i=1; i<=height; i++){
            List<Integer> curr = new ArrayList<>();
            if(lToRTrav){
                leftToRightTrav(root, i, curr);
            }
            else{
                rightToLeftTrav(root, i, curr);
            }
            res.add(curr);
            lToRTrav=!lToRTrav;
        }
        return res;
    }
    public int treeHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=treeHeight(root.left);
        int rh=treeHeight(root.right);
        return Math.max(lh,rh)+1;
    }
    public void leftToRightTrav(TreeNode root, int level, List<Integer> curr){
        if(root==null){
            return;
        }
        if(level==1){
            curr.add(root.val);
        }
        else{
            leftToRightTrav(root.left, level-1, curr);
            leftToRightTrav(root.right, level-1, curr);
        }
    }
    public void rightToLeftTrav(TreeNode root, int level, List<Integer> curr){
        if(root==null){
            return;
        }
        if(level==1){
            curr.add(root.val);
        }
        else{
            rightToLeftTrav(root.right, level-1, curr);
            rightToLeftTrav(root.left, level-1, curr);
        }
    }
}