package com.personaldev.commodities

import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.domain.customer.CustomerAddress
import com.personaldev.commodities.domain.customer.CustomerPhone
import com.personaldev.commodities.domain.enums.PhoneType

class MockBuilder {

    static final Customer buildCustomer() {
        return new Customer(
                customerEmail: "testCustomer@gmail.com",
                firstName: "Timmy",
                lastName: "Woot",
                nickname: "The Legend",
                age: 34,
                gender: "Male",
                addressList: buildCustomerAddressList(),
                phoneList: buildCustomerPhoneList()
        )
    }

    static final CustomerAddress buildCustomerAddress(int id) {
        return new CustomerAddress(
                streetAddress1: "104 Pickles Drive",
                streetAddress2: "Floor 99",
                streetAddress3: "Suite 100",
                city: "Columbia",
                state: "MO",
                zipCode: "65201",
                type: "Home",
                mailingAddress: 0
        )
    }

    static final CustomerPhone buildCustomerPhone(long phoneNumber, String type) {
        return new CustomerPhone(
                phoneNumber: phoneNumber,
                type: type
        )
    }

    static final List<CustomerAddress> buildCustomerAddressList() {
        List<CustomerAddress> customerAddressList = new ArrayList<>()

        customerAddressList << buildCustomerAddress(1001)
        customerAddressList << buildCustomerAddress(1002)

        customerAddressList
    }

    static final List<CustomerPhone> buildCustomerPhoneList() {
        List<CustomerPhone> customerPhoneList = new ArrayList<>()

        customerPhoneList << buildCustomerPhone(5731234456, PhoneType.HOME.toString())
        customerPhoneList << buildCustomerPhone(8864932223, PhoneType.WORK.toString())

        customerPhoneList
    }
}
