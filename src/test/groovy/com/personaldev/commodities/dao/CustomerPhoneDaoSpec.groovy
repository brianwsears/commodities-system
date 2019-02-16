package com.personaldev.commodities.dao

import com.personaldev.commodities.BaseSpec
import com.personaldev.commodities.domain.customer.CustomerAddress
import com.personaldev.commodities.domain.customer.CustomerPhone
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

    def "getCustomerPhoneList returns an empty list when no phone records are found"() {
        given:
            List<CustomerPhone> emptyList = new ArrayList<>()
            dao.jdbcTemplate.query(_,_,_) >> emptyList
        when:
            List<CustomerAddress> customerPhoneList = dao.getCustomerPhoneList(TEST_EMAIL)
        then:
            noExceptionThrown()
            customerPhoneList.size() == 0
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
