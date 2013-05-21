package com.octo.red.newsql.services;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author Henri Tremblay
 */
@Component
@ManagedResource(objectName="bean:name=dataSource", description="DataSource information")
public class DataSourceMBean {

    @Autowired
    DataSource dataSource;

    @ManagedAttribute
    public long getMinEvictableIdleTimeMillis() {
        return ((BasicDataSource) dataSource).getMinEvictableIdleTimeMillis();
    }

    @ManagedAttribute
    public int getMinIdle() {
        return ((BasicDataSource) dataSource).getMinIdle();
    }

    @ManagedAttribute
    public int getMaxIdle() {
        return ((BasicDataSource) dataSource).getMaxIdle();
    }

    @ManagedAttribute
    public boolean getTestOnBorrow() {
        return ((BasicDataSource) dataSource).getTestOnBorrow();
    }

    @ManagedAttribute
    public String getValidationQuery() {
        return ((BasicDataSource) dataSource).getValidationQuery();
    }

    @ManagedAttribute
    public int getNumIdle() {
        return ((BasicDataSource) dataSource).getNumIdle();
    }

    @ManagedAttribute
    public long getTimeBetweenEvictionRunsMillis() {
        return ((BasicDataSource) dataSource).getTimeBetweenEvictionRunsMillis();
    }

    @ManagedAttribute
    public int getMaxActive() {
        return ((BasicDataSource) dataSource).getMaxActive();
    }

    @ManagedAttribute
    public int getMaxOpenPreparedStatements() {
        return ((BasicDataSource) dataSource).getMaxOpenPreparedStatements();
    }

    @ManagedAttribute
    public boolean getTestWhileIdle() {
        return ((BasicDataSource) dataSource).getTestWhileIdle();
    }

    @ManagedAttribute
    public String getDriverClassName() {
        return ((BasicDataSource) dataSource).getDriverClassName();
    }

    @ManagedAttribute
    public int getNumTestsPerEvictionRun() {
        return ((BasicDataSource) dataSource).getNumTestsPerEvictionRun();
    }

    @ManagedAttribute
    public int getInitialSize() {
        return ((BasicDataSource) dataSource).getInitialSize();
    }

    @ManagedAttribute
    public String getUrl() {
        return ((BasicDataSource) dataSource).getUrl();
    }

    @ManagedAttribute
    public boolean isPoolPreparedStatements() {
        return ((BasicDataSource) dataSource).isPoolPreparedStatements();
    }

    @ManagedAttribute
    public String getUsername() {
        return ((BasicDataSource) dataSource).getUsername();
    }

    @ManagedAttribute
    public int getNumActive() {
        return ((BasicDataSource) dataSource).getNumActive();
    }

    @ManagedAttribute
    public long getMaxWait() {
        return ((BasicDataSource) dataSource).getMaxWait();
    }

    @ManagedAttribute
    public boolean getTestOnReturn() {
        return ((BasicDataSource) dataSource).getTestOnReturn();
    }

    @ManagedAttribute
    public int getLoginTimeout() throws SQLException {
        return ((BasicDataSource) dataSource).getLoginTimeout();
    }
}
