package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Toolbar extends JToolBar implements ActionListener {

    private JButton savebtn;
    private JButton refreshbtn;

    private ToolbarListener toolbarListener;



    public Toolbar() {

        this.savebtn = new JButton();
        this.refreshbtn = new JButton();


        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(savebtn);

        addSeparator();
        add(refreshbtn);

        savebtn.addActionListener(this);
        savebtn.setIcon(CreateIcon("/img/Save16.gif"));
        savebtn.setToolTipText("Save");


        refreshbtn.addActionListener(this);
        refreshbtn.setIcon(CreateIcon("/img/Refresh16.gif"));
        refreshbtn.setToolTipText("Refresh");


    }

    private ImageIcon CreateIcon(String path) {

        URL url = getClass().getResource(path);

        if (url == null) {
            System.out.println("can not get path!");
        }

        ImageIcon imageIcon = new ImageIcon(url);

        return imageIcon;
    }

    public void setToolbarListener(ToolbarListener toolbarListener) {

        this.toolbarListener = toolbarListener;

    }

    public void actionPerformed(ActionEvent e) {

        JButton resource = (JButton)e.getSource();

        if (resource == savebtn) {

            if (toolbarListener != null) {
                toolbarListener.saveEventOccur();
            }
        }

        else  if (resource == refreshbtn) {


            if (toolbarListener != null) {
                toolbarListener.refreshEventOccur();
            }
        }
    }

}
