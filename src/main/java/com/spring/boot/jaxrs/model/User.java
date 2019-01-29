package com.spring.boot.jaxrs.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

    private String name;
    private String address;
    private Long contactNo;
    private String emailId;

    public User() {
    }

    public User(String name, String address, Long contactNo, String emailId) {
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getContactNo() {
        return contactNo;
    }

    public void setContactNo(Long contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNo=" + contactNo +
                ", emailId='" + emailId + '\'' +
                '}';
    }


}
