package com.keresman.editor;

import com.keresman.enums.EditOptions;
import com.keresman.utilities.FileUtils;
import com.keresman.utilities.MenuUtils;
import com.keresman.utilities.MessageUtils;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ActionMap;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

public class EditorManager extends EditorManagerDesigner {

    private Optional<File> selectedFile = Optional.empty();
    private boolean isEdited = false;

    public EditorManager() {
        initComponents();
        initEditMenu();
    }

    private void initEditMenu() {
        initCutMenuItem();
        initPasteMenuItem();
        initCopyMenuItem();
        initSelectAllMenuItem();
    }

    private void initCutMenuItem() {
        ActionMap actionMap = tpContent.getActionMap();
        
        JMenuItem cutMenuItem = MenuUtils.createMenuItem(
                actionMap.get(DefaultEditorKit.cutAction),
                EditOptions.CUT,
                KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK)
        );

        menuEdit.add(cutMenuItem);
    }

    private void initPasteMenuItem() {
        ActionMap actionMap = tpContent.getActionMap();
        
        JMenuItem pasteMenuItem = MenuUtils.createMenuItem(
                actionMap.get(DefaultEditorKit.pasteAction),
                EditOptions.PASTE,
                KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK)
        );

        menuEdit.add(pasteMenuItem);
    }

    private void initCopyMenuItem() {
        ActionMap actionMap = tpContent.getActionMap();
        
        JMenuItem copyMenuItem = MenuUtils.createMenuItem(
                actionMap.get(DefaultEditorKit.copyAction),
                EditOptions.COPY,
                KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK)
        );

        menuEdit.add(copyMenuItem);
    }

    private void initSelectAllMenuItem() {
        ActionMap actionMap = tpContent.getActionMap();
        
        JMenuItem selectAllMenuItem = MenuUtils.createMenuItem(
                actionMap.get(DefaultEditorKit.selectAllAction),
                EditOptions.SELECT_ALL,
                KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK)
        );

        menuEdit.add(selectAllMenuItem);
    }

    @Override
    public void miNewActionPerformed(ActionEvent evt) {
        if (isEdited) {
            miSaveAs.doClick();
        }

        tpContent.setText("");
        isEdited = false;
        selectedFile = Optional.empty();
    }

    @Override
    public void miOpenActionPerformed(ActionEvent evt) {
        try {
            Optional<String> optText = FileUtils.loadText();

            if (optText.isPresent()) {
                tpContent.setText(optText.get());
                isEdited = true;
                selectedFile = Optional.empty();
            }
        } catch (IOException ex) {
            Logger.getLogger(EditorManagerDesigner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void miSaveActionPerformed(ActionEvent evt) {
        try {
            selectedFile = FileUtils.saveText(tpContent.getText(), Optional.empty());
            isEdited = false;
        } catch (IOException ex) {
            Logger.getLogger(EditorManagerDesigner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void miSaveAsActionPerformed(ActionEvent evt) {
        try {
            selectedFile = FileUtils.saveText(tpContent.getText(), Optional.empty());
            isEdited = false;
        } catch (IOException ex) {
            Logger.getLogger(EditorManagerDesigner.class.getName()).log(Level.SEVERE, null, ex);
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
        if (isEdited) {
            miSaveAs.doClick();
        }

        dispose();
    }

    @Override
    public void miAboutActionPerformed(ActionEvent evt) {
        MessageUtils.showInformationMessage("JEditor, Version 0.1");
    }

}
