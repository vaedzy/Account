package com.account.bean;

import java.io.Serializable;

public class Purse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private double money;
    private Long personId;

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }
}
