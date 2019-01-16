package com.personaldev.commodities

import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.domain.customer.CustomerAddress
import com.personaldev.commodities.domain.customer.Phone
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
                addressList: buildCustomerAddressList()
        )
    }

    static final CustomerAddress buildCustomerAddress(int id) {
        return new CustomerAddress(
                addressId: id,
                customerAddressId: 2002,
                streetAddressLine1: "104 Pickles Drive",
                streetAddressLine2: "Floor 99",
                streetAddressLine3: "Suite 100",
                city: "Columbia",
                state: "MO",
                zipCode: "65201"
        )
    }

    static final List<CustomerAddress> buildCustomerAddressList() {
        List<CustomerAddress> customerAddressList = new ArrayList<>()

        customerAddressList << buildCustomerAddress(1001)
        customerAddressList << buildCustomerAddress(1002)

         customerAddressList
    }

    static final Phone buildPhone() {
        return new Phone(
                phoneNumber: 5732218874,
                type: PhoneType.WORK.toString(),
                customerEmail: "picklesmcgee@gmail.com"
        )
    }
}
