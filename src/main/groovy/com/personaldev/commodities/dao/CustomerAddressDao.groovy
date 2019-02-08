package com.personaldev.commodities.dao

import com.personaldev.commodities.domain.customer.CustomerAddress
import com.personaldev.commodities.domain.exceptions.AddressNotFoundException
import groovy.util.logging.Slf4j
import org.springframework.dao.IncorrectResultSizeDataAccessException
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.stereotype.Repository

@Slf4j
@Repository
class CustomerAddressDao extends BaseDao {

    static final String SELECT_CUSTOMER_ADDRESS = """select * from address where customer_email = ?"""

    List<CustomerAddress> getCustomerAddress(String email) {
        try {
            jdbcTemplate.query(SELECT_CUSTOMER_ADDRESS, new BeanPropertyRowMapper(CustomerAddress.class), email)
        } catch (IncorrectResultSizeDataAccessException e) {
            log.error("Address record not found for ${email}")
            throw new AddressNotFoundException(e.message)
        } catch (Exception e) {
            log.error("-- AddressDao: getCustomerAddress($email). Exception message: $e.message")
            throw new Exception(e.message)
        }
    }
}
