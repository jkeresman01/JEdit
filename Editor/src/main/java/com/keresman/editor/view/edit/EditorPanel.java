package com.keresman.editor.view.edit;

import com.keresman.editor.listeners.EditorDocumentHighlightListener;
import com.keresman.jlang.highlight.SyntaxHighlighter;
import com.keresman.utilities.FileUtils;
import java.io.File;
import java.util.Optional;
import javax.swing.text.Document;

public class EditorPanel extends EditorPanelDesigner {

    private static final String JLANG_EXTENSION = "j";

    public EditorPanel(Optional<File> file) {
        super();
        init(file);
    }

    private void init(Optional<File> file) {
        Document document = tpContent.getDocument();

        if (file.isPresent() && FileUtils.hasExtension(file.get(), JLANG_EXTENSION)) {
            SyntaxHighlighter highlighter = new SyntaxHighlighter(tpContent);
            document.addDocumentListener(new EditorDocumentHighlightListener(tpContent, highlighter));
        }
    }

    public void setContent(String text) {
        tpContent.setText(text);
    }

    public String getContent() {
        return this.tpContent.getText();
    }
}
