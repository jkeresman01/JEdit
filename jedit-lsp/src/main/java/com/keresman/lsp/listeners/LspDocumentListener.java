package com.keresman.lsp.listeners;

import com.keresman.lsp.LspClientManager;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.eclipse.lsp4j.DidChangeTextDocumentParams;
import org.eclipse.lsp4j.TextDocumentContentChangeEvent;
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier;

public class LspDocumentListener implements DocumentListener {

  private final String uri;
  private final LspClientManager lspClientManager;
  private int version = 1;

  public LspDocumentListener(String uri, LspClientManager lspClientManager) {
    this.uri = uri;
    this.lspClientManager = lspClientManager;
  }

  @Override
  public void insertUpdate(DocumentEvent e) {
    sendChange(e.getDocument());
  }

  @Override
  public void removeUpdate(DocumentEvent e) {
    sendChange(e.getDocument());
  }

  @Override
  public void changedUpdate(DocumentEvent e) {
    sendChange(e.getDocument());
  }

  private void sendChange(Document doc) {
    String text = "";

    try {
      text = doc.getText(0, doc.getLength());
    } catch (BadLocationException ex) {
      Logger.getLogger(LspDocumentListener.class.getName()).log(Level.SEVERE, null, ex);
    }

    var identifier = new VersionedTextDocumentIdentifier();
    identifier.setUri(uri);
    identifier.setVersion(version++);

    var change = new TextDocumentContentChangeEvent(text);
    var params = new DidChangeTextDocumentParams(identifier, Collections.singletonList(change));

    lspClientManager.getTextDocumentService().didChange(params);
  }
}
