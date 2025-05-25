package com.keresman.editor;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;

abstract class EditorManagerDesigner extends JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JMenuBar jMenuBar1;
    protected javax.swing.JPanel jPanel2;
    protected javax.swing.JPanel jPanel3;
    protected javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JScrollPane jScrollPane2;
    protected javax.swing.JPopupMenu.Separator jSeparator1;
    protected javax.swing.JPopupMenu.Separator jSeparator2;
    protected javax.swing.JPopupMenu.Separator jSeparator3;
    protected javax.swing.JTree jTree1;
    protected javax.swing.JMenu menuEdit;
    protected javax.swing.JMenu menuFile;
    protected javax.swing.JMenu menuHelp;
    protected javax.swing.JMenu menuOptions;
    protected javax.swing.JMenu menuView;
    protected javax.swing.JMenuItem miAbout;
    protected javax.swing.JMenuItem miExit;
    protected javax.swing.JMenuItem miNew;
    protected javax.swing.JMenuItem miOpen;
    protected javax.swing.JMenuItem miPageSetup;
    protected javax.swing.JMenuItem miPrint;
    protected javax.swing.JMenuItem miSave;
    protected javax.swing.JMenuItem miSaveAs;
    protected javax.swing.JTextPane tpContent;
    // End of variables declaration//GEN-END:variables

    EditorManagerDesigner() {
        //package scoped, only Edito Manager can do
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    protected void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        tpContent = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        miNew = new javax.swing.JMenuItem();
        miOpen = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        miSave = new javax.swing.JMenuItem();
        miSaveAs = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miPageSetup = new javax.swing.JMenuItem();
        miPrint = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        miExit = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        menuView = new javax.swing.JMenu();
        menuOptions = new javax.swing.JMenu();
        menuHelp = new javax.swing.JMenu();
        miAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JEdit 0.1");
        setMinimumSize(new java.awt.Dimension(1280, 800));

        jPanel2.setMinimumSize(new java.awt.Dimension(100, 100));
        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jTree1.setPreferredSize(new java.awt.Dimension(200, 74));
        jScrollPane1.setViewportView(jTree1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.LINE_START);

        jScrollPane2.setViewportView(tpContent);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        menuFile.setMnemonic('F');
        menuFile.setText("File");

        miNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miNew.setText("New");
        miNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewActionPerformed(evt);
            }
        });
        menuFile.add(miNew);

        miOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miOpen.setText("Open");
        miOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOpenActionPerformed(evt);
            }
        });
        menuFile.add(miOpen);
        menuFile.add(jSeparator3);

        miSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miSave.setText("Save");
        miSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSaveActionPerformed(evt);
            }
        });
        menuFile.add(miSave);

        miSaveAs.setText("Save as");
        miSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSaveAsActionPerformed(evt);
            }
        });
        menuFile.add(miSaveAs);
        menuFile.add(jSeparator1);

        miPageSetup.setText("Page setup");
        miPageSetup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPageSetupActionPerformed(evt);
            }
        });
        menuFile.add(miPageSetup);

        miPrint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miPrint.setText("Print");
        miPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPrintActionPerformed(evt);
            }
        });
        menuFile.add(miPrint);
        menuFile.add(jSeparator2);

        miExit.setText("Exit");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        menuFile.add(miExit);

        jMenuBar1.add(menuFile);

        menuEdit.setMnemonic('E');
        menuEdit.setText("Edit");
        jMenuBar1.add(menuEdit);

        menuView.setMnemonic('V');
        menuView.setText("View");
        jMenuBar1.add(menuView);

        menuOptions.setMnemonic('O');
        menuOptions.setText("Options");
        jMenuBar1.add(menuOptions);

        menuHelp.setMnemonic('H');
        menuHelp.setText("Help");

        miAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miAbout.setText("About");
        miAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAboutActionPerformed(evt);
            }
        });
        menuHelp.add(miAbout);

        jMenuBar1.add(menuHelp);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public abstract void miNewActionPerformed(ActionEvent evt);

    public abstract void miOpenActionPerformed(ActionEvent evt);

    public abstract void miSaveActionPerformed(ActionEvent evt);

    public abstract void miSaveAsActionPerformed(ActionEvent evt);

    public abstract void miPageSetupActionPerformed(ActionEvent evt);

    public abstract void miPrintActionPerformed(ActionEvent evt);

    public abstract void miExitActionPerformed(ActionEvent evt);

    public abstract void miAboutActionPerformed(ActionEvent evt);
}
