/*
Problem: LeetCode 56 - Merge Intervals
Pattern: Greedy (Intervals)
Difficulty: Medium

Approach:
- Sort intervals based on start time
- Traverse intervals and merge overlapping ones
- If current interval overlaps with previous, update end
- Otherwise, add new interval to result

Time Complexity: O(n log n)
Space Complexity: O(n)
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for(int[] interval:intervals){
            if(interval[0]<=newInterval[1]){
                newInterval[1] = Math.max(newInterval[1],interval[1]);
            }
            else{
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
