package com.callor.js.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyBatisConfig {

    // dataSource
    public DataSource getDataSource(){

        DataSource ds = new BasicDataSource();

        return ds;
    }
    // SQL SessionFactory

    // SQL SessionTemplate
}
