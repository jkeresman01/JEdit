package com.keresman.utilities;

import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

public final class UIUtils {

    private UIUtils() {
        // Suppresses default constructor, ensuring non-instantiability.
    }

    
    public static void setLookAndFeel(String lookAndFeel) {
        Optional<UIManager.LookAndFeelInfo> selectedLookAndFeelOps = getInstaledLookAndFeel(lookAndFeel);

        if (selectedLookAndFeelOps.isPresent()) {
            trySetLookAndFell(lookAndFeel);
        }
    }

    private static Optional<UIManager.LookAndFeelInfo> getInstaledLookAndFeel(String installedLookAndFeel) {
        return Arrays.stream(UIManager.getInstalledLookAndFeels())
                .filter(lookAndFell -> installedLookAndFeel.equals(lookAndFell.getClassName()))
                .findFirst();
    }

    private static void trySetLookAndFell(String lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception ex) {
            Logger.getLogger(UIUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
