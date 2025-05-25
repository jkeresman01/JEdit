package com.keresman;

import com.keresman.editor.EditorManager;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.keresman.utilities.UIUtils;
import java.awt.EventQueue;

public class JEditor {

    public static void main(String args[]) {
        UIUtils.setLookAndFeel(new FlatDarculaLaf());
        EventQueue.invokeLater(() -> new EditorManager().setVisible(true));
    }

}
