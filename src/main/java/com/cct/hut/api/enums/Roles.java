package com.cct.hut.api.enums;

public enum  Roles {
    STUDENT(0),
    ADMIN(1);

    private int role;

    Roles(int role) {
        this.role = role;
    }

    public int getRole() {
        return role;
    }
}
