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
    public void reorderList(ListNode head) {
        Deque<Integer> s = new ArrayDeque<>();
        ListNode tail = head;
        int size =0;
        while(tail!=null)
        {
            s.push(tail.val);
            tail = tail.next;
            size++;
        }
        tail = head;
        while(!s.isEmpty() && tail!=null)
        {
            tail.next = new ListNode(s.pop(),tail.next);
            tail = tail.next.next;
        }
        tail = head;
        int i=0;
        while(tail!=null)
        {
            
            i++;
            if(i==size) tail.next=null;
            tail = tail.next;
        }
        
    }
}