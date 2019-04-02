package nl.hva.ewa.config;

import javax.ejb.Stateless;

@javax.annotation.sql.DataSourceDefinition(
        name = "java:comp/env/jdbc/vodafoneziggo",
        className = "com.mysql.cj.jdbc.MysqlXADataSource",
        url = "jdbc:mysql://localhost:3306/vodafoneziggocreateDatabaseIfNotExist=true&serverTimezone=CET",
        user = "root",
        password = "root")
@Stateless
public class DataSourceDefinition {
}
