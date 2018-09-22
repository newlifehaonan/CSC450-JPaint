package gui;
import controller.MessageServer;
import model.Message;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeSelectionModel;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TreePane extends JPanel {


    private JTree ServerTree;
    private ServerTreeCellRenderer TreeRenderer;
    private ServerTreeCellEditor treeCellEditor;
    private Set<Integer> SelectedServer;
    private MessageServer messageServer;
    private ProgressDialog progressDialog;

    public TreePane() {

        this.progressDialog = new ProgressDialog((Window) getParent());


        SelectedServer = new TreeSet<>();


        setLayout(new BorderLayout());
        this.messageServer = new MessageServer();

        this.TreeRenderer = new ServerTreeCellRenderer();

        this.treeCellEditor = new ServerTreeCellEditor();

        this.ServerTree = new JTree(createTree());
        ServerTree.setCellRenderer(TreeRenderer);
        ServerTree.setCellEditor(treeCellEditor);
        ServerTree.setEditable(true);


        add(new JScrollPane(ServerTree), BorderLayout.CENTER);

        ServerTree.getSelectionModel().setSelectionMode(DefaultTreeSelectionModel.SINGLE_TREE_SELECTION);

        treeCellEditor.addCellEditorListener(new CellEditorListener() {
                                                 @Override
                                                 public void editingStopped(ChangeEvent e) {
                                                     server info = (server) treeCellEditor.getCellEditorValue();
                                                     System.out.println("ID:" + info.getId() + " Name:" + info.getName() + " isChecked:" + info.isChecked());

                                                     SwingUtilities.invokeLater(new Runnable() {
                                                         @Override
                                                         public void run() {
                                                             progressDialog.setVisible(true);
                                                         }
                                                     });

                                                     int ServerId = info.getId();

                                                     if(info.isChecked()) {
                                                         SelectedServer.add(ServerId);
                                                     }
                                                     else {
                                                         SelectedServer.remove(ServerId);
                                                     }

                                                     messageServer.setSelectedServers(SelectedServer);

                                                     retrievemessages();


                                                 }

                                                 @Override
                                                 public void editingCanceled(ChangeEvent e) {

                                                 }
                                             }
        );
    }

    private void retrievemessages() {

        System.out.println("Message waiting:" + messageServer.getMessagecount());

        SwingWorker<List<Message>, Integer> swingWorker = new SwingWorker<List<Message>, Integer>() {

            @Override
            protected List<Message> doInBackground() throws Exception {

                ArrayList<Message> retrievingmessges = new ArrayList<>();
                int count = 0;
                for(Message message : messageServer) {

                    System.out.println(message.getName());

                    retrievingmessges.add(message);

                    count++;
                }

                return retrievingmessges;
            }

            @Override
            protected void process(java.util.List<Integer> counts) {

                int retrieved = counts.get(counts.size()-1);

                System.out.println("Got " + retrieved + " messages");

            }

            @Override
            protected void done() {

                try {
                    List<Message> retrivedmessages = get();

                    progressDialog.setVisible(false);

                    System.out.println("Retrieved " + retrivedmessages.size() + " Messages");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }
        };

        swingWorker.execute();
    }


    private DefaultMutableTreeNode createTree() {
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Server");

        DefaultMutableTreeNode branch1 = new DefaultMutableTreeNode("USA");

        DefaultMutableTreeNode server1 = new DefaultMutableTreeNode(new server(0, "Chicago",SelectedServer.contains(0)));

        DefaultMutableTreeNode server2 = new DefaultMutableTreeNode(new server(1,"New York",SelectedServer.contains(0)));

        branch1.add(server1);
        branch1.add(server2);

        DefaultMutableTreeNode branch2 = new DefaultMutableTreeNode("China");

        DefaultMutableTreeNode server3 = new DefaultMutableTreeNode(new server(2, "Beijing",SelectedServer.contains(0)));

        DefaultMutableTreeNode server4 = new DefaultMutableTreeNode(new server(3, "ShangHai",SelectedServer.contains(0)));

        branch2.add(server3);
        branch2.add(server4);

        top.add(branch1);
        top.add(branch2);

        return top;


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

class server {
    private int id;
    private String name;
    private boolean checked;

    public server(int id, String name, boolean checked) {

        this.id =  id;

        this.name = name;

        this.checked = checked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return this.checked;
    }


    public String toString() {
        return name;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}