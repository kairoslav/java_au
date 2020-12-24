# Intervals

+ [Intersection of Two Linked Lists](#intersection-of-two-linked-lists)

[MDLink]: <>

## Intersection of Two Linked Lists

https://leetcode.com/problems/intersection-of-two-linked-lists/

```java
public class Solution {
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode pointerA = headA;
    ListNode pointerB = headB;
    while (pointerA != null && pointerB != null) {
        if (pointerA == pointerB) return pointerA;
        pointerA = pointerA.next;
        pointerB = pointerB.next;
    }
    if (pointerA == null) {
        while (pointerB != null) {
            pointerB = pointerB.next;
            headB = headB.next;
        }
    }
    if (pointerB == null) {
        while (pointerA != null) {
            pointerA = pointerA.next;
            headA = headA.next;
        }
    }
    while (headA != headB) {
        headA = headA.next;
        headB = headB.next;
    }
    return headA;
}
}
```

[Solution]: <>