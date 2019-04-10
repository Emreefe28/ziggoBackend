package nl.hva.web.workshops.user.config;

import javax.ejb.Stateless;

@javax.annotation.sql.DataSourceDefinition(
        name = "java:comp/env/jdbc/userDb",
        className = "com.mysql.cj.jdbc.MysqlXADataSource",
        url = "jdbc:mysql://localhost:3306/ewa?createDatabaseIfNotExist=true&serverTimezone=CET",
        user = "root",
        password = "root")
@Stateless

// TODO: Make sure that you change the host and credentials to your environment
public class DataSourceDefinition {
}
