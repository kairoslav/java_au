# Intervals

- [Intervals](#intervals)
  - [Reverse Linked List](#reverse-linked-list)

[MDLink]: <>

## Reverse Linked List

https://leetcode.com/problems/reverse-linked-list/

```java
public class Solution {
public ListNode reverseList(ListNode head) {
ListNode prev = null;
ListNode curr = head;
while (curr != null) {
    ListNode nextTemp = curr.next;
    curr.next = prev;
    prev = curr;
    curr = nextTemp;
}
return prev;
}
}
```

[Solution]: <>