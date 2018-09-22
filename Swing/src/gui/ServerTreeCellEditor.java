package gui;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class ServerTreeCellEditor extends AbstractCellEditor implements TreeCellEditor {

    private ServerTreeCellRenderer Renderer;
    private JCheckBox checkBox;
    private server info;


    public ServerTreeCellEditor() {
        Renderer = new ServerTreeCellRenderer();
    }

    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
       Component component= Renderer.getTreeCellRendererComponent(tree, value, isSelected, expanded, leaf, row, true);

        DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
        info = (server) node.getUserObject();

       if(leaf) {
           checkBox = (JCheckBox) component;

           checkBox.addItemListener(new ItemListener() {
               @Override
               public void itemStateChanged(ItemEvent e) {
                   fireEditingStopped();
                   checkBox.removeItemListener(this);
               }
           });
       }

       return component;
    }

    @Override
    public Object getCellEditorValue() {
        info.setChecked(checkBox.isSelected());
        return info;
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        if(! (anEvent instanceof MouseEvent)) return false;

        MouseEvent event = (MouseEvent) anEvent;

        JTree tree = (JTree) event.getSource();

        TreePath path = tree.getPathForLocation(event.getX(),event.getY());

        if(path ==null) return false;

        Object lastcomponent = path.getLastPathComponent();

        if (lastcomponent == null) return false;

        DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode)lastcomponent;

        return treeNode.isLeaf();

    }
}
