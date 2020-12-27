# Linked-list

+ [Reorder List](#reorder-list)

[MDLink]: <>

## Reorder List

https://leetcode.com/problems/reorder-list/

```java
public class Solution {
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}
public ListNode getMediumNode(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode slowNode = head;
    ListNode prevNode = slowNode;
    ListNode fastNode = head;
    while (fastNode != null && fastNode.next != null) {
        prevNode = slowNode;
        slowNode = slowNode.next;
        fastNode = fastNode.next.next;
    }
    prevNode.next = null;
    return slowNode;
}

public void mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode curNode = new ListNode(0);
    while (l1 != null && l2 != null) {
        curNode.next = l1;
        l1 = l1.next;
        curNode = curNode.next;
        curNode.next = l2;
        l2 = l2.next;
        curNode = curNode.next;
    }
    if (l1 != null) {
        curNode.next = l1;
    }
    if (l2 != null) {
        curNode.next = l2;
    }
}
// Given 1->2->3->4, reorder it to 1->4->2->3.
// Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;
    ListNode secondHalf = reverseList(getMediumNode(head));
    mergeTwoLists(head, secondHalf);
}
}
```

[Solution]: <>