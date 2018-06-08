/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
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

//1. Hash Table Solution
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while(head != null){
        	if(nodesSeen.contains(head)){
        		return true;
        	}
        	else{
        		nodesSeen.add(head);
        	}
        	head = head.next;
        }
        return false;
    }
}

//2. Two Pointers: a fast pointer and a slow pointer
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        
        while(fast != slow){
        	if(fast == null || fast.next == null){
        		return false;
        	}
        	else{
        		fast = fast.next.next;
        		slow = slow.next;
        	}
        }
        return true;
    }
}
