package com.octo.red.newsql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * @author Henri Tremblay
 */
@Component
@ManagedResource(objectName="bean:name=cacheManager", description="Cache manager")
public class CacheManagerMBean {

    @Autowired
    CacheManager cacheManager;

    @ManagedAttribute(description="Total hit")
    public long getHit() {
        return cacheManager.getHit();
    }

    @ManagedAttribute(description="Hit success")
    public long getSuccess() {
        return cacheManager.getSuccess();
    }

    @ManagedAttribute(description="Hit ratio")
    public synchronized double getHitRatio() {
        return cacheManager.getHitRatio();
    }

    @ManagedOperation(description="Clean cache statistics")
    public synchronized void clearStatistics() {
        cacheManager.clearStatistics();
    }
}
