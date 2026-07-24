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
    Map<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 缓存中序数组值对应的下标
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                     inorder, 0, inorder.length - 1);
    }

    /**
     * pre [preL, preR] 当前子树先序区间
     * in  [inL, inR]  当前子树中序区间
     */
    private TreeNode build(int[] preorder, int preL, int preR,
                           int[] inorder, int inL, int inR) {
        if (preL > preR) return null;

        // 根节点为先序第一个元素
        int rootVal = preorder[preL];
        TreeNode root = new TreeNode(rootVal);
        // 根在中序的位置
        int rootIdx = valToIndex.get(rootVal);
        // 左子树节点数量
        int leftSize = rootIdx - inL;

        // 构造左子树
        root.left = build(preorder, preL + 1, preL + leftSize,
                          inorder, inL, rootIdx - 1);
        // 构造右子树
        root.right = build(preorder, preL + leftSize + 1, preR,
                           inorder, rootIdx + 1, inR);
        return root;
    }
}