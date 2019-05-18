/**
 * 1.处理进位。
 * 2.处理最后进位
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        ListNode resTmp = null;
        ListNode head = null;
        int upper = 0;
        while(a != null || b != null) {
            int av = a != null ? a.val : 0;
            int bv = b != null ? b.val : 0;
            int tmp = av + bv + upper;
            upper = tmp/10;
            ListNode tmpNode = new ListNode(tmp%10);
            if (head != null) {
                resTmp.next = tmpNode;
                resTmp = tmpNode;
            } else {
                resTmp = tmpNode;
                head = resTmp;
            }
            if (a != null) {
                a = a.next;
            }
            if (b != null) {
                b = b.next;
            }
        }
        if (upper != 0) {
            ListNode tmpNode = new ListNode(upper);
            resTmp.next = tmpNode;
        }
        return head;
    }

}