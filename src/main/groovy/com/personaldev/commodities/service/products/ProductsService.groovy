package com.personaldev.commodities.service.products

import com.personaldev.commodities.dao.products.ProductsDao
import com.personaldev.commodities.domain.products.BaseProduct
import com.personaldev.commodities.domain.products.Tobacco
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductsService {

    @Autowired
    ProductsDao productsDao

    List<BaseProduct> getAllProducts() {
        productsDao.getAllProducts()
    }

    List<BaseProduct> getAllProductsByType(String type) {
        productsDao.getAllProductsByType(type)
    }

    Tobacco insertNewTobaccoProduct(Tobacco tobacco) {
        // 1. Do existence check first.

    }
}
