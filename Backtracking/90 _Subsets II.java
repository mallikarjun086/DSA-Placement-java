/*
Problem: LeetCode 90 - Subsets II
Pattern: Backtracking
Difficulty: Medium

Approach:
- Sort the array to handle duplicates
- Use backtracking to generate subsets
- Skip duplicate elements using condition:
  if(i > index && nums[i] == nums[i-1]) continue
- Add current subset at each step

Time Complexity: O(n * 2^n)
Space Complexity: O(n)
*/
class Solution {

    private void backTrack(List<List<Integer>> resultList,List<Integer> tempset,int[] nums,int start){
        if(resultList.contains(tempset))
            return;
        resultList.add(new ArrayList<>(tempset));
        for(int i = start;i<nums.length;i++){
            tempset.add(nums[i]);
            backTrack(resultList,tempset,nums,i+1);
            tempset.remove(tempset.size()-1);
        }
    }
    

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resultList=new ArrayList<>();
        Arrays.sort(nums);
        backTrack(resultList,new ArrayList<>(),nums,0);
        return resultList;
        
    }
}
