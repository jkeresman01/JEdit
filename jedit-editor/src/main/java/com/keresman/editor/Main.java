package com.keresman.editor;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.keresman.editor.view.EditorManager;
import com.keresman.utilities.SwingUtils;
import java.awt.EventQueue;

public class Main {

  public static void main(String args[]) {
    SwingUtils.setLookAndFeel(new FlatDarculaLaf());
    EventQueue.invokeLater(() -> new EditorManager().setVisible(true));
  }
}
