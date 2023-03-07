package com.BilBay.bilbay.models;

public enum ERole {
    ROLE_PRIVATE("PRIVATE"),
    ROLE_COMPANY("COMPANY"),
    ROLE_ADMIN("ADMIN");

    private String value;

    ERole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
