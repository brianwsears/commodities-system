package com.personaldev.commodities.dao

import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.domain.exceptions.CustomerNotFoundException
import groovy.util.logging.Slf4j
import org.springframework.dao.IncorrectResultSizeDataAccessException
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.stereotype.Repository

@Slf4j
@Repository
class CustomerDao extends BaseDao {

    static final String SELECT_USER_BY_EMAIL = """select * from customer where customer.customer_email = ?"""

    Customer getUserByEmail(String email) {
        try {
            jdbcTemplate.queryForObject(SELECT_USER_BY_EMAIL, new BeanPropertyRowMapper(Customer.class), email)
        } catch (IncorrectResultSizeDataAccessException e) {
            log.error("Customer record not found for ${email}")
            throw new CustomerNotFoundException(e.message)
        } catch (Exception e) {
            log.error("-- CustomerDao: getUserByEmail($email). Exception message: $e.message")
            throw new Exception(e.message)
        }
    }
}
