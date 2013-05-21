package com.octo.red.newsql.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Henri Tremblay
 */
@Service
public class CacheManager {

    private Map<String, Map<Object, Object>> cacheList = new HashMap<String, Map<Object, Object>>();

    private AtomicLong hit = new AtomicLong(0);
    private AtomicLong success = new AtomicLong(0);

    @SuppressWarnings("unchecked")
    public synchronized <T> T getFromCache(String cacheKey, Object key) {
        hit.incrementAndGet();
        Map<Object, Object> cache = cacheList.get(cacheKey);
        if(cache == null) {
            return null;
        }
        Object o = cache.get(key);
        if(o != null) {
            success.incrementAndGet();
        }
        return (T) o;
    }

    public synchronized void addToCache(String cacheKey, Object key, Object value) {
        Map<Object, Object> cache = cacheList.get(cacheKey);
        if(cache == null) {
            cache = new IdentityHashMap<Object, Object>();
            cacheList.put(cacheKey, cache);
        }
        cache.put(key, value);
    }

    public long getHit() {
        return hit.get();
    }

    public long getSuccess() {
        return success.get();
    }

    public synchronized double getHitRatio() {
        return (double) success.get() / (double) hit.get();
    }

    public synchronized void clearStatistics() {
        hit.set(0);
        success.set(0);
    }
}
