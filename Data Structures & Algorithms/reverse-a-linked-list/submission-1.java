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
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode nextNode = cur.next;   // 保存下一个节点
            cur.next = dummy.next;          // 当前节点指向已反转部分的头部
            dummy.next = cur;               // 将当前节点插入到 dummy 之后
            cur = nextNode;                 // 移动到下一个原始节点
        }
        return dummy.next;
    }
}
