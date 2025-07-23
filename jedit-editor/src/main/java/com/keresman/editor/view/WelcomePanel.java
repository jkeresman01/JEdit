package com.keresman.editor.view;

import com.keresman.editor.view.designer.WelcomePanelDesigner;
import com.keresman.jedit.model.ProjectActions;
import java.awt.event.ActionEvent;

public class WelcomePanel extends WelcomePanelDesigner {
    
    private final ProjectActions projectActions;

    public WelcomePanel(EditorManager EditorManager) {
        this.projectActions = EditorManager;
    }

    @Override
    public void btnOpenFileActionPerformed(ActionEvent evt) {
        projectActions.openRecetFile(evt);
    }

    @Override
    public void btnNewFileActionPerformed(ActionEvent evt) {
        projectActions.createNewFile(evt);
    }

    @Override
    public void btnOpenProjectActionPerformed(ActionEvent evt) {
        projectActions.openRecentProject(evt);
    }
}
