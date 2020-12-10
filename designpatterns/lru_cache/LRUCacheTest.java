package lru_cache;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LRUCacheTest {

    @Test
    public void intCache1() {
        //["LRUCache","put","put","get","put","get","put","get","get","get"]
        //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        LRUCache<Integer, Integer> cache = new LRUCache<>(2);
        cache.put(1, 1); // 1
        cache.put(2, 2); // 2 1
        assertEquals(1, (int) cache.get(1)); // 1 2 -> 1
        cache.put(3, 3); // 3 1
        assertNull(cache.get(2)); // 3 1 -> -1
        cache.put(4, 4); // 4 3
        assertNull(cache.get(1)); // 4 3 -> -1
        assertEquals(3, (int) cache.get(3)); // 3 4 -> 3
        assertEquals(4, (int) cache.get(4)); // 4 3 -> 4
        System.out.println();
    }

    @Test
    public void intCache2() {
        //["LRUCache","put","put","get","put","put","get"]
        //[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
        LRUCache<Integer, Integer> cache = new LRUCache<>(2);
        cache.put(2, 1); // 1
        cache.put(2, 2);
        assertEquals(2, (int) cache.get(2));
        cache.put(1, 1); // 1
        cache.put(4, 1);
        assertNull(cache.get(2));
    }

    @Test
    public void testCache3() {
        class Profile {
            final int age;
            final String name;

            public Profile(int age, String name) {
                this.age = age;
                this.name = name;
            }
        }

        class Music {
            final String genre;
            final int duration;

            public Music(String genre, int duration) {
                this.genre = genre;
                this.duration = duration;
            }
        }
        LRUCache<Profile, List<Music>> cache = new LRUCache<>(2);

        Profile user1 = new Profile(18, "Alex");
        Profile user2 = new Profile(20, "Jane");
        Profile user3 = new Profile(56, "Uri");
        List<Music> playlist1 = Arrays.asList(new Music("Rock", 120), new Music("Rap", 228));
        List<Music> playlist2 = Arrays.asList(new Music("Country", 132), new Music("Metal", 461));
        List<Music> playlist3 = Arrays.asList(new Music("Shanson", 123), new Music("Jazz", 127));

        cache.put(user1, playlist1);
        cache.put(user2, playlist2);
        cache.put(user3, playlist3);
        assertNull(cache.get(user1));
        assertEquals(playlist2, cache.get(user2));
    }
}