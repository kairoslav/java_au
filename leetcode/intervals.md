# Intervals

+ [Merge Two Sorted Lists](#merge-two-sorted-lists)

[MDLink]: <>

## Merge Two Sorted Lists

https://leetcode.com/problems/merge-two-sorted-lists/

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
}
```

[Solution]: <>