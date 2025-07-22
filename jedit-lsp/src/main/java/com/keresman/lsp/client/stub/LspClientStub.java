package com.keresman.lsp.client.stub;

import com.keresman.lsp.events.EditorEventBus;
import java.util.concurrent.CompletableFuture;
import org.eclipse.lsp4j.MessageActionItem;
import org.eclipse.lsp4j.MessageParams;
import org.eclipse.lsp4j.PublishDiagnosticsParams;
import org.eclipse.lsp4j.ShowMessageRequestParams;
import org.eclipse.lsp4j.services.LanguageClient;

public class LspClientStub implements LanguageClient {

    private final EditorEventBus eventBus;

    public LspClientStub(EditorEventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void publishDiagnostics(PublishDiagnosticsParams params) {
        eventBus.onDiagnostics(params);
    }

    @Override
    public void logMessage(MessageParams params) {
        eventBus.onLog(params.getMessage());
    }

    @Override
    public void showMessage(MessageParams params) {
        eventBus.onShowMessage("LSP Message", params.getMessage());
    }

    @Override
    public void telemetryEvent(Object object) {
        eventBus.onLog("Telementy event: " + object);
    }

    @Override
    public CompletableFuture<MessageActionItem> showMessageRequest(ShowMessageRequestParams smrp) {
        if (smrp.getActions() != null && !smrp.getActions().isEmpty()) {
            //TODO -- use getFirst() after Java uplift
            MessageActionItem firstMessageActionItem = smrp.getActions().get(0);
            return CompletableFuture.completedFuture(firstMessageActionItem);
        }

        return CompletableFuture.completedFuture(null);
    }
}
