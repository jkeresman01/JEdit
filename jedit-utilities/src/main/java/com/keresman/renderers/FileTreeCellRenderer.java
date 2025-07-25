package com.keresman.renderers;

import java.awt.Component;
import java.io.File;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class FileTreeCellRenderer extends DefaultTreeCellRenderer {

  @Override
  public Component getTreeCellRendererComponent(
      JTree tree,
      Object value,
      boolean selected,
      boolean expanded,
      boolean leaf,
      int row,
      boolean hasFocus) {
    super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

    setIcon(leaf ? getLeafIcon() : expanded ? getOpenIcon() : getClosedIcon());

    if (value instanceof File file) {
      setText(file.getName().isEmpty() ? file.getPath() : file.getName());
    }

    return this;
  }
}
