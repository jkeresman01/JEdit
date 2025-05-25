package com.keresman.utilities;

import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 * Utility class for setting the Swing look and feel.
 *
 * This class is not intended to be extended or instantiated.
 * It follows the utility class design pattern, and explicitly forbids subclassing and
 * instantiation
 *
 */
public final class UIUtils {

    private UIUtils() {
        // Suppresses default constructor, ensuring non-instantiability.
    }

    /**
     * Attempts to set the look and feel of the Swing UI to the specified class
     * name, if it is installed on the system.
     *
     * @param lookAndFeel
     */
    public static void setLookAndFeel(String lookAndFeel) {
        Optional<UIManager.LookAndFeelInfo> selectedLookAndFeelOps = getInstaledLookAndFeel(lookAndFeel);

        if (selectedLookAndFeelOps.isPresent()) {
            trySetLookAndFeel(lookAndFeel);
        }
    }

    private static Optional<UIManager.LookAndFeelInfo> getInstaledLookAndFeel(String installedLookAndFeel) {
        return Arrays.stream(UIManager.getInstalledLookAndFeels())
                .filter(lookAndFell -> installedLookAndFeel.equals(lookAndFell.getClassName()))
                .findFirst();
    }

    private static void trySetLookAndFeel(String lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception ex) {
            Logger.getLogger(UIUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
