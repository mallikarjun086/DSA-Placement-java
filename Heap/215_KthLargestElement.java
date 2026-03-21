/*
Problem: LeetCode 215 - Kth Largest Element in an Array
Pattern: Heap (Priority Queue)
Difficulty: Medium

Approach:
- Use a Min Heap of size k
- Add elements one by one
- If heap size exceeds k, remove smallest element
- The top of heap gives kth largest element

Time Complexity: O(n log k)
Space Complexity: O(k)
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq =new PriorityQueue<>();
        for(int num:nums){
            pq.offer(num);

            if(pq.size() >k){
                pq.remove();
            }
        }
        return pq.peek();
    }
}
