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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)-> a.val -b.val);
        for(ListNode node: lists){
            if(node != null){
                minHeap.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(!minHeap.isEmpty()){
            ListNode insertionNode =minHeap.poll();
            head.next = insertionNode;
            head = head.next;
            if(insertionNode.next != null){
                minHeap.offer(insertionNode.next);
            }

        }
        return dummy.next;
    }
}