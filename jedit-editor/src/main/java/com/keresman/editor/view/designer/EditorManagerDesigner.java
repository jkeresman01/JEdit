package com.keresman.editor.view.designer;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public abstract class EditorManagerDesigner extends JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JMenu mEdit;
    protected javax.swing.JMenu mFile;
    protected javax.swing.JMenu mOptions;
    protected javax.swing.JMenu mView;
    protected javax.swing.JMenuBar mbMain;
    protected javax.swing.JMenu menuHelp;
    protected javax.swing.JMenuItem miAbout;
    protected javax.swing.JMenuItem miExit;
    protected javax.swing.JMenuItem miNew;
    protected javax.swing.JMenuItem miOpen;
    protected javax.swing.JMenuItem miPageSetup;
    protected javax.swing.JMenuItem miPrint;
    protected javax.swing.JMenuItem miSave;
    protected javax.swing.JMenuItem miSaveAs;
    protected javax.swing.JCheckBoxMenuItem miViewConsole;
    protected javax.swing.JCheckBoxMenuItem miViewProjects;
    protected javax.swing.JPopupMenu.Separator spExit;
    protected javax.swing.JPopupMenu.Separator spProject;
    protected javax.swing.JPopupMenu.Separator spSave;
    protected javax.swing.JTabbedPane tpCenter;
    protected javax.swing.JTabbedPane tpLeft;
    // End of variables declaration//GEN-END:variables

    protected EditorManagerDesigner() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpLeft = new javax.swing.JTabbedPane();
        tpCenter = new javax.swing.JTabbedPane();
        mbMain = new javax.swing.JMenuBar();
        mFile = new javax.swing.JMenu();
        miNew = new javax.swing.JMenuItem();
        miOpen = new javax.swing.JMenuItem();
        spProject = new javax.swing.JPopupMenu.Separator();
        miSave = new javax.swing.JMenuItem();
        miSaveAs = new javax.swing.JMenuItem();
        spSave = new javax.swing.JPopupMenu.Separator();
        miPageSetup = new javax.swing.JMenuItem();
        miPrint = new javax.swing.JMenuItem();
        spExit = new javax.swing.JPopupMenu.Separator();
        miExit = new javax.swing.JMenuItem();
        mEdit = new javax.swing.JMenu();
        mView = new javax.swing.JMenu();
        miViewProjects = new javax.swing.JCheckBoxMenuItem();
        miViewConsole = new javax.swing.JCheckBoxMenuItem();
        mOptions = new javax.swing.JMenu();
        menuHelp = new javax.swing.JMenu();
        miAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JEdit 0.1");
        setMinimumSize(new java.awt.Dimension(1280, 800));

        tpLeft.setMinimumSize(new java.awt.Dimension(0, 0));
        getContentPane().add(tpLeft, java.awt.BorderLayout.LINE_START);
        getContentPane().add(tpCenter, java.awt.BorderLayout.CENTER);

        mFile.setMnemonic('F');
        mFile.setText("File");

        miNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miNew.setText("New");
        miNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewActionPerformed(evt);
            }
        });
        mFile.add(miNew);

        miOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miOpen.setText("Open Project");
        miOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOpenActionPerformed(evt);
            }
        });
        mFile.add(miOpen);
        mFile.add(spProject);

        miSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miSave.setText("Save");
        miSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSaveActionPerformed(evt);
            }
        });
        mFile.add(miSave);

        miSaveAs.setText("Save as");
        miSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSaveAsActionPerformed(evt);
            }
        });
        mFile.add(miSaveAs);
        mFile.add(spSave);

        miPageSetup.setText("Page setup");
        miPageSetup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPageSetupActionPerformed(evt);
            }
        });
        mFile.add(miPageSetup);

        miPrint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miPrint.setText("Print");
        miPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPrintActionPerformed(evt);
            }
        });
        mFile.add(miPrint);
        mFile.add(spExit);

        miExit.setText("Exit");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        mFile.add(miExit);

        mbMain.add(mFile);

        mEdit.setMnemonic('E');
        mEdit.setText("Edit");
        mbMain.add(mEdit);

        mView.setMnemonic('V');
        mView.setText("View");

        miViewProjects.setSelected(true);
        miViewProjects.setText("Projects");
        miViewProjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miViewProjectsActionPerformed(evt);
            }
        });
        mView.add(miViewProjects);

        miViewConsole.setSelected(true);
        miViewConsole.setText("Console");
        miViewConsole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miViewConsoleActionPerformed(evt);
            }
        });
        mView.add(miViewConsole);

        mbMain.add(mView);

        mOptions.setMnemonic('O');
        mOptions.setText("Options");
        mbMain.add(mOptions);

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

        mbMain.add(menuHelp);

        setJMenuBar(mbMain);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public abstract void miViewProjectsActionPerformed(ActionEvent evt);

    public abstract void miViewConsoleActionPerformed(ActionEvent evt);

    public abstract void miNewActionPerformed(ActionEvent evt);

    public abstract void miOpenActionPerformed(ActionEvent evt);

    public abstract void miSaveActionPerformed(ActionEvent evt);

    public abstract void miSaveAsActionPerformed(ActionEvent evt);

    public abstract void miPageSetupActionPerformed(ActionEvent evt);

    public abstract void miPrintActionPerformed(ActionEvent evt);

    public abstract void miExitActionPerformed(ActionEvent evt);

    public abstract void miAboutActionPerformed(ActionEvent evt);
}
