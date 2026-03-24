/*
Problem: LeetCode 78 - Subsets
Pattern: Backtracking
Difficulty: Medium

Approach:
- Use backtracking to generate all possible subsets
- At each step, choose to include or exclude an element
- Add current subset to result at every step
- Explore all possibilities recursively

Time Complexity: O(n * 2^n)
Space Complexity: O(n)
*/
class Solution {
    
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
       backTrack(resultList,new ArrayList<>(),nums,0);
       return resultList;
    }
    private void backTrack(List<List<Integer>> resultSets,List<Integer> tempSet,int[] nums,int start){
        resultSets.add(new ArrayList<>(tempSet));
        for(int i=start;i<nums.length;i++){
            tempSet.add(nums[i]);
            backTrack(resultSets,tempSet,nums,i+1);
            tempSet.remove(tempSet.size()-1);
        }
    }
}
