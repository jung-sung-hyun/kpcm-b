package kp.cmsc.common.config;

import org.springframework.stereotype.Service;

@Service
public class DataSourceService {

    private final DataSourceProperties dataSourceProperties;

    public DataSourceService(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    public void printDataSourceProperties() {
        System.out.println("URL: " + dataSourceProperties.getUrl());
        System.out.println("Username: " + dataSourceProperties.getUsername());
        System.out.println("Password: " + dataSourceProperties.getPassword());
        System.out.println("Driver Class Name: " + dataSourceProperties.getDriverClassName());
    }
}