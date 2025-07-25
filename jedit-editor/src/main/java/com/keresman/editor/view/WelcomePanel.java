package com.keresman.editor.view;

import com.keresman.editor.view.designer.WelcomePanelDesigner;
import com.keresman.jedit.model.ProjectActions;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class WelcomePanel extends WelcomePanelDesigner {

  private final ProjectActions projectActions;

  public WelcomePanel(JFrame parent) {
    this.projectActions = (ProjectActions) parent;
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
