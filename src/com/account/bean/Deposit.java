package com.account.bean;

import java.io.Serializable;

public class Deposit implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long PersonId;
    private String pIsRegistered;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPersonId(Long personId) {
        PersonId = personId;
    }

    public Long getPersonId() {
        return PersonId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getpIsRegistered() {
        return pIsRegistered;
    }

    public void setpIsRegistered(String pIsRegistered) {
        this.pIsRegistered = pIsRegistered;
    }
}
