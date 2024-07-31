package com.artemnizhnyk.restjakartapractice.config;

import jakarta.annotation.Resource;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;

import javax.sql.DataSource;

//@DataSourceDefinition(
//        name = "java:app/jdbc/appDataSource",
//        className = "org.postgresql.ds.PGSimpleDataSource",
//        url = "jdbc:postgresql://localhost:5437/task-list",
//        user = "postgres",
//        password = "postgres",
//        properties = {
//                "driverClassName=org.postgresql.Driver"
//        }
//)
////@ApplicationScoped
////@Named
//@Singleton
public class DataSourceConfiguration {

//        @Resource(lookup = "java:app/jdbc/appDataSource")
//        DataSource dataSource;
//
//        @Produces
//        public DataSource getDatasource() {
//                return dataSource;
//        }
}