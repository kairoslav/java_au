# Intervals

- [Intervals](#intervals)
  - [Middle of the Linked List](#middle-of-the-linked-list)

[MDLink]: <>

## Middle of the Linked List

https://leetcode.com/problems/middle-of-the-linked-list/

```java
class Solution {
public static ListNode middleNode(ListNode fastNode) {
    ListNode slowNode = fastNode;
    while (fastNode != null && fastNode.next != null) {
        slowNode = slowNode.next;
        fastNode = fastNode.next.next;
    }
    return slowNode;
}
}
```

[Solution]: <>