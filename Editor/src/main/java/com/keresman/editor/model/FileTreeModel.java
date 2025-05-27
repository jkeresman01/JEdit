package com.keresman.editor.model;

import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FileTreeModel extends FileTreeModelAdapter {

    private final Map<File, List<File>> map = new HashMap<>();
    private final File root;
    private final File targetFile;

    public FileTreeModel(File root, File targetFile) {
        this.targetFile = targetFile;
        this.root = root;
    }

    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public boolean isLeaf(Object node) {
        return ((File) node).isFile();
    }

    @Override
    public int getChildCount(Object parent) {
        Optional<List<File>> children = getChildren(parent);
        return children.isPresent() ? children.get().size() : 0;
    }

    @Override
    public Object getChild(Object parent, int index) {
        Optional<List<File>> children = getChildren(parent);
        if (children.isPresent() && children.get().size() > index) {
            return children.get().get(index);
        }
        throw new RuntimeException("No child on index");
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        Optional<List<File>> children = getChildren(parent);
        if (children.isPresent()) {
            return children.get().indexOf(child);
        }
        throw new RuntimeException("No such child");
    }

    private Optional<List<File>> getChildren(Object node) {
        File parent = (File) node;
        if (!parent.isDirectory()) {
            return Optional.empty();
        }
        List<File> children = map.get(parent);
        if (children == null) {
            File[] files = parent.listFiles();
            if (files == null) {
                return Optional.empty();
            }
            children = new ArrayList<>();
            for (File file : files) {
                String targetFileAbsPath = targetFile.getAbsolutePath().toLowerCase();
                String fileAbsPath = file.getAbsolutePath().toLowerCase();
                
                if (!targetFileAbsPath.startsWith(fileAbsPath)) {
                    children.add(file);
                }
            }
            map.put(parent, children);
        }
        return Optional.of(children);
    }
}
