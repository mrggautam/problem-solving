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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        postorder(root, result);
        Collections.reverse(result);
        return result;
    }

    public void postorder(TreeNode node, List<Integer> result) {

        TreeNode curr = node;

        while(curr != null) {
            if(curr.right == null) {
                result.add(curr.val);
                curr = curr.left;
                continue;
            }
            TreeNode rightsLeftMost = getRightsLeftMost(curr);
            if(rightsLeftMost.left == curr) {
                rightsLeftMost.left = null;
                curr = curr.left;
            } else {
                rightsLeftMost.left = curr;
                result.add(curr.val);
                curr = curr.right;
            }
        }
        
    
    }

     public TreeNode getRightsLeftMost(TreeNode node) {
        if(node == null) {
            return null;
        }
        TreeNode curr = node.right;
        while(curr != null && curr.left != null && curr.left != node) {
            curr = curr.left;
        }

        return curr;
    }
}