package com.keresman.editor.events;

import com.keresman.lsp.events.EditorEventBus;
import com.keresman.utilities.MessageUtils;
import javax.swing.SwingUtilities;
import org.eclipse.lsp4j.PublishDiagnosticsParams;

public class EditorEventBusImpl implements EditorEventBus {

  @Override
  public void onDiagnostics(PublishDiagnosticsParams params) {
    SwingUtilities.invokeLater(
        () -> MessageUtils.showWarningMessage(params.getDiagnostics().toString()));
  }

  @Override
  public void onLog(String message) {
    SwingUtilities.invokeLater(() -> MessageUtils.showInformationMessage(message));
  }

  @Override
  public void onShowMessage(String title, String message) {
    SwingUtilities.invokeLater(() -> MessageUtils.showInformationMessage(message));
  }
}
