package com.keresman.utilities;

import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

/**
 * Utility class for setting the Swing look and feel.
 *
 * This class is not intended to be extended or instantiated. It follows the
 * utility class design pattern, and explicitly forbids subclassing and
 * instantiation
 *
 */
public final class UIUtils {

    private UIUtils() {
        // Suppresses default constructor, ensuring non-instantiability.
    }

    /**
     * Attempts to set the look and feel of the Swing UI to the specified class
     * name
     *
     * @param lookAndFeel 
     */
    public static void setLookAndFeel(LookAndFeel lookAndFeel) {
        trySetLookAndFeel(lookAndFeel);
    }

    private static void trySetLookAndFeel(LookAndFeel lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception ex) {
            Logger.getLogger(UIUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
