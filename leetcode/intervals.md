# Intervals

+ [Merge Intervals](#merge-intervals)

[MDLink]: <>

## Merge Intervals

https://leetcode.com/problems/merge-intervals/solution/

```java
class Solution {
public static int[][] merge(int[][] intervals) {
    if (intervals.length == 0 || intervals.length == 1) {
        return intervals;
    }
    Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
    int lastStart = intervals[0][0];
    int lastEnd = intervals[0][1];
    List<int[]> list = new LinkedList<>();
    for (int i = 1; i < intervals.length; i++) {
        int left = intervals[i][0];
        int right = intervals[i][1];
        if (lastStart == left && lastEnd <= right) {
            lastEnd = right;
        }
        else if (left <= lastEnd && lastEnd <= right) {
            lastEnd = right;
        }
        else if (lastEnd <= left) {
            list.add(new int[]{lastStart, lastEnd});
            lastStart = left;
            lastEnd = right;
        }
    }
    if (list.isEmpty() || list.get(list.size() - 1)[1] != lastEnd) {
        list.add(new int[] {lastStart, lastEnd});
    }
    return list.toArray(new int[0][0]);
}
}
```

[Solution]: <>