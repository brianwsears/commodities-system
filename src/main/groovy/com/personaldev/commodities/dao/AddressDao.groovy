package com.personaldev.commodities.dao

import com.personaldev.commodities.domain.customer.CustomerAddress
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.IncorrectResultSizeDataAccessException
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class AddressDao {

    @Autowired
    JdbcTemplate jdbcTemplate

    static final String SELECT_CUSTOMER_ADDRESS = """
        select * from address where customer_address_id"""

    CustomerAddress getCustomerAddress(String customerAddressId) {
        try {
            jdbcTemplate.queryForList(SELECT_CUSTOMER_ADDRESS, new BeanPropertyRowMapper(CustomerAddress.class), customerAddressId)
        } catch (IncorrectResultSizeDataAccessException e) {
            return null
        }
    }
}
