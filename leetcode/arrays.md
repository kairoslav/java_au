# Arrays

+ [Squares of a Sorted Array](#squares-of-a-sorted-array)

[MDLink]: <>

## Squares of a Sorted Array

https://leetcode.com/problems/squares-of-a-sorted-array/

```java
class Solution {
public int[] sortedSquares(int[] A) {
    return Arrays.stream(A)
        .map(x -> x * x)
        .sorted()
        .toArray();
}
}
```

[Solution]: <>