# Linked-list

+ [Sort List](#sort-list)

[MDLink]: <>

## Sort List

https://leetcode.com/problems/sort-list/

```java
class Solution {
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode finalList = new ListNode(0);
    ListNode pointer = finalList;
    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
            pointer.next = l1;
            l1 = l1.next;
        }
        else {
            pointer.next = l2;
            l2 = l2.next;
        }
        pointer = pointer.next;
    }

    if (l1 != null) {
        pointer.next = l1;
    }
    if (l2 != null) {
        pointer.next = l2;
    }
    return finalList.next;
}

ListNode middleNode(ListNode head) {
    ListNode midPrev = null;
    while (head != null && head.next != null) {
        midPrev = (midPrev == null) ? head : midPrev.next;
        head = head.next.next;
    }
    ListNode mid = midPrev.next;
    midPrev.next = null;
    return mid;
}

public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode secondHalf = sortList(middleNode(head));
    ListNode firstHalf = sortList(head);
    return mergeTwoLists(firstHalf, secondHalf);
}
}
```

[Solution]: <>