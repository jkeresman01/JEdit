package com.keresman.editor.view.designer;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public abstract class WelcomePanelDesigner extends JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnNewFile;
    protected javax.swing.JButton btnOpenFile;
    protected javax.swing.JButton btnOpenProject;
    protected javax.swing.JLabel lblCreatedBy;
    protected javax.swing.JLabel lblTitle;
    protected javax.swing.JPanel pnlBottom;
    protected javax.swing.JPanel pnlMain;
    protected javax.swing.JScrollPane spRecentFiles;
    protected javax.swing.JTextArea taRecentFIles;
    // End of variables declaration//GEN-END:variables

   protected WelcomePanelDesigner() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        pnlBottom = new javax.swing.JPanel();
        lblCreatedBy = new javax.swing.JLabel();
        pnlMain = new javax.swing.JPanel();
        btnOpenProject = new javax.swing.JButton();
        btnOpenFile = new javax.swing.JButton();
        btnNewFile = new javax.swing.JButton();
        spRecentFiles = new javax.swing.JScrollPane();
        taRecentFIles = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(30, 30, 30));
        setPreferredSize(new java.awt.Dimension(1080, 800));
        setLayout(new java.awt.BorderLayout());

        lblTitle.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Welcome to jeditor");
        lblTitle.setPreferredSize(new java.awt.Dimension(249, 30));
        add(lblTitle, java.awt.BorderLayout.PAGE_START);

        pnlBottom.setLayout(new java.awt.BorderLayout());

        lblCreatedBy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCreatedBy.setForeground(new java.awt.Color(30, 30, 30));
        lblCreatedBy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCreatedBy.setText("JEditor 0.1 | by Josip   ");
        pnlBottom.add(lblCreatedBy, java.awt.BorderLayout.CENTER);

        add(pnlBottom, java.awt.BorderLayout.PAGE_END);

        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOpenProject.setText("Open Project");
        btnOpenProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenProjectActionPerformed(evt);
            }
        });
        pnlMain.add(btnOpenProject, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 120, 30));

        btnOpenFile.setText("Open File");
        btnOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenFileActionPerformed(evt);
            }
        });
        pnlMain.add(btnOpenFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 120, 30));

        btnNewFile.setText("New File");
        btnNewFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewFileActionPerformed(evt);
            }
        });
        pnlMain.add(btnNewFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 120, 30));

        taRecentFIles.setBackground(new java.awt.Color(40, 40, 40));
        taRecentFIles.setColumns(20);
        taRecentFIles.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        taRecentFIles.setForeground(new java.awt.Color(153, 153, 153));
        taRecentFIles.setRows(5);
        taRecentFIles.setText(" Recent Files:\n            - C:/projects/test.txt\n            - C:/notes/ideas.md\n            - C:/code/sample.java");
        taRecentFIles.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        spRecentFiles.setViewportView(taRecentFIles);

        pnlMain.add(spRecentFiles, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 440, 140));

        add(pnlMain, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    public abstract void btnOpenFileActionPerformed(ActionEvent evt);

    public abstract void btnNewFileActionPerformed(ActionEvent evt);

    public abstract void btnOpenProjectActionPerformed(ActionEvent evt);

}
