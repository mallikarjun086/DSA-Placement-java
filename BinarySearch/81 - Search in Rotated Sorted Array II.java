/*
Problem: LeetCode 81 - Search in Rotated Sorted Array II
Pattern: Binary Search (with duplicates)
Difficulty: Medium

Approach:
- Use modified binary search
- Handle duplicates by shrinking boundaries
- Identify sorted half and search accordingly

Time Complexity: O(log n) average, O(n) worst
Space Complexity: O(1)
*/
class Solution {
    public boolean search(int[] nums, int target) {

        int low = 0, high = nums.length - 1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(nums[mid] == target) return true;

            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low++;
                high--;
            }

            else if(nums[low] <= nums[mid]){ // left sorted
                if(nums[low] <= target && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }

            else{ // right sorted
                if(nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return false;
    }
}
