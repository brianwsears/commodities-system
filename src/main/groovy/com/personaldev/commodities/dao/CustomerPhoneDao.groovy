package com.personaldev.commodities.dao

import com.personaldev.commodities.domain.customer.CustomerPhone
import com.personaldev.commodities.domain.exceptions.PhoneNotFoundException
import org.springframework.dao.IncorrectResultSizeDataAccessException
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.stereotype.Repository

@Repository
class CustomerPhoneDao extends BaseDao {

    static final String SELECT_CUSTOMER_PHONE_LIST = """select phone_number, type from phone where phone.customer_email = ?"""

    List<CustomerPhone> getCustomerPhoneList(String customerEmail) {
        try {
            jdbcTemplate.query(SELECT_CUSTOMER_PHONE_LIST, new BeanPropertyRowMapper(CustomerPhone.class), customerEmail)
        } catch (IncorrectResultSizeDataAccessException e) {
            String errorMessage = "!!~ ERROR: No phone records found for $customerEmail. ** Database Error Thrown: " + e.message
            throw new PhoneNotFoundException(errorMessage)
        } catch (Exception e) {
            throw new Exception(e.message)
        }
    }
}
