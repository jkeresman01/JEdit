package com.keresman.jedit.plugin;

public interface JEditPlugin {

  String getName();

  void onLoad();

  void onUnload();
}
