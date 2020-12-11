# Design

+ [LRU Cache](#lru-cache)

[MDLink]: <>

## LRU Cache

https://leetcode.com/problems/lru-cache/

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
private final Map<Integer, Integer> cache;
private final int capacity;

public LRUCache( int capacity) {
    this.cache = new LinkedHashMap<>();
    this.capacity = capacity;
}

public int get(int key) {
    if (cache.containsKey(key)) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
        return cache.get(key);
    }
    return -1;
}

public void put(int key, int val) {
    if (cache.containsKey(key)) {
        cache.remove(key);
        cache.put(key, val);
    }
    else {
        if (cache.size() < capacity) {
            cache.put(key, val);
        }
        else {
            cache.put(key, val);
            Map.Entry<Integer, Integer> head = cache.entrySet().iterator().next();
            cache.remove(head.getKey());
        }
    }
}
}

```

[Solution]: <>