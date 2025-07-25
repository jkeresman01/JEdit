package com.keresman.utilities;

import com.keresman.enums.MessageSeverity;
import javax.swing.JOptionPane;

/** Utility class for displaying standardized message dialogs using {@link JOptionPane}. */
public final class MessageUtils {

  private MessageUtils() {
    // Suppresses default constructor, ensuring non-instantiability.
  }

  /**
   * Displays an information message dialog.
   *
   * @param message
   */
  public static void showInformationMessage(String message) {
    JOptionPane.showMessageDialog(
        null, message, MessageSeverity.INFO.toString(), JOptionPane.INFORMATION_MESSAGE);
  }

  /**
   * Displays an information message dialog.
   *
   * @param message
   */
  public static void showInformationMessage(String title, String message) {
    JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
  }

  /**
   * Displays a warning message dialog.
   *
   * @param message
   */
  public static void showWarningMessage(String message) {
    JOptionPane.showMessageDialog(
        null, message, MessageSeverity.WARN.toString(), JOptionPane.WARNING_MESSAGE);
  }

  /**
   * Displays an error message dialog.
   *
   * @param message
   */
  public static void showErrorMessage(String message) {
    JOptionPane.showMessageDialog(
        null, message, MessageSeverity.ERROR.toString(), JOptionPane.ERROR_MESSAGE);
  }

  /**
   * Displays a confirmation dialog with OK and Cancel options.
   *
   * @param title
   * @param message
   * @return {@code true} if OK was selected; {@code false} otherwise
   */
  public static boolean showConfirmDialog(String title, String message) {
    return JOptionPane.showConfirmDialog(
            null, message, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE)
        == JOptionPane.OK_OPTION;
  }
}
