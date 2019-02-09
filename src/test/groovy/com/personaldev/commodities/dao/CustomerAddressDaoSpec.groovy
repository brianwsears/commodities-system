package com.personaldev.commodities.dao

import com.personaldev.commodities.BaseSpec
import com.personaldev.commodities.domain.customer.CustomerAddress
import com.personaldev.commodities.domain.exceptions.AddressNotFoundException
import org.springframework.dao.IncorrectResultSizeDataAccessException
import org.springframework.jdbc.core.JdbcTemplate

class CustomerAddressDaoSpec extends BaseSpec {

    CustomerAddressDao dao

    def setup() {
        dao = new CustomerAddressDao(
                jdbcTemplate: Mock(JdbcTemplate)
        )
    }

    def "getCustomerAddressList returns a List of CustomerAddress objects"() {
        given:
            dao.jdbcTemplate.query(_,_,_) >> mockCustomerAddressList
        when:
            def response = dao.getCustomerAddressList(TEST_EMAIL)
        then:
            response instanceof List<CustomerAddress>
    }

    def "getCustomerAddressList returns an empty list when no address records are found"() {
        given:
            List<CustomerAddress> emptyList = new ArrayList<>()
            dao.jdbcTemplate.query(_,_,_) >> emptyList
        when:
            List<CustomerAddress> customerAddressList = dao.getCustomerAddressList(TEST_EMAIL)
        then:
            noExceptionThrown()
            customerAddressList.size() == 0
    }

    def "getCustomerAddressList throws Exception when database call throws Exception"() {
        given:
            dao.jdbcTemplate.query(_,_,_) >> {throw new Exception("Something went wrong.")}
        when:
            dao.getCustomerAddressList(TEST_EMAIL)
        then:
            thrown(Exception)
    }
}
