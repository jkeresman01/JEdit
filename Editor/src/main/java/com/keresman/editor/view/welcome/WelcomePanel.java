package com.keresman.editor.view.welcome;

import com.keresman.editor.EditorManager;
import java.awt.event.ActionEvent;

public class WelcomePanel extends WelcomePanelDesigner{
    
    private final EditorManager editorManager;

    public WelcomePanel(EditorManager EditorManager) {
        this.editorManager = EditorManager;
    }

    @Override
    public void btnOpenFileActionPerformed(ActionEvent evt) {
        editorManager.miOpenActionPerformed(evt);
    }

    @Override
    public void btnNewFileActionPerformed(ActionEvent evt) {
        editorManager.miNewActionPerformed(evt);
    }

    @Override
    public void btnOpenProjectActionPerformed(ActionEvent evt) {
        editorManager.miOpenActionPerformed(evt);
    }
}
