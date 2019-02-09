package com.personaldev.commodities.dao

import com.personaldev.commodities.domain.customer.CustomerAddress
import com.personaldev.commodities.domain.exceptions.AddressNotFoundException
import org.springframework.dao.IncorrectResultSizeDataAccessException
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.stereotype.Repository

@Repository
class CustomerAddressDao extends BaseDao {

    static final String SELECT_CUSTOMER_ADDRESS = """select * from address where customer_email = ?"""

    List<CustomerAddress> getCustomerAddressList(String customerEmail) {
        try {
            jdbcTemplate.query(SELECT_CUSTOMER_ADDRESS, new BeanPropertyRowMapper(CustomerAddress.class), customerEmail)
        } catch (IncorrectResultSizeDataAccessException e) {
            String errorMessage = "!!~ ERROR: No address records found for $customerEmail. ** Database Error Thrown: " + e.message
            throw new AddressNotFoundException(errorMessage, customerEmail)
        } catch (Exception e) {
            throw new Exception(e.message)
        }
    }
}
