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

    static final String INSERT_USER = """insert into customer (customer_email, create_date, first_name, last_name, nickname, age, gender) values (?,?,?,?,?,?,?);"""


    Customer getCustomer(String customerEmail) throws Exception {
        try {
            jdbcTemplate.queryForObject(SELECT_USER_BY_EMAIL, new BeanPropertyRowMapper(Customer.class), customerEmail)
        } catch (IncorrectResultSizeDataAccessException e) {
            throw new CustomerNotFoundException(e.message, customerEmail)
        } catch (Exception e) {
            String detailedMessage = this.getClass().toString()  +
                    " - getCustomer($customerEmail}" +
                    " - CAUSE: ${e.dump()}"
            throw new Exception(detailedMessage)
        }
    }

    Customer insertCustomer(Customer customer) throws Exception {
        try {
            jdbcTemplate.update(INSERT_USER, customer.customerEmail, new Date(), customer.firstName, customer.lastName, customer.nickname, customer.age, customer.gender)
            return customer
        } catch (DataIntegrityViolationException e) {
            throw new CustomerAlreadyExistsException(errorMessage, customer.customerEmail)
        } catch (Exception e) {
            String detailedMessage = this.getClass().toString()  +
                    " - insertCustomer($customer.customerEmail}" +
                    " - CAUSE: ${e.dump()}"
            throw new Exception(detailedMessage)
        }
    }
}
