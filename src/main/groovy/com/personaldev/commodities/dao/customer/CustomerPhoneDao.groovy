package com.personaldev.commodities.dao.customer

import com.personaldev.commodities.dao.BaseDao
import com.personaldev.commodities.domain.customer.CustomerPhone
import com.personaldev.commodities.domain.exceptions.CustomerPhoneAlreadyExistsException
import org.springframework.dao.DuplicateKeyException
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.stereotype.Repository

@Repository
class CustomerPhoneDao extends BaseDao {

    static final String SELECT_CUSTOMER_PHONE_LIST = """select phone_number, type from phone where phone.customer_email = ?"""

    static final String INSERT_CUSTOMER_PHONE = """insert into phone (phone_number, type, customer_email) values (?,?,?);"""


    CustomerPhone insertCustomerPhone(String customerEmail, CustomerPhone customerPhone) throws Exception {
        try {
            jdbcTemplate.update(INSERT_CUSTOMER_PHONE, customerPhone.phoneNumber, customerPhone.type, customerEmail)
            return customerPhone
        } catch (DuplicateKeyException e) {
            throw new CustomerPhoneAlreadyExistsException(e.message, customerEmail, customerPhone)
        }
          catch (Exception e) {
            String detailedMessage = this.getClass().toString()  +
                    " - insertCustomerPhone(${customerPhone.phoneNumber}" +
                    " - CAUSE: ${e.dump()}"
          throw new Exception(detailedMessage)
        }
    }
    List<CustomerPhone> getCustomerPhoneList(String customerEmail) throws Exception {
        try {
            jdbcTemplate.query(SELECT_CUSTOMER_PHONE_LIST, new BeanPropertyRowMapper(CustomerPhone.class), customerEmail)
        } catch (Exception e) {
            String detailedMessage = this.getClass().toString()  +
                    " - getCustomerPhoneList($customerEmail}" +
                    " - CAUSE: ${e.dump()}"
            throw new Exception(detailedMessage)
        }
    }
}
