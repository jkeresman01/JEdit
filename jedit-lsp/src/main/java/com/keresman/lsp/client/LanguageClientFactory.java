package com.keresman.lsp.client;

import com.keresman.exceptions.ThrowingExceptionTask;
import com.keresman.lsp.events.EditorEventBus;
import com.keresman.utilities.ExceptionUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.lsp4j.services.LanguageClient;

public final class LanguageClientFactory {

  private static final String CONFIG_PATH = "/config/lsp.properties";
  private static final String CLASS_NAME_KEY = "lsp.client.class";
  private static final Properties PROPERTIES = new Properties();

  private static volatile LanguageClient instance;

  static {
    try (InputStream is = LanguageClientFactory.class.getResourceAsStream(CONFIG_PATH)) {
      PROPERTIES.load(is);
    } catch (IOException ex) {
      Logger.getLogger(LanguageClientFactory.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private LanguageClientFactory() {
    // Suppresses default constructor, ensuring non-instantiability.
  }

  public static LanguageClient getClient(EditorEventBus eventBus) {

    LanguageClient result = instance;

    if (result == null) {
      synchronized (LanguageClientFactory.class) {
        result = instance;

        if (result == null) {
          instance = createInstance(eventBus);
        }
      }
    }

    return instance;
  }

  private static LanguageClient createInstance(EditorEventBus eventBus) {

    ThrowingExceptionTask<Exception> task =
        () -> {
          String className = PROPERTIES.getProperty(CLASS_NAME_KEY);

          instance =
              (LanguageClient)
                  Class.forName(className)
                      .getConstructor(EditorEventBus.class)
                      .newInstance(eventBus);
        };

    ExceptionUtils.executeUnchecked(task, "Failed to initialize Langauge client!!");

    return instance;
  }
}
