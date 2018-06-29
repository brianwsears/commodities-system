package com.personaldev.commodities.domain.enums

import com.personaldev.commodities.BaseSpec

class PhoneTypeSpec extends BaseSpec {

    def "PhoneType.HOME returns 'HOME'"() {
        when:
            def response = PhoneType.HOME.toString()
        then:
            response == "HOME"
    }

    def "PhoneType.HOME returns 'MOBILE'"() {
        when:
        def response = PhoneType.MOBILE.toString()
        then:
        response == "MOBILE"
    }

    def "PhoneType.HOME returns 'WORK'"() {
        when:
        def response = PhoneType.WORK.toString()
        then:
        response == "WORK"
    }
}
