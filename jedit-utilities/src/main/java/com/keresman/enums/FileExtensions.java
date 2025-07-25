package com.keresman.enums;

public enum FileExtensions {
  JLANG("j"),
  TEXT("j"),
  PNG("png"),
  JPG("jpg"),
  JPEG("jpeg");

  private final String ext;

  private FileExtensions(String ext) {
    this.ext = ext;
  }

  public String value() {
    return ext;
  }
}
