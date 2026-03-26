/*
Problem: LeetCode 435 - Non-overlapping Intervals
Pattern: Greedy
Difficulty: Medium

Approach:
- Sort intervals based on end time
- Select maximum number of non-overlapping intervals
- If overlap occurs, skip interval with larger end
- Result = total intervals - non-overlapping intervals

Time Complexity: O(n log n)
Space Complexity: O(1)
*/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 1;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] >= prevEnd) {
                count++;
                prevEnd = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}
