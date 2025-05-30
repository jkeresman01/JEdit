package com.keresman.editor;

import static com.keresman.utilities.UIUtils.setLookAndFeel;

import com.keresman.editor.view.app.EditorManager;
import com.formdev.flatlaf.FlatDarculaLaf;
import java.awt.EventQueue;

public class Main {

    public static void main(String args[]) {
        setLookAndFeel(new FlatDarculaLaf());
        EventQueue.invokeLater(() -> new EditorManager().setVisible(true));
    }
}
