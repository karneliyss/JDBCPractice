package com.machulin;

import com.machulin.model.Customer;
import com.machulin.service.CustomerRepository;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataBaseManager db = new DataBaseManager();
        CustomerRepository cr = new CustomerRepository(db);
        Customer customer = new Customer("Антон", "Мачулин",
                LocalDate.of(1996, 8, 16));
        db.initializeDatabase();
        cr.save(customer);
        Customer updateCr = new Customer("Петя", "Васин", LocalDate.of(1980, 5, 1));
        updateCr.setId(4L);
        cr.updateCustomer(updateCr);


        customer.setId(1L);
        cr.updateCustomer(customer);
        cr.printAllCustomers();
    }
}