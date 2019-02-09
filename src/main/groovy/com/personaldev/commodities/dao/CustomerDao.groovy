package com.personaldev.commodities.dao

import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.domain.exceptions.CustomerAlreadyExistsException
import com.personaldev.commodities.domain.exceptions.CustomerNotFoundException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.IncorrectResultSizeDataAccessException
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.stereotype.Repository

@Repository
class CustomerDao extends BaseDao {

    static final String SELECT_USER_BY_EMAIL = """select * from customer where customer.customer_email = ?"""

    static final String INSERT_USER = """insert into customer (customer_email, first_name, last_name, nickname, age, gender) values (?,?,?,?,?,?);"""

    Customer getUserByEmail(String customerEmail) {
        try {
            jdbcTemplate.queryForObject(SELECT_USER_BY_EMAIL, new BeanPropertyRowMapper(Customer.class), customerEmail)
        } catch (IncorrectResultSizeDataAccessException e) {
            String errorMessage = "!!~ ERROR: $customerEmail not found. ** Database Error Thrown: " + e.message
            throw new CustomerNotFoundException(errorMessage, customerEmail)
        } catch (Exception e) {
            throw new Exception(e.message)
        }
    }

    Customer insertCustomer(Customer customer) {
        try {
            jdbcTemplate.update(INSERT_USER, customer.customerEmail, customer.firstName, customer.lastName, customer.nickname, customer.age, customer.gender)
            return customer
        } catch (DataIntegrityViolationException e) {
            String errorMessage = "!!~ ERROR: $customer.customerEmail already exists in the database. ** Database Error Thrown: " + e.message
            throw new CustomerAlreadyExistsException(errorMessage, customer.customerEmail)
        } catch (Exception e) {
            throw new Exception(e.message)
        }
    }
}
