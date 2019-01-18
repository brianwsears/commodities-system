package com.personaldev.commodities.dao

import com.personaldev.commodities.domain.customer.CustomerPhone
import com.personaldev.commodities.domain.exceptions.PhoneNotFoundException
import groovy.util.logging.Slf4j
import org.springframework.dao.IncorrectResultSizeDataAccessException
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.stereotype.Repository

@Slf4j
@Repository
class CustomerPhoneDao extends BaseDao {

    static final String SELECT_CUSTOMER_PHONE_LIST = """select * from phone where phone.customer_email = ?"""

    List<CustomerPhone> getCustomerPhoneList(String email) {
        try {
            jdbcTemplate.query(SELECT_CUSTOMER_PHONE_LIST, new BeanPropertyRowMapper(CustomerPhone.class), email)
        } catch (IncorrectResultSizeDataAccessException e) {
            log.error("CustomerPhone record not found for ${email}")
            throw new PhoneNotFoundException(e.message)
        } catch (Exception e) {
            log.error("-- PhoneDao: getCustomerPhoneList($email). Exception message: $e.message")
            throw new Exception(e.message)
        }
    }
}
