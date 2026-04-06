/*
Problem: LeetCode 162 - Find Peak Element
Pattern: Binary Search
Difficulty: Medium

Approach:
- Compare mid with next element
- Move towards increasing slope
- Peak always exists

Time Complexity: O(log n)
Space Complexity: O(1)
*/
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]<nums[mid+1]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}
