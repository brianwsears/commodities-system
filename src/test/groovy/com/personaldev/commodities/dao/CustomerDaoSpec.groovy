package com.personaldev.commodities.dao

import com.personaldev.commodities.BaseSpec
import com.personaldev.commodities.dao.customer.CustomerDao
import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.domain.exceptions.CustomerNotFoundException
import org.springframework.dao.IncorrectResultSizeDataAccessException
import org.springframework.jdbc.core.JdbcTemplate

class CustomerDaoSpec extends BaseSpec {

    CustomerDao dao

    def setup() {
        dao = new CustomerDao(
                jdbcTemplate: Mock(JdbcTemplate)
        )
    }

    def "getUserByEmail returns a Customer object"() {
        given:
            dao.jdbcTemplate.queryForObject(_,_,_) >> mockCustomer
        when:
            def response = dao.getCustomer(TEST_EMAIL)
        then:
            response instanceof Customer
    }

    def "getUserByEmail throws CustomerNotFoundException when database call throws IncorrectResultSizeDataAccessException"() {
        given:
            dao.jdbcTemplate.queryForObject(_,_,_) >> {throw new IncorrectResultSizeDataAccessException(0)}
        when:
            dao.getCustomer(TEST_EMAIL)
        then:
            thrown(CustomerNotFoundException)
    }

    def "getUserByEmail throws Exception when database calls throws Exception"() {
        given:
            dao.jdbcTemplate.queryForObject(_,_,_) >> {throw new Exception("Something went wrong.")}
        when:
            dao.getCustomer(TEST_EMAIL)
        then:
            thrown(Exception)
    }
}
