package com.personaldev.commodities.domain.enums

import com.personaldev.commodities.BaseSpec

class PhoneTypeSpec extends BaseSpec {

    def "PhoneType.HOME returns 'H'"() {
        when:
            def response = PhoneType.HOME.toString()
        then:
            response == "H"
    }

    def "PhoneType.MOBILE returns 'M'"() {
        when:
            def response = PhoneType.MOBILE.toString()
        then:
        response == "M"
    }

    def "PhoneType.WORK returns 'W'"() {
        when:
            def response = PhoneType.WORK.toString()
        then:
            response == "W"
    }
}
