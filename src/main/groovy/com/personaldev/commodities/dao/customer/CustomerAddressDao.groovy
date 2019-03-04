package com.personaldev.commodities.dao.customer

import com.personaldev.commodities.dao.BaseDao
import com.personaldev.commodities.domain.customer.CustomerAddress
import com.personaldev.commodities.domain.exceptions.CustomerAddressAlreadyExistsException
import org.springframework.dao.DuplicateKeyException
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.stereotype.Repository

@Repository
class CustomerAddressDao extends BaseDao {

    static final String SELECT_CUSTOMER_ADDRESS = """select * from address where customer_email = ?;"""

    static final String INSERT_CUSTOMER_ADDRESS = """insert into address (
                                                        street_address1, street_address2, street_address3, city, state, zip_code, customer_email, type, mailing_address)
                                                        values(?,?,?,?,?,?,?,?,?);"""

    static final String DELETE_CUSTOMER_ADDRESS = """delete from address where id = ?"""

    int deleteCustomerAddress(int addressRecordId) throws Exception {
        try {
            jdbcTemplate.update(DELETE_CUSTOMER_ADDRESS, addressRecordId)
        }
        catch (Exception e) {
            String detailedMessage = this.getClass().toString()  +
                    " - insertCustomerAddress($customerEmail}" +
                    " - CAUSE: ${e.dump()}"
            throw new Exception(detailedMessage)
        }
    }

    CustomerAddress insertCustomerAddress(String customerEmail, CustomerAddress customerAddress) throws Exception {
        try {
            jdbcTemplate.update(INSERT_CUSTOMER_ADDRESS, customerAddress.streetAddress1, customerAddress.streetAddress2, customerAddress.streetAddress3,
                customerAddress.city, customerAddress.state, customerAddress.zipCode, customerEmail, customerAddress.type, customerAddress.mailingAddress)
            return customerAddress
        }
        catch (DuplicateKeyException e) {
            throw new CustomerAddressAlreadyExistsException(e.message, customerEmail, customerAddress)
        }
        catch (Exception e) {
            String detailedMessage = this.getClass().toString()  +
                    " - insertCustomerAddress($customerEmail}" +
                    " - CAUSE: ${e.dump()}"
            throw new Exception(detailedMessage)
        }
    }

    List<CustomerAddress> getCustomerAddressList(String customerEmail) throws Exception {
        try {
            jdbcTemplate.query(SELECT_CUSTOMER_ADDRESS, new BeanPropertyRowMapper(CustomerAddress.class), customerEmail)
        }
        catch (Exception e) {
            String detailedMessage = this.getClass().toString()  +
                    " - getCustomerAddressList($customerEmail}" +
                    " - CAUSE: ${e.dump()}"
            throw new Exception(detailedMessage)
        }
    }
}
