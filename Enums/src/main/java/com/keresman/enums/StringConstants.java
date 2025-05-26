package com.keresman.enums;

public enum StringConstants {
    
    EMPTY(""),
    SPACE(" "),
    NEWLINE("\n"),
    TAB("\t"),
    COMMA(","),
    DOT(".");

    private final String value;

    StringConstants(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
