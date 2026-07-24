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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(n == 0 ){
            return null;
        }
        int leftsize = indexOf(inorder,preorder[0]);
        int[] pre1 = Arrays.copyOfRange(preorder,1,1+leftsize);
        int[] pre2 = Arrays.copyOfRange(preorder,1+leftsize,n);
        int[] in1 = Arrays.copyOfRange(inorder,0,leftsize);
        int[] in2 = Arrays.copyOfRange(inorder,1+leftsize,n);
        TreeNode left = buildTree(pre1,in1);
        TreeNode right = buildTree(pre2,in2);
        return new TreeNode(preorder[0],left,right);
         
        
    }
    private int indexOf(int[] a, int x){
        for(int i = 0 ; ;i++){
            if(a[i] == x){
                return i;
            }
        }
    }
}