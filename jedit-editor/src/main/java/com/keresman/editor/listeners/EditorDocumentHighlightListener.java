package com.keresman.editor.listeners;

import com.keresman.jlang.highlight.SyntaxHighlighter;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class EditorDocumentHighlightListener implements DocumentListener{
    
    private final JTextPane textPane;
    private final SyntaxHighlighter highlighter;

    public EditorDocumentHighlightListener(JTextPane textPane, SyntaxHighlighter highlighter) {
        this.textPane = textPane;
        this.highlighter = highlighter;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        highlight();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        highlight();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {}

    private void highlight() {
        SwingUtilities.invokeLater(() -> highlighter.highlight(textPane.getText()));
    }
}
    
