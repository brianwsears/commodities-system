package com.personaldev.commodities.domain.enums

import com.personaldev.commodities.BaseSpec

class ProductTypeSpec extends BaseSpec {

    def "ProductType.COFFEE returns 'Coffee'"() {
        when:
            def response = ProductType.COFFEE.toString()
        then:
            response == "Coffee"
    }

    def "ProductType.TOBACCO returns 'Tobacco'"() {
        when:
            def response = ProductType.TOBACCO.toString()
        then:
            response == "Tobacco"
    }
}
