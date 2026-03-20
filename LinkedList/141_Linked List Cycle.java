/*
Problem: LeetCode 141 - Linked List Cycle
Pattern: Fast & Slow Pointer
Difficulty: Easy

Approach:
- Detect cycle using two pointers

Time Complexity: O(n)
Space Complexity: O(1)
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slowptr = head;
        ListNode fastptr = head;

        while(slowptr!=null
        && fastptr !=null
        && fastptr.next !=null){
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
            if(slowptr == fastptr){
                return true;
            }
        }
        return false;
    }
}
