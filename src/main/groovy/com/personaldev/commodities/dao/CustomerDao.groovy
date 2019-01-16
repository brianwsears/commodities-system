package com.personaldev.commodities.dao

import com.personaldev.commodities.domain.customer.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.IncorrectResultSizeDataAccessException
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class CustomerDao {

    @Autowired
    JdbcTemplate jdbcTemplate

    static final String SELECT_USER_BY_EMAIL = """select * from customer where customer.customer_email = ?"""

    Customer getUserByEmail(String email) {
        try {
            jdbcTemplate.queryForObject(SELECT_USER_BY_EMAIL, new BeanPropertyRowMapper(Customer.class), email)
        } catch (IncorrectResultSizeDataAccessException e) {
            return null
        }
    }
}
