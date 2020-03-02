package com.cct.hut.api.enums;

public enum ReportType {
    SPAM(1),
    INAPPROPRIATE(2),
    EXIST(3);

    private int type;

    ReportType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
