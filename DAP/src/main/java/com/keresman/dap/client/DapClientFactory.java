package com.keresman.dap.client;

import com.keresman.dap.events.DebugEventBus;
import com.keresman.exceptions.ThrowingExceptionTask;
import com.keresman.utilities.ExceptionUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.lsp4j.debug.services.IDebugProtocolClient;

public class DapClientFactory {

    private static final String CONFIG_PATH = "/config/dap.properties";
    private static final String CLASS_NAME_KEY = "dap.client.class";
    private static final Properties PROPERTIES = new Properties();

    private static volatile IDebugProtocolClient instance;

    static {
        try (InputStream is = DapClientFactory.class.getResourceAsStream(CONFIG_PATH)) {
            PROPERTIES.load(is);
        } catch (IOException ex) {
            Logger.getLogger(DapClientFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private DapClientFactory() {
        // Suppresses default constructor, ensuring non-instantiability.
    }

    public static IDebugProtocolClient getClient(DebugEventBus eventBus) {

        IDebugProtocolClient result = instance;

        if (result == null) {
            synchronized (DapClientFactory.class) {
                result = instance;

                if (result == null) {
                    instance = createInstance(eventBus);
                }
            }
        }

        return instance;
    }

    private static IDebugProtocolClient createInstance(DebugEventBus eventBus) {

        ThrowingExceptionTask<Exception> task = () -> {
            String className = PROPERTIES.getProperty(CLASS_NAME_KEY);

            instance = (IDebugProtocolClient) Class.forName(className)
                    .getConstructor(DebugEventBus.class)
                    .newInstance(eventBus);
        };

        ExceptionUtils.executeUnchecked(task, "Failed to initialize Langauge client!!");

        return instance;
    }
}
