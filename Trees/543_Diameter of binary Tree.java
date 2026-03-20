/*
Problem: LeetCode 543 - Diameter of Binary Tree
Pattern: Trees (DFS)
Difficulty: Easy

Approach:
- Use DFS to calculate height of each node
- At each node, compute diameter = left height + right height
- Keep track of maximum diameter globally

Time Complexity: O(n)
Space Complexity: O(h)
*/
class Solution {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }
}
