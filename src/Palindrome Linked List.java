/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
*/

import java.util.HashMap;
import java.util.Map;

public class isPalindrome {
	public static class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x) {val = x;}
	}
	
	public static void main(String[] args){
		
		ListNode h = new ListNode(0);
		ListNode first = new ListNode(0);
		h.next = first;
		first.next = null;
		
		boolean result = isPalindrome(h);
		System.out.println(result);
	}
	
    public static boolean isPalindrome(ListNode head) {
    	ListNode slow = head, fast = head;
    	while(fast != null && fast.next != null){
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	
    	// if odd
    	if(fast != null){
    		slow = slow.next;
    	}
    	
    	slow = reverse(slow);
    	fast = head;
    	
    	while(slow != null){
    		if(slow.val != fast.val){
    			return false;
    		}
    		slow = slow.next;
    		fast = fast.next;
    	}
    	return true;
    }
    
    public static ListNode reverse(ListNode head){
    	ListNode curr = head;
    	ListNode newHead = null;
    	
    	while(curr != null){
    		ListNode next = curr.next;
    		curr.next = newHead;
    		newHead = curr;
    		curr = next;
    	}
    	return newHead;
    }
}
