package com.keresman.editor.view.projects.designer;

import javax.swing.JPanel;

public abstract class ProjectTreePanelDesigner extends JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JTree trProjects;
    // End of variables declaration//GEN-END:variables

    protected ProjectTreePanelDesigner() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        trProjects = new javax.swing.JTree();

        setPreferredSize(new java.awt.Dimension(200, 800));
        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(240, 362));

        trProjects.setModel(null);
        trProjects.setName(""); // NOI18N
        trProjects.setPreferredSize(new java.awt.Dimension(200, 800));
        jScrollPane1.setViewportView(trProjects);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

}
