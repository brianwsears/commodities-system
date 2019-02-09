package com.personaldev.commodities.dao

import com.personaldev.commodities.domain.customer.CustomerAddress
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.IncorrectResultSizeDataAccessException
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.stereotype.Repository

@Repository
class CustomerAddressDao extends BaseDao {

    static final String SELECT_CUSTOMER_ADDRESS = """select * from address where customer_email = ?;"""

    static final String SELECT_CUSTOMER_ADDRESS_BY_TYPE = """select * from address where customer_email = ? and type = ?;"""

    static final String INSERT_CUSTOMER_ADDRESS = """insert into address (
                                                        street_address1, street_address2, street_address3, city, state, zip_code, customer_email, type, mailing_address)
                                                        values(?,?,?,?,?,?,?,?,?);"""

    CustomerAddress insertCustomerAddress(String customerEmail, CustomerAddress customerAddress) {
        try {
            jdbcTemplate.update(INSERT_CUSTOMER_ADDRESS, customerAddress.streetAddress1, customerAddress.streetAddress2, customerAddress.streetAddress3,
                customerAddress.city, customerAddress.state, customerAddress.zipCode, customerEmail, customerAddress.type, customerAddress.mailingAddress)
            return customerAddress
        } catch (Exception e) {
            throw new Exception(e.message)
        }
    }

    List<CustomerAddress> getCustomerAddressList(String customerEmail) {
        try {
            jdbcTemplate.query(SELECT_CUSTOMER_ADDRESS, new BeanPropertyRowMapper(CustomerAddress.class), customerEmail)
        } catch (Exception e) {
            throw new Exception(e.message)
        }
    }

    CustomerAddress getCustomerAddressByType(String customerEmail, String type) {
        try {
            jdbcTemplate.queryForObject(SELECT_CUSTOMER_ADDRESS_BY_TYPE, new BeanPropertyRowMapper(CustomerAddress.class), customerEmail, type)
        } catch(IncorrectResultSizeDataAccessException e) {
            return null
        }
        catch (Exception e) {
            throw new Exception(e.message)
        }
    }
}
