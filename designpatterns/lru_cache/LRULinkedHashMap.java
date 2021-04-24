package lru_cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMap<KEY, VAL> {
    private final Map<KEY, VAL> cache;
    private final int capacity;

    public LRULinkedHashMap( int capacity) {
        this.cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public VAL get(KEY key) {
        if (cache.containsKey(key)) {
            VAL val = cache.get(key);
            cache.remove(key);
            cache.put(key, val);
            return cache.get(key);
        }
        return null;
    }

    public void put(KEY key, VAL val) {
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
                Map.Entry<KEY, VAL> head = cache.entrySet().iterator().next();
                cache.remove(head.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}
