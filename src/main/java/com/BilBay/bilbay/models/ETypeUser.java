package com.BilBay.bilbay.models;

public enum ETypeUser {
    PRIVATE("PRIVATE"),
    COMPANY("COMPANY"),
    ADMIN("ADMIN");

    private String value;

    ETypeUser(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
