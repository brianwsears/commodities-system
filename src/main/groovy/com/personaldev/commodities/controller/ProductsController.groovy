package com.personaldev.commodities.controller

import com.personaldev.commodities.domain.products.BaseProduct
import com.personaldev.commodities.domain.products.Tobacco
import com.personaldev.commodities.service.products.ProductsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/commodities-service/v1/products")
class ProductsController implements AbstractRestController {

    @Autowired
    ProductsService productsService

    @GetMapping()
    List<BaseProduct> getAllProducts() {
        productsService.getAllProducts()
    }

    @GetMapping(path = "/{type}")
    List<BaseProduct> getAllProductsByType(@PathVariable(value = "type", required = true) String type) {
        productsService.getAllProductsByType(type)
    }

    @PostMapping(path = "/product")
    BaseProduct insertNewProduct(@RequestBody BaseProduct) {

    }
}
