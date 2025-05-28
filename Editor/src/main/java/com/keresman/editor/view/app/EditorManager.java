package com.keresman.editor.view.app;

import com.keresman.editor.view.app.designer.EditorManagerDesigner;
import com.keresman.components.ClosablePanel;
import com.keresman.editor.events.EditorEventBusImpl;
import com.keresman.editor.view.edit.EditorPanel;
import com.keresman.editor.view.projects.ProjectTreePanel;
import com.keresman.editor.view.welcome.WelcomePanel;
import com.keresman.enums.EditOptions;
import com.keresman.enums.StringConstants;
import com.keresman.exceptions.ThrowingExceptionTask;
import com.keresman.lsp.LSPConnector;
import com.keresman.lsp.LspClientManager;
import com.keresman.lsp.events.EditorEventBus;
import com.keresman.utilities.ExceptionUtils;
import com.keresman.utilities.FileUtils;
import com.keresman.utilities.MenuUtils;
import com.keresman.utilities.MessageUtils;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import javax.swing.ActionMap;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

public class EditorManager extends EditorManagerDesigner {

    private static final String WELCOME = "Welcome";
    private static final String PROJECTS = "Projects";
    private static final String NEW_FILE = "New file";

    private final EditorEventBus eventBus = new EditorEventBusImpl();

    private LSPConnector lspConnector;
    private LspClientManager lspClientManager;
    private ActionMap actionMap = tpCenter.getActionMap();

    public EditorManager() {
        super();
        initMenus();
        initPanels();
//        initLSP(); 
//TODO -> fix gazilion bugs
    }

    private void initMenus() {
        initCutMenuItem();
        initPasteMenuItem();
        initCopyMenuItem();
        initSelectAllMenuItem();
    }

    private void initCutMenuItem() {
        JMenuItem cutMenuItem = MenuUtils.createMenuItem(
                actionMap.get(DefaultEditorKit.cutAction),
                EditOptions.CUT,
                KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK)
        );

        menuEdit.add(cutMenuItem);
    }

    private void initPasteMenuItem() {
        JMenuItem pasteMenuItem = MenuUtils.createMenuItem(
                actionMap.get(DefaultEditorKit.pasteAction),
                EditOptions.PASTE,
                KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK)
        );

        menuEdit.add(pasteMenuItem);
    }

    private void initCopyMenuItem() {
        JMenuItem copyMenuItem = MenuUtils.createMenuItem(
                actionMap.get(DefaultEditorKit.copyAction),
                EditOptions.COPY,
                KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK)
        );

        menuEdit.add(copyMenuItem);
    }

    private void initSelectAllMenuItem() {
        JMenuItem selectAllMenuItem = MenuUtils.createMenuItem(
                actionMap.get(DefaultEditorKit.selectAllAction),
                EditOptions.SELECT_ALL,
                KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK)
        );

        menuEdit.add(selectAllMenuItem);
    }

    private void initPanels() {
        initProjectsPanel();
        initWelcomePanel();
    }

    private void initProjectsPanel() {
        ProjectTreePanel projectTreePanel = new ProjectTreePanel();
        ClosablePanel.attachTo(tpLeft, projectTreePanel, PROJECTS);
    }

    private void initWelcomePanel() {
        WelcomePanel welcomePanel = new WelcomePanel(this);
        ClosablePanel.attachTo(tpCenter, welcomePanel, WELCOME);
    }

    private void initLSP() {
        lspConnector = new LSPConnector(eventBus);

        ThrowingExceptionTask<IOException> throwingExceptionTask = () -> {
            lspConnector.start("java", "-jar", "dummy-jlang-server.jar");
            lspClientManager = new LspClientManager(lspConnector.getLanguageServer());
        };

        ExceptionUtils.executeUnchecked(
                throwingExceptionTask,
                "No can do, initliazation of LSP server has failed!"
        );
    }

    @Override
    public void miNewActionPerformed(ActionEvent evt) {
        EditorPanel editorPanel = new EditorPanel(Optional.empty(), lspClientManager);
        editorPanel.setContent(StringConstants.EMPTY.value());
        ClosablePanel.attachTo(tpCenter, editorPanel, NEW_FILE);
    }

    @Override
    public void miOpenActionPerformed(ActionEvent evt) {
        Optional<File> optFile = FileUtils.selectFile();

        if (optFile.isPresent()) {
            EditorPanel editorPanel = new EditorPanel(optFile, lspClientManager);
            Optional<String> optFileContent = FileUtils.loadText(optFile.get());

            if (optFileContent.isPresent()) {
                editorPanel.setContent(optFileContent.get());
                ClosablePanel.attachTo(tpCenter, editorPanel, optFile.get().getName());
                tpCenter.setSelectedComponent(editorPanel);
                closeWelcomePanel();
            }
        }
    }

    @Override
    public void miSaveActionPerformed(ActionEvent evt) {
        Component selectedComponent = tpCenter.getSelectedComponent();

        if (selectedComponent instanceof EditorPanel editor) {
            FileUtils.saveText(editor.getContent(), Optional.empty());
        }
    }

    @Override
    public void miSaveAsActionPerformed(ActionEvent evt) {
        Component selectedComponent = tpCenter.getSelectedComponent();

        if (selectedComponent instanceof EditorPanel editor) {
            FileUtils.saveText(editor.getContent(), Optional.empty());
        }
    }

    @Override
    public void miPageSetupActionPerformed(ActionEvent evt) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.pageDialog(printerJob.defaultPage());
    }

    @Override
    public void miPrintActionPerformed(ActionEvent evt) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.printDialog();
    }

    @Override
    public void miExitActionPerformed(ActionEvent evt) {
        miSave.doClick();
        dispose();
    }

    @Override
    public void miAboutActionPerformed(ActionEvent evt) {
        MessageUtils.showInformationMessage("JEditor, Version 0.1");
    }

    private void closeWelcomePanel() {
        for (int i = 0; i < tpCenter.getTabCount(); ++i) {
            if (tpCenter.getComponentAt(i) instanceof WelcomePanel) {
                tpCenter.removeTabAt(i);
                break;
            }
        }
    }

    @Override
    public void miViewProjectsActionPerformed(ActionEvent evt) {
        //TODO
    }

    @Override
    public void miViewConsoleActionPerformed(ActionEvent evt) {
        //TODO
    }
}
