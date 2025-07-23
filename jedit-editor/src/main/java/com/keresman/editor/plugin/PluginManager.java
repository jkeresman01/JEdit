package com.keresman.editor.plugin;

import com.keresman.jedit.plugin.JEditPlugin;
import com.keresman.utilities.MessageUtils;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public final class PluginManager {

    private static final List<JEditPlugin> plugins = new ArrayList<>();

    private static PluginManager instance;

    private PluginManager() {
        // Suppresses default constructor, ensuring non-instantiability.
    }

    public static PluginManager getInstance() {
        if (instance == null) {
            instance = new PluginManager();
        }

        return instance;
    }

    public void loadPlugins(File pluginsDir) throws Exception {
        File[] jars = pluginsDir.listFiles((dir, name) -> name.endsWith(".jar"));

        if (jars == null) {
            MessageUtils.showWarningMessage(
                    "No can do for plugins dir: ".formatted(pluginsDir.getAbsoluteFile().toString()));
            return;
        }

        loadJars(jars);
    }

    private void loadJars(File[] jars) throws Exception {

        for (File jar : jars) {
            URL[] urls = new URL[]{jar.toURI().toURL()};
            URLClassLoader classLoader = new URLClassLoader(urls, getClass().getClassLoader());

            ServiceLoader<JEditPlugin> serviceLoader = ServiceLoader.load(JEditPlugin.class, classLoader);

            for (JEditPlugin plugin : serviceLoader) {
                plugin.onLoad();
                plugins.add(plugin);
                MessageUtils.showInformationMessage("PLUGIN", "Loaded plugin: %s".formatted(plugin.getName()));
            }

        }
    }

    public void unloadPlugins() {
        for (JEditPlugin plugin : plugins) {
            plugin.onUnload();
        }
        plugins.clear();
    }

}
