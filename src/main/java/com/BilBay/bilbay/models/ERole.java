package com.BilBay.bilbay.models;

public enum ERole {
    PRIVATE("PRIVATE"),
    COMPANY("COMPANY"),
    ADMIN("ADMIN");

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
