package com.octo.red.newsql.services;

import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * @author Henri Tremblay
 */
public class CacheManagerTest {

    private static final String KEY = "key";

    private CacheManager cm = new CacheManager();

    @Test
    public void testCache() throws Exception {
        assertNull(cm.getFromCache(KEY, "nil"));
        cm.addToCache(KEY, "a", "b");
        assertNull(cm.getFromCache(KEY, "nil"));
        assertEquals("b", cm.getFromCache(KEY, "a"));
    }
}
