package com.keresman.components;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public final class ClosablePanel {

  private ClosablePanel() {
    // Suppresses default constructor, ensuring non-instantiability.
  }

  public static void attachTo(JTabbedPane tabbedPane, JComponent panel, String title) {
    attachTo(tabbedPane, panel, title, null);
  }

  public static void attachTo(JTabbedPane tabbedPane, JComponent panel, String title, Icon icon) {
    tabbedPane.addTab(title, icon, panel);
    int tabIndex = tabbedPane.indexOfComponent(panel);

    Component tabHeader = buildTabHeader(tabbedPane, panel, title, icon);
    tabbedPane.setTabComponentAt(tabIndex, tabHeader);
    tabbedPane.setSelectedComponent(panel);
  }

  private static Component buildTabHeader(
      JTabbedPane tabbedPane, Component panel, String title, Icon icon) {
    JPanel header = createHeaderPanel();
    header.add(createTitleLabel(title, icon));
    header.add(createCloseButton(tabbedPane, panel));
    return header;
  }

  private static JPanel createHeaderPanel() {
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
    panel.setOpaque(false);
    return panel;
  }

  private static JLabel createTitleLabel(String title, Icon icon) {
    JLabel label = new JLabel(title);
    label.setIcon(icon);
    label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
    return label;
  }

  private static JButton createCloseButton(JTabbedPane tabbedPane, Component panel) {
    JButton closeButton = new JButton("X");
    closeButton.setFocusable(false);
    closeButton.setContentAreaFilled(false);
    closeButton.setBorder(BorderFactory.createEmptyBorder());
    closeButton.setMargin(new Insets(0, 5, 0, 5));

    closeButton.addActionListener(e -> removeTab(tabbedPane, panel));
    return closeButton;
  }

  private static void removeTab(JTabbedPane tabbedPane, Component panel) {
    int index = tabbedPane.indexOfComponent(panel);
    if (index != -1) {
      tabbedPane.removeTabAt(index);
    }
  }
}
