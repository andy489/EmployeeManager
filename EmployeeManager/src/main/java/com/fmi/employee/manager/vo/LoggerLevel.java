package com.fmi.employee.manager.vo;

public enum LoggerLevel {
    ERROR(0 , "ERROR"),
    INFO(1, "INFO"),
    DEBUG(2, "DEBUG"),
    TRACE(3, "TRACE");


    private final Integer code;
    private final String label;

    LoggerLevel(Integer code, String label) {
        this.code = code;
        this.label=label;
    }

    public Integer getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}