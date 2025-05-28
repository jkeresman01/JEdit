package com.keresman.editor;

import static com.keresman.utilities.UIUtils.setLookAndFeel;

import com.formdev.flatlaf.FlatDarculaLaf;
import java.awt.EventQueue;

public class Application {

    public static void main(String args[]) {
        setLookAndFeel(new FlatDarculaLaf());
        EventQueue.invokeLater(() -> new EditorManager().setVisible(true));
    }
}
