package gui;


import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class ServerTreeCellRenderer implements TreeCellRenderer {


    private JCheckBox leafnode;
    private DefaultTreeCellRenderer nonleafnode;

    public ServerTreeCellRenderer() {
        this.leafnode = new JCheckBox();
        this.nonleafnode = new DefaultTreeCellRenderer();



        nonleafnode.setLeafIcon(CreateIcon("/img/Server16.gif"));
        nonleafnode.setOpenIcon(CreateIcon("/img/WebComponent16.gif"));
        nonleafnode.setClosedIcon(CreateIcon("/img/WebComponentAdd16.gif"));
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {


        if(leaf) {

            DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;

            server servernode = (server) node.getUserObject();

            leafnode.setText(servernode.toString());
            leafnode.setSelected(servernode.isChecked());

            return leafnode;

        }
        else {

            return nonleafnode.getTreeCellRendererComponent(tree, value, selected, expanded, leaf,row, hasFocus);
        }
    }


    public ImageIcon CreateIcon(String path) {

        URL url = getClass().getResource(path);

        if (url == null) {
            System.out.println("can not get path!");
        }

        ImageIcon imageIcon = new ImageIcon(url);

        return imageIcon;
    }
}
