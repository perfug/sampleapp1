package com.octo.red.newsql.services;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author Henri Tremblay
 */
@Component
@ManagedResource(objectName="bean:name=dataSource", description="DataSource information")
public class DataSourceMBean {

    @Autowired
    BasicDataSource dataSource;

    @ManagedAttribute
    public long getMinEvictableIdleTimeMillis() {
        return dataSource.getMinEvictableIdleTimeMillis();
    }

    @ManagedAttribute
    public int getMinIdle() {
        return dataSource.getMinIdle();
    }

    @ManagedAttribute
    public int getMaxIdle() {
        return dataSource.getMaxIdle();
    }

    @ManagedAttribute
    public boolean getTestOnBorrow() {
        return dataSource.getTestOnBorrow();
    }

    @ManagedAttribute
    public String getValidationQuery() {
        return dataSource.getValidationQuery();
    }

    @ManagedAttribute
    public int getNumIdle() {
        return dataSource.getNumIdle();
    }

    @ManagedAttribute
    public long getTimeBetweenEvictionRunsMillis() {
        return dataSource.getTimeBetweenEvictionRunsMillis();
    }

    @ManagedAttribute
    public int getMaxActive() {
        return dataSource.getMaxActive();
    }

    @ManagedAttribute
    public int getMaxOpenPreparedStatements() {
        return dataSource.getMaxOpenPreparedStatements();
    }

    @ManagedAttribute
    public boolean getTestWhileIdle() {
        return dataSource.getTestWhileIdle();
    }

    @ManagedAttribute
    public String getDriverClassName() {
        return dataSource.getDriverClassName();
    }

    @ManagedAttribute
    public int getNumTestsPerEvictionRun() {
        return dataSource.getNumTestsPerEvictionRun();
    }

    @ManagedAttribute
    public int getInitialSize() {
        return dataSource.getInitialSize();
    }

    @ManagedAttribute
    public String getUrl() {
        return dataSource.getUrl();
    }

    @ManagedAttribute
    public boolean isPoolPreparedStatements() {
        return dataSource.isPoolPreparedStatements();
    }

    @ManagedAttribute
    public String getUsername() {
        return dataSource.getUsername();
    }

    @ManagedAttribute
    public int getNumActive() {
        return dataSource.getNumActive();
    }

    @ManagedAttribute
    public long getMaxWait() {
        return dataSource.getMaxWait();
    }

    @ManagedAttribute
    public boolean getTestOnReturn() {
        return dataSource.getTestOnReturn();
    }

    @ManagedAttribute
    public int getLoginTimeout() throws SQLException {
        return dataSource.getLoginTimeout();
    }
}
