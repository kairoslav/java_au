# String

+ [Longest Palindromic Substring](#longest-palindromic-substring)

[MDLink]: <>

## Longest Palindromic Substring

https://leetcode.com/problems/longest-palindromic-substring/

```java
public class Solution {
private String maxStr = "";

public String longestPalindrome(String s) {
    if (s == null || s.length() == 0)
        return "";

    for (int i = 0; i < s.length(); i++) { // i is the mid point
        expandAroundCenter(s, i, i); // odd length;
        expandAroundCenter(s, i, i + 1); // even length
    }

    return maxStr;
}

private void expandAroundCenter(String s, int left, int right) {

    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        if (maxStr.length() < s.substring(left, right + 1).length()) {
            maxStr = s.substring(left, right + 1);
        }
        left--;
        right++;
    }

}
}
```

[Solution]: <>