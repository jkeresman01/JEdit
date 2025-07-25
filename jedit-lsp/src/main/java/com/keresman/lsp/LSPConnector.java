package com.keresman.lsp;

import com.keresman.lsp.client.LanguageClientFactory;
import com.keresman.lsp.events.EditorEventBus;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.stream.Stream;
import org.eclipse.lsp4j.launch.LSPLauncher;
import org.eclipse.lsp4j.services.LanguageServer;

public class LSPConnector {

  private LanguageServer languageServer;
  private OutputStream serverInput;
  private InputStream serverOutput;
  private EditorEventBus eventBus;

  public LSPConnector(EditorEventBus eventBus) {
    this.eventBus = eventBus;
  }

  public void start(String command, String... args) throws IOException {
    ProcessBuilder builder =
        new ProcessBuilder(
            Stream.concat(Stream.of(command), Arrays.stream(args)).toArray(String[]::new));

    Process process = builder.start();

    this.serverInput = process.getOutputStream();
    this.serverOutput = process.getInputStream();

    var launcher =
        LSPLauncher.createClientLauncher(
            LanguageClientFactory.getClient(eventBus), serverOutput, serverInput);

    this.languageServer = launcher.getRemoteProxy();
    launcher.startListening();
  }

  public void stop() throws IOException {
    if (serverInput != null) {
      serverInput.close();
    }
    if (serverOutput != null) {
      serverOutput.close();
    }
  }

  public LanguageServer getLanguageServer() {
    return languageServer;
  }
}
