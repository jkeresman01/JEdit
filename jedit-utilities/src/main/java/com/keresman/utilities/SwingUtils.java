package com.keresman.utilities;

import javax.swing.LookAndFeel;
import javax.swing.UIManager;

/** Utility class for setting the Swing look and feel. */
public final class SwingUtils {

  private SwingUtils() {
    // Suppresses default constructor, ensuring non-instantiability.
  }

  /**
   * Attempts to set the look and feel of the Swing UI to the specified class
   *
   * @param lookAndFeel
   */
  public static void setLookAndFeel(LookAndFeel lookAndFeel) {
    ExceptionUtils.executeUnchecked(
        () -> UIManager.setLookAndFeel(lookAndFeel),
        "Failed to set look and feel to: %s".formatted(lookAndFeel.getClass().getName()));
  }
}
