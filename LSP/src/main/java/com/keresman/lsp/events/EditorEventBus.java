package com.keresman.lsp.events;

import org.eclipse.lsp4j.PublishDiagnosticsParams;

public interface EditorEventBus {

    void onDiagnostics(PublishDiagnosticsParams params);

    void onLog(String message);

    void onShowMessage(String title, String message);
}
