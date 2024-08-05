package com.artemnizhnyk.restjakartapractice.config;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@DataSourceDefinition(
        name = "java:app/jdbc/appDataSource",
        className = "org.postgresql.ds.PGSimpleDataSource",
        url = "jdbc:postgresql://localhost:5437/task-list",
        user = "postgres",
        password = "postgres")
@Named
@ApplicationScoped
public class DBConfig {
}