package com.personaldev.commodities.dao.products

import com.personaldev.commodities.dao.BaseDao
import com.personaldev.commodities.domain.products.BaseProduct
import com.personaldev.commodities.domain.products.Tobacco
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.stereotype.Repository

@Repository
class ProductsDao extends BaseDao {

    static final String SELECT_ALL_PRODUCTS = """select * from products"""
    static final String SELECT_ALL_PRODUCTS_BY_TYPE = """select * from products where type = ?"""

    List<BaseProduct> getAllProducts() throws Exception {
        try {
            jdbcTemplate.query(SELECT_ALL_PRODUCTS, new BeanPropertyRowMapper(BaseProduct.class))
        } catch (Exception e) {
            String detailedMessage = this.getClass().toString()  +
                " - getAllProducts()" +
                " - CAUSE: ${e.dump()}"
            throw new Exception(detailedMessage)
        }
    }

    List<Tobacco> getAllProductsByType(String type) {
        try {
            jdbcTemplate.query(SELECT_ALL_PRODUCTS_BY_TYPE, new BeanPropertyRowMapper(BaseProduct.class), type)
        } catch (Exception e) {
            String detailedMessage = this.getClass().toString()  +
                    " - getAllProductsByType(${type})" +
                    " - CAUSE: ${e.dump()}"
            throw new Exception(detailedMessage)
        }
    }
}
