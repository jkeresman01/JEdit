package com.keresman.editor.view.welcome;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;

abstract class WelcomePanelDesigner extends JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnNewFile;
    protected javax.swing.JButton btnOpenFile;
    protected javax.swing.JButton btnOpenProject;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JPanel jPanel1;
    protected javax.swing.JPanel jPanel2;
    protected javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    protected javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables

   WelcomePanelDesigner() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnOpenProject = new javax.swing.JButton();
        btnOpenFile = new javax.swing.JButton();
        btnNewFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(30, 30, 30));
        setPreferredSize(new java.awt.Dimension(1080, 800));
        setLayout(new java.awt.BorderLayout());

        lblTitle.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Welcome to jeditor");
        lblTitle.setPreferredSize(new java.awt.Dimension(249, 30));
        add(lblTitle, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 30, 30));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("JEditor 0.1 | by Josip   ");
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOpenProject.setText("Open Project");
        btnOpenProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenProjectActionPerformed(evt);
            }
        });
        jPanel2.add(btnOpenProject, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 120, 30));

        btnOpenFile.setText("Open File");
        btnOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenFileActionPerformed(evt);
            }
        });
        jPanel2.add(btnOpenFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 120, 30));

        btnNewFile.setText("New File");
        btnNewFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewFileActionPerformed(evt);
            }
        });
        jPanel2.add(btnNewFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 120, 30));

        jTextArea1.setBackground(new java.awt.Color(40, 40, 40));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(153, 153, 153));
        jTextArea1.setRows(5);
        jTextArea1.setText(" Recent Files:\n            - C:/projects/test.txt\n            - C:/notes/ideas.md\n            - C:/code/sample.java");
        jTextArea1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 440, 140));

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    public abstract void btnOpenFileActionPerformed(ActionEvent evt);

    public abstract void btnNewFileActionPerformed(ActionEvent evt);

    public abstract void btnOpenProjectActionPerformed(ActionEvent evt);

}
