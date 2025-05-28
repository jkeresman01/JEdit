package com.keresman.editor.view.projects;

import com.keresman.editor.view.projects.designer.ProjectTreePanelDesigner;
import com.keresman.editor.model.FileTreeModel;
import com.keresman.utilities.ExceptionUtils;
import com.keresman.renderers.FileTreeCellRenderer;
import com.keresman.visitors.SimpleFileFinderVisitor;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProjectTreePanel extends ProjectTreePanelDesigner {

    private static final String EDITOR_PANEL_DESIGNER = "EditorPanelDesigner.java";
    private static final String FIND_FILE_THREAD = "FindFileThread";
    private static final String USER_DIR = "user.dir";

    public ProjectTreePanel() {
        super();
        initTree();
    }

    private void initTree() {
        trProjects.setCellRenderer(new FileTreeCellRenderer());

        Runnable task = () -> ExceptionUtils.executeUnchecked(
                () -> findFile(System.getProperty(USER_DIR), EDITOR_PANEL_DESIGNER),
                "Failed to find file: %s with root: %s".formatted(EDITOR_PANEL_DESIGNER, System.getProperty(USER_DIR))
        );

        new Thread(task, FIND_FILE_THREAD).start();
    }

    private void findFile(String path, String filename) throws IOException {
        Path rootPath = Paths.get(path);

        SimpleFileFinderVisitor fileFinderVisitor = new SimpleFileFinderVisitor(rootPath, filename);

        Files.walkFileTree(rootPath, fileFinderVisitor);

        File foundFile = fileFinderVisitor.getResult();

        if (foundFile != null) {
            setTreeModel(rootPath.toFile(), foundFile);
        }
    }

    private void setTreeModel(File root, File targetFile) {
        EventQueue.invokeLater(
                () -> trProjects.setModel(new FileTreeModel(root, targetFile)));
    }

}
