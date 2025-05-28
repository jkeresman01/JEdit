package com.keresman.editor.view.edit;

import com.keresman.editor.view.edit.designer.EditorPanelDesigner;
import com.keresman.editor.listeners.EditorDocumentHighlightListener;
import com.keresman.jlang.highlight.SyntaxHighlighter;
import com.keresman.lsp.LspClientManager;
import com.keresman.utilities.FileUtils;
import java.io.File;
import java.util.Optional;
import javax.swing.text.Document;

public class EditorPanel extends EditorPanelDesigner {

    private static final String JLANG_EXTENSION = "j";
    private final LspClientManager lspClientManager;
    
    public EditorPanel(Optional<File> file, LspClientManager lspClientManager) {
        super();
        this.lspClientManager = lspClientManager;
        initListeners(file);
    }

    private void initListeners(Optional<File> file) {
        Document document = tpContent.getDocument();

        if (file.isPresent() && FileUtils.hasExtension(file.get(), JLANG_EXTENSION)) {
            document.addDocumentListener(
                    new EditorDocumentHighlightListener(tpContent, new SyntaxHighlighter(tpContent))
            );

            /////////////////////////////////////////////////////////////////////////////////////////
            //
            //    ----------------------          TODO             ----------------------------
            //    ----------------------          TODO             ----------------------------
            //
            //
            //document.addDocumentListener(
            //        new LspDocumentListener(file.get().getAbsolutePath(), lspClientManager)
            //);
            //
            /////////////////////////////////////////////////////////////////////////////////////////

        }
    }

    public void setContent(String text) {
        tpContent.setText(text);
    }

    public String getContent() {
        return this.tpContent.getText();
    }
}
