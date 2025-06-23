package com.machulin;

import com.machulin.sqlqueries.Query;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import javax.xml.transform.Source;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/JDBC";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    private final DataSource dataSource;

    public DataBaseManager() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        dataSource = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void initializeDatabase() throws SQLException {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(Query.CREATE_TABLE);
        }
    }












}

