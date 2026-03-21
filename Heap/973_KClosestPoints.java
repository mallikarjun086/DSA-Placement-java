/*
Problem: LeetCode 973 - K Closest Points to Origin
Pattern: Heap (Priority Queue)
Difficulty: Medium

Approach:
- Use a Max Heap of size k based on distance
- Push points into heap
- If heap size exceeds k, remove farthest point
- Remaining elements in heap are k closest points

Time Complexity: O(n log k)
Space Complexity: O(k)
*/
class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap =
            new PriorityQueue<>((a, b) -> getDistance(b) - getDistance(a));

        for(int[] point : points){

            maxHeap.add(point);

            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];

        while(k > 0){
            res[--k] = maxHeap.poll();
        }

        return res;
    }

    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
