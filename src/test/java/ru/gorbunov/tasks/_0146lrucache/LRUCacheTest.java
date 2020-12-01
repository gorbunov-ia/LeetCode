package ru.gorbunov.tasks._0146lrucache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LRUCacheTest {

    @Test
    void example1() {
        LRUCache cache = new LRUCache(2);
//        LRUCacheOrigin cache = new LRUCacheOrigin(2);

        cache.put(1, 1); // cache is {1=1}
        cache.put(2, 2); // cache is {1=1, 2=2}
        Assertions.assertEquals(1, cache.get(1));

        cache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        Assertions.assertEquals(-1, cache.get(2));

        cache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        Assertions.assertEquals(-1, cache.get(1));
        Assertions.assertEquals(3, cache.get(3));
        Assertions.assertEquals(4, cache.get(4));
    }
}