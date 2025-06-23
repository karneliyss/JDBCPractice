package com.machulin.sqlqueries;

public interface Query {
    String CREATE_TABLE = """
            CREATE TABLE IF NOT EXISTS customers (
            id SERIAL PRIMARY KEY,
            first_name VARCHAR(10),
            last_name VARCHAR(10),
            date_of_birth DATE)
            """;

    String INSERT_CUSTOMER = """
            INSERT INTO customers (first_name, last_name, date_of_birth) VALUES (?, ?, ?)
            """;

    String GET_ALL_CUSTOMERS = """
            SELECT * FROM customers
            """;

    String UPDATE_CUSTOMER = """
            UPDATE customers SET first_name = ?, last_name = ?, date_of_birth = ? WHERE id = ?
            """;
}
