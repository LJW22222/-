package com.ljw.syncpay.domain.user.vo;

public enum SortType {

    NICKNAME("nickname"),
    VISITED("profileViewCount"),
    CREATE_AT("profileCreatedAt");

    private final String field;

    SortType(String field) {
        this.field = field;
    }

    public String converter(){
        return field;
    }
}

