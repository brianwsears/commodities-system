package com.personaldev.commodities.dao

import com.personaldev.commodities.BaseSpec
import com.personaldev.commodities.domain.customer.Customer
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
            def response = dao.getUserByEmail("testemail@gmail.com")
        then:
            response instanceof Customer
    }

    def "getUserByEmail returns null for IncorrectResultSizeDataAccessException"() {
        given:
            dao.jdbcTemplate.queryForObject(_,_,_) >> {throw new IncorrectResultSizeDataAccessException(0)}
        when:
            def response = dao.getUserByEmail("testemail@gmail.com")
        then:
            !response
    }
}
