package com.keresman.utilities;

import com.keresman.enums.MessageSeverity;
import javax.swing.JOptionPane;

public final class MessageUtils {

    private MessageUtils() {
        // Suppresses default constructor, ensuring non-instantiability.
    }

    
    public static void showInformationMessage(String message) {
        JOptionPane.showMessageDialog(
                null, 
                message, 
                MessageSeverity.INFO.name(), 
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void showWarningMessage(String message) {
        JOptionPane.showMessageDialog(
                null, 
                message, 
                MessageSeverity.WARN.name(), 
                JOptionPane.WARNING_MESSAGE
        );
    }

    public static void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(
                null, 
                message, 
                MessageSeverity.ERROR.name(), 
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static boolean showConfirmDialog(String title, String message) {
        return JOptionPane.showConfirmDialog(
                null, 
                message, 
                title, 
                JOptionPane.OK_CANCEL_OPTION, 
                JOptionPane.ERROR_MESSAGE) == JOptionPane.OK_OPTION;
    }

}
