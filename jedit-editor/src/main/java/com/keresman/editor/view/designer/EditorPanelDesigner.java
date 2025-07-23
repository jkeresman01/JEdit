package com.keresman.editor.view.designer;

import javax.swing.JPanel;

public abstract class EditorPanelDesigner extends JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JScrollPane spContent;
    protected javax.swing.JTextPane tpContent;
    // End of variables declaration//GEN-END:variables

    protected EditorPanelDesigner() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spContent = new javax.swing.JScrollPane();
        tpContent = new javax.swing.JTextPane();

        setPreferredSize(new java.awt.Dimension(1080, 800));
        setLayout(new java.awt.BorderLayout());

        spContent.setViewportView(tpContent);

        add(spContent, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

}
