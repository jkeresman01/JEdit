package com.keresman.lsp;

import java.util.concurrent.CompletableFuture;
import org.eclipse.lsp4j.DidCloseTextDocumentParams;
import org.eclipse.lsp4j.DidOpenTextDocumentParams;
import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.HoverParams;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.TextDocumentItem;
import org.eclipse.lsp4j.services.LanguageServer;
import org.eclipse.lsp4j.services.TextDocumentService;

public class LspClientManager {

    private final LanguageServer languageServer;

    public LspClientManager(LanguageServer languageServer) {
        this.languageServer = languageServer;
    }

    public void openDocument(String uri, String text, String languageId) {
        TextDocumentItem item = new TextDocumentItem();
        item.setUri(uri);
        item.setText(text);
        item.setLanguageId(languageId);
        item.setVersion(1);

        DidOpenTextDocumentParams openParams = new DidOpenTextDocumentParams(item);
        languageServer.getTextDocumentService().didOpen(openParams);
    }

    public void closeDocument(String uri) {
        TextDocumentIdentifier identifier = new TextDocumentIdentifier(uri);
        DidCloseTextDocumentParams params = new DidCloseTextDocumentParams(identifier);
        languageServer.getTextDocumentService().didClose(params);
    }

    public CompletableFuture<Hover> hover(String uri, int line, int character) {
        TextDocumentIdentifier identifier = new TextDocumentIdentifier(uri);
        Position pos = new Position(line, character);
        HoverParams params = new HoverParams(identifier, pos);

        return languageServer.getTextDocumentService().hover(params);
    }

    public TextDocumentService getTextDocumentService() {
        return languageServer.getTextDocumentService();
    }

    public LanguageServer getLanguageServer() {
        return languageServer;
    }
}
