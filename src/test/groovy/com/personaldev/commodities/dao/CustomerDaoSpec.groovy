package com.personaldev.commodities.dao

import com.personaldev.commodities.BaseSpec
import org.springframework.jdbc.core.JdbcTemplate

class CustomerDaoSpec extends BaseSpec {

    CustomerDao dao

    def setup() {
        dao = new CustomerDao(
                jdbcTemplate: Mock(JdbcTemplate)
        )
    }

    def "getUserByEmail returns a Customer object"() {

    }

    def "getUserByEmail returns null for IncorrectResultSizeDataAccessException"() {

    }
}
