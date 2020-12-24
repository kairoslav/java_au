# String

+ [Valid Palindrome](#valid-palindrome)

[MDLink]: <>

## Valid Palindrome

https://leetcode.com/problems/valid-palindrome/

```java
class Solution {
public boolean isPalindrome(String s) {
    String string_without_shit = "";
    for (int i = 0; i < s.length(); i++) {
        if ('a' <= s.charAt(i) && s.charAt(i) <= 'z' ||
            'A' <= s.charAt(i) && s.charAt(i) <= 'Z' || 
            '0' <= s.charAt(i) && s.charAt(i) <= '9') {
            string_without_shit += s.charAt(i);
        }
    }
    string  = string_without_shit.toLowerCase();
    for (int letter_pointer = 0; letter_pointer < string_without_shit.length() / 2; letter_pointer++) {
        if (string_without_shit.charAt(letter_pointer) != string_without_shit.charAt(string_without_shit.length() - letter_pointer - 1)) {
            return false;
        }
    }
    return true;
}
}
```

[Solution]: <>