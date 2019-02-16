package com.personaldev.commodities.domain.customer;

import java.util.Date;
import java.util.List;

public class Customer {

    private String customerEmail;
    private Date createDate;
    private String firstName;
    private String lastName;
    private String nickname;
    private int age;
    private String gender;
    private List<CustomerAddress> addressList;
    private List<CustomerPhone> phoneList;

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<CustomerAddress> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<CustomerAddress> addressList) {
        this.addressList = addressList;
    }

    public List<CustomerPhone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<CustomerPhone> phoneList) {
        this.phoneList = phoneList;
    }
}
