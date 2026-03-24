/*
Problem: LeetCode 39 - Combination Sum
Pattern: Backtracking
Difficulty: Medium

Approach:
- Use recursion to explore all combinations
- At each step, choose a number and reduce target
- Allow reuse of same element
- Backtrack by removing last added element

Time Complexity: Exponential
Space Complexity: O(target)
*/
class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> current) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) return;

        for (int i = index; i < candidates.length; i++) {

            current.add(candidates[i]);

            // reuse same element → i (not i+1)
            backtrack(candidates, target - candidates[i], i, current);

            // undo choice
            current.remove(current.size() - 1);
        }
    }
}
