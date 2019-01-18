package com.personaldev.commodities.dao

import com.personaldev.commodities.BaseSpec
import com.personaldev.commodities.domain.customer.CustomerPhone
import com.personaldev.commodities.domain.exceptions.PhoneNotFoundException
import org.springframework.dao.IncorrectResultSizeDataAccessException
import org.springframework.jdbc.core.JdbcTemplate

class CustomerPhoneDaoSpec extends BaseSpec {

    CustomerPhoneDao dao

    def setup() {
        dao = new CustomerPhoneDao(
                jdbcTemplate: Mock(JdbcTemplate)
        )
    }

    def "getCustomerPhoneList returns a List of Phone objects"() {
        given:
            dao.jdbcTemplate.query(_,_,_) >> mockCustomerPhoneList
        when:
            def response = dao.getCustomerPhoneList("testemail@gmail.com")
        then:
            response instanceof List<CustomerPhone>
    }

    def "getCustomerPhoneList throws PhoneNotFoundException when database call throws IncorrectResultSizeDataAccessException"() {
        given:
            dao.jdbcTemplate.query(_,_,_) >> {throw new IncorrectResultSizeDataAccessException(0)}
        when:
            dao.getCustomerPhoneList("testemail@gmail.com")
        then:
            thrown(PhoneNotFoundException)
    }

    def "getCustomerPhoneList throws Exception when database call throws Exception"() {
        given:
            dao.jdbcTemplate.query(_,_,_) >> {throw new Exception("Something went wrong.")}
        when:
            dao.getCustomerPhoneList("testemail@gmail.com")
        then:
            thrown(Exception)
    }
}
