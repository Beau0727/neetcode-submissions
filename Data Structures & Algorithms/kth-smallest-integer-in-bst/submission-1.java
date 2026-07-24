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
    public int kthSmallest(TreeNode root, int k) {
        int leftSize = countNodes(root.left);
        if (leftSize + 1 == k) {
            return root.val;
        } else if (k <= leftSize) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - leftSize - 1);
        }
    }

    // 统计以node为根的树一共有多少节点
    private int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}