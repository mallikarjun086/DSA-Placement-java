/*
Problem: LeetCode 46 - Permutations
Pattern: Backtracking
Difficulty: Medium

Approach:
- Use backtracking to generate all permutations
- At each step, choose an unused element
- Mark it as used and explore further
- Backtrack by unmarking and removing element

Time Complexity: O(n!)
Space Complexity: O(n)
*/
class Solution {

    List<Integer> tempList =new ArrayList<>();
    private void backTrack(List<List<Integer>> resultList,ArrayList<Integer> tempList,int[] nums){
        if(tempList.size()==nums.length){
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for(int num:nums){
            if(tempList.contains(num)){
                continue;
            }
            tempList.add(num);
            backTrack(resultList,tempList,nums);
            tempList.remove(tempList.size()-1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backTrack(resultList,new ArrayList<>(),nums);
        return resultList;
    }
}
