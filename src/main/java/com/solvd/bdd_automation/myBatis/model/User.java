package com.solvd.bdd_automation.myBatis.model;

import java.util.List;

public class User {

    private Long id;

    private String name;

    private String surname;

    private String postalCode;

    private List<UserOrderItem> userOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public List<UserOrderItem> getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(List<UserOrderItem> userOrder) {
        this.userOrder = userOrder;
    }
}
