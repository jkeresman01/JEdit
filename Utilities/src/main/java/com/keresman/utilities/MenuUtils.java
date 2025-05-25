package com.keresman.utilities;

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
public class MenuUtils {

    public MenuUtils() {
        // Suppresses default constructor, ensuring non-instantiability.

    }

    public static JMenuItem createMenuItem(
            Action action,
            String text,
            KeyStroke accelerator
    ) {
        JMenuItem menuItem = new JMenuItem();

        menuItem.setAction(action);
        menuItem.setAccelerator(accelerator);
        menuItem.setText(text);

        return menuItem;
    }
}
