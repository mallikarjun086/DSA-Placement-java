/*
Problem: LeetCode 347 - Top K Frequent Elements
Pattern: HashMap + Heap
Difficulty: Medium

Approach:
- Count frequency using hashmap
- Use heap to get top k elements

Time Complexity: O(n log k)
Space Complexity: O(n)
*/
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }
        arr.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }
}
