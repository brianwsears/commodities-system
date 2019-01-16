package com.personaldev.commodities.dao

import com.personaldev.commodities.domain.customer.Phone
import com.personaldev.commodities.domain.exceptions.DaoSelectException
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.IncorrectResultSizeDataAccessException
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Slf4j
@Repository
class PhoneDao {

    @Autowired
    JdbcTemplate jdbcTemplate

    static final String SELECT_CUSTOMER_PHONE_LIST = """select * from phone where customer_email = ?"""

    List<Phone> getCustomerPhoneList(String customerEmail) {
        try {
            jdbcTemplate.queryForList(SELECT_CUSTOMER_PHONE_LIST, new BeanPropertyRowMapper(Phone.class), customerEmail)
        } catch (IncorrectResultSizeDataAccessException e) {
            return null
        } catch (Exception e) {
            //log.error("*** Error - PhoneDao.getCustomerPhoneList() - ${e.dump()}")
            throw new DaoSelectException(this.class.toString(), e.message)
        }
    }
}
