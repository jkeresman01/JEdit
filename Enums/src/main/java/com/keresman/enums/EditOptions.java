package com.keresman.enums;

public enum EditOptions {

    CUT("Cut"),
    COPY("Copy"),
    PASTE("Paste"),
    SELECT_ALL("Select All");

    private final String text;

    private EditOptions(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
