package com.personaldev.commodities.dao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate

class BaseDao {

    @Autowired
    JdbcTemplate jdbcTemplate

}
