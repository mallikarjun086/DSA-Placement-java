/*
Problem: LeetCode 102 - Level Order Traversal
Pattern: BFS
Difficulty: Medium

Approach:
- Use queue
- Process level by level

Time Complexity: O(n)
Space Complexity: O(n)
*/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
      Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> top = new ArrayList<>();
        if(root == null) return top; 
        
        q.add(root);
        q.add(null);
         List<Integer> bt= new ArrayList<>();
        while(!q.isEmpty()){
           
            TreeNode curr = q.remove();
            if(curr==null){
                top.add(bt);
                bt = new ArrayList<>();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                bt.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return top;  
    }
}
