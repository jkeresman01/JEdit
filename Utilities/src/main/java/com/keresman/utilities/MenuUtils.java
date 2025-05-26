package com.keresman.utilities;

import com.keresman.enums.EditOptions;
import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * A utility class for working with menu items.
 *
 * This class is not intended to be extended or instantiated. It follows the
 * utility class design pattern, and explicitly forbids subclassing and
 * instantiation
 *
 */
public final class MenuUtils {

    private MenuUtils() {
        // Suppresses default constructor, ensuring non-instantiability.

    }

    public static JMenuItem createMenuItem(
            Action action,
            EditOptions editOption,
            KeyStroke accelerator
    ) {
        JMenuItem menuItem = new JMenuItem();

        menuItem.setAction(action);
        menuItem.setAccelerator(accelerator);
        menuItem.setText(editOption.toString());

        return menuItem;
    }
}
