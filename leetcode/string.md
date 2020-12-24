# String

+ [Group Anagrams](#group-anagrams)

[MDLink]: <>

## Group Anagrams

https://leetcode.com/problems/group-anagrams/

```java
class Solution {
public static int countCharInWord(char letter, String word) {
    int count = 0;
    for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) == letter) {
            count++;
        }
    }
    return count;
}

public static boolean isAnagram(String word1, String word2) {
    int count = 0;
    if (word1.length() == word2.length()) {
        for (int i = 0; i < word1.length(); i++) {
            if (countCharInWord(word1.charAt(i), word2) != countCharInWord(word1.charAt(i), word1)) {
                return false;
            }
        }
        return true;
    }
    else {
        return false;
    }
}
public static List<List<String>> groupAnagrams(String[] strs) {
    Set<List<String>> result = new HashSet<List<String>>();
    for (String str : strs) {
        List<String> group_of_anagrams = new LinkedList<String>();
        for (String s : strs) {
            if (isAnagram(str, s)) {
                group_of_anagrams.add(s);
            }
        }
        result.add(group_of_anagrams);
    }
    return List.copyOf(result);
}
}
```

[Solution]: <>