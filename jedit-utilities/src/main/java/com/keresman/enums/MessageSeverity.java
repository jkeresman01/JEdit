package com.keresman.enums;

public enum MessageSeverity {
  DEBUG("DEBUG"),
  INFO("INFO"),
  WARN("WARN"),
  ERROR("ERROR");

  private final String text;

  private MessageSeverity(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return text;
  }
}
