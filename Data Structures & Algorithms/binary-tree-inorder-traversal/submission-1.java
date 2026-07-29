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
    
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList();
        inorder(root, result);
        return result;

    }

      public void inorder(TreeNode node, List<Integer> result) {

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
                result.add(curr.val);
                curr = curr.right;
            } else {
                leftsRightMost.right = curr;
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

    public void inorder2(TreeNode node, List<Integer> result) {

        if(node == null) {
            return;
        }

        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
}