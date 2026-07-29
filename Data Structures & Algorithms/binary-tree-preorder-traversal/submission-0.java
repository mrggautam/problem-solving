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
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList();
        preorder(root, result);
        return result;
        
    }

     public void preorder(TreeNode node, List<Integer> result) {

        TreeNode curr = node;

        while(curr != null) {
            if(curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
                continue;
            }
            TreeNode leftsRightMost = getLeftsRightMost(curr);
            if(leftsRightMost.right == curr) {
                leftsRightMost.right = null;
                curr = curr.right;
            } else {
                leftsRightMost.right = curr;
                result.add(curr.val);
                curr = curr.left;
            }
        }
        
    
    }

     public TreeNode getLeftsRightMost(TreeNode node) {
        if(node == null) {
            return null;
        }
        TreeNode curr = node.left;
        while(curr != null && curr.right != null && curr.right != node) {
            curr = curr.right;
        }

        return curr;
    }
}