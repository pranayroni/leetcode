/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head== null) return head;
        if(head.next == null) return head;
        ListNode prev = head;
        ListNode curr = head.next;
        while(prev!=null && curr!=null)
        {
            while(curr!=null && curr.val==prev.val)
            {
                prev.next = curr.next;
                curr=prev.next;
            }
            prev = prev.next;
            
        }
        return head;
    }
}