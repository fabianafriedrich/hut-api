package com.cct.hut.api.enums;

public enum Status {
    ANSWERED(1),
    UNANSWERED(2);

    private int status;

    Status(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
