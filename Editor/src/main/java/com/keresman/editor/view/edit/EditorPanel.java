package com.keresman.editor.view.edit;

public class EditorPanel extends EditorPanelDesigner {

    public void setContent(String text) {
        tpContent.setText(text);
    }

    public String getContent() {
        return this.tpContent.getText();
    }

}
