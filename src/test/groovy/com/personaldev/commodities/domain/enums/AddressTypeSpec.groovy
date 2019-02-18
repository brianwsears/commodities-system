package com.personaldev.commodities.domain.enums

import com.personaldev.commodities.BaseSpec

class AddressTypeSpec extends BaseSpec {

    def "AddressType.BUSINESS returns 'Business'"() {
        when:
            def response = AddressType.BUSINESS.toString()
        then:
            response == "Business"
    }

    def "AddressType.HOME returns 'Home'"() {
        when:
            def response = AddressType.HOME.toString()
        then:
            response == "Home"
    }

    def "AddressType.MAILING returns 'Mailing'"() {
        when:
            def response = AddressType.MAILING.toString()
        then:
            response == "Mailing"
    }
}
