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
        //minHeap of K size with index(K) and move node to next and check if not null push to queue else not 
        //end case? ->end the heap 
        int k = lists.length;
        PriorityQueue<Pair<Integer,ListNode>> minHeap = new PriorityQueue<>((a,b) -> a.getKey()-b.getKey());
        for(ListNode list: lists){
            if(list != null)
            minHeap.offer(new Pair<>(list.val,list));
        }
       ListNode dummy = new ListNode(-1);
       ListNode head = dummy;
        while(!minHeap.isEmpty()){
         ListNode insertionNode = minHeap.peek().getValue();
           head.next = insertionNode;
           head = head.next;

           minHeap.poll();
           if(insertionNode.next != null)
           minHeap.offer(new Pair<>(insertionNode.next.val,insertionNode.next ));
        }
        return dummy.next;
    }
}