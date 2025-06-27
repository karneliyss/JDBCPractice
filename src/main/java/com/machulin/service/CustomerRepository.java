package com.machulin.service;

import com.machulin.DataBaseManager;
import com.machulin.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.machulin.sqlqueries.Query.*;

public class CustomerRepository {
    private final DataBaseManager db;

    public CustomerRepository(DataBaseManager db) {
        this.db = db;
    }

    public void save(Customer customer) throws SQLException {
        try (Connection connection = db.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_CUSTOMER)) {
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setDate(3, Date.valueOf(customer.getBirthDate()));
            ps.executeUpdate();
        }
    }

    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = db.getConnection();
             PreparedStatement ps = connection.prepareStatement(GET_ALL_CUSTOMERS);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                customers.add(new Customer(rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDate("date_of_birth").toLocalDate()
                ));
            }
        }
        return customers;
    }

    public void updateCustomer(Customer customer) throws SQLException {
        try (Connection connection = db.getConnection();
        PreparedStatement ps = connection.prepareStatement(UPDATE_CUSTOMER)) {

            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setDate(3, Date.valueOf(customer.getBirthDate()));
            ps.setLong(4, customer.getId());
            ps.executeUpdate();
        }
    }


}
