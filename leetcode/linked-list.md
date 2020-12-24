# Intervals

- [Intervals](#intervals)
  - [Palindrome Linked List](#palindrome-linked-list)

[MDLink]: <>

## Palindrome Linked List

https://leetcode.com/problems/palindrome-linked-list/

```java
class Solution {
public static ListNode reverseList(ListNode head) {
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
public static boolean isPalindrome(ListNode head) {
    ListNode leftPointer = head;
    ListNode rightPointer = head;
    while (rightPointer != null && rightPointer.next != null) {
        rightPointer = rightPointer.next.next;
        leftPointer = leftPointer.next;
    }
    leftPointer = reverseList(leftPointer);
    while (leftPointer != null) {
        if (leftPointer.val != head.val) {
            return false;
        }
        leftPointer = leftPointer.next;
        head = head.next;
    }
    return true;
}
}
```

[Solution]: <>