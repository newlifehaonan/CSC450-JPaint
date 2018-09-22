package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.prefs.Preferences;


public class mainFrame extends JFrame {


    /*

    This is kind of MVC pattern
     */

//    private TextPanel textPanel;

    private JButton btn;

    private Toolbar toolbar;

    private FormPanel formPanel;

    private JFileChooser fileChooser;

    private Controller controller;

    private TablePanel tablePanel;

    private JTabbedPane tabbedPane;

    private PreferenceDialog preferenceDialog;

    private Preferences preferences;

    private JSplitPane SplitPane;

    private TreePane treePane;

    public mainFrame() {

        /* set basic Jframe
         1. initiate Jframe
         2. setDefaultcloseOperation
         3. setSize
         4. setVisible
        */

        super("Hello world");

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setMinimumSize(new Dimension(600,500));

        setSize(700,600);

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                try {
                    controller.disconnect();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                dispose();

                System.gc();

            }
        });



        /*
        set layout

        https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html

        1. initiate your layout first
        2. initiate what component you want
        3. where you wanna set it
         */

        setLayout(new BorderLayout());

//        this.textPanel  = new TextPanel();
        this.btn = new JButton("click");

//        add(textPanel, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);


        /*
        add listener

        1. addActionListener is a interfaces
         */

//        btn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                textPanel.appendtext("Submitted\n");
//            }
//        });



        /*
        add ToolBar

         */

        this.toolbar = new Toolbar();
        add(toolbar, BorderLayout.PAGE_START);


        /*
        Get Text and toolbar component communicated

        best way is to program to interfaces

        we can also tightly coupled two component but it not a good software engineering practice
         */

        toolbar.setToolbarListener(new ToolbarListener() {


            @Override
            public void saveEventOccur() {

                connect();

                try {
                    controller.save();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(mainFrame.this, "Cannot connected to database","Database connection error", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void refreshEventOccur() {

                connect();

                try {
                    controller.refresh();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(mainFrame.this, "Cannot connected to database","Database connection error", JOptionPane.ERROR_MESSAGE);
                }

                tablePanel.refresh();
            }
        });


        /*
        set form panel

        get form text and append to textarea
         */

        this.formPanel = new FormPanel();
//        add(formPanel, BorderLayout.WEST);

        /*
        set up database connection
         */

        this.controller = new Controller();


        formPanel.setFormListener( new FormListener() {
            public void FormEventOccured(FormEvent event) {

//                String name = event.getName();
//                String occupation = event.getOccupation();
//                int ageCat = event.getageid();
//                String employment = event.getEmployment();
//                Boolean iscitizen = event.isCitizen();
//                String taxid = event.getTaxID();
//                String sex = event.getGender();
//
//                textPanel.appendtext(name + ": " + sex + ": " + ageCat + ": " + occupation + ": " + employment + ": "+ iscitizen + ": "+ taxid + "\n");

                controller.addPerson(event);
                tablePanel.refresh();

            }
        });

        /*
        set Table panel
         */

        this.tablePanel = new TablePanel();
//        add(tablePanel, BorderLayout.CENTER);
        tablePanel.setdata(controller.getpeople());

        tablePanel.setDataListener( new DataListener() {

            public void deletedata(int row) {
                controller.deleteperson(row);
                tablePanel.refresh();
            }
        });
        /*
        set up tree
         */
        this.treePane = new TreePane();

        /*
        set up tabbed pane
         */

        this.tabbedPane = new JTabbedPane();

        tabbedPane.add(tablePanel,"Person database");
        tabbedPane.add(treePane, "Messages");


        /*
        set split pane
         */


        SplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, formPanel, tabbedPane);
        add(SplitPane,BorderLayout.CENTER);

        SplitPane.setOneTouchExpandable(true);

        /*
         * set Menu bar.
         */

        setJMenuBar(CreateMenuBar());

        /*
        set the file chooser
         */
        this.fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new HtmlFileChooser());

        /*
        set up preference dialog
         */
        this.preferenceDialog = new PreferenceDialog(this);

        this.preferences = Preferences.userRoot().node("db");




        preferenceDialog.setPreference(new PreferenceListener() {
            @Override
            public void setPreference(String name, String password, int port) {

                preferences.put("user", name);
                preferences.put("password",password);
                preferences.putInt("port",port);

            }
        });

        preferenceDialog.setDefaultUser(preferences.get("user",""), preferences.get("password",""), preferences.getInt("port",3306));


    }

    private void connect() {
        try {
            controller.connect();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainFrame.this, "Cannot connected to database","Database connection error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JMenuBar CreateMenuBar() {
        JMenuBar menuBar = new JMenuBar();

//       File Menu
        JMenu File = new JMenu("File");
        File.setMnemonic(KeyEvent.VK_F);

        JMenuItem exportItem = new JMenuItem("Export File");
        JMenuItem importItem = new JMenuItem("Import File");
        JMenuItem exitItem = new JMenuItem("Exit");

        importItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int exp = fileChooser.showOpenDialog(mainFrame.this);

                if (exp == JFileChooser.APPROVE_OPTION) {
                    try {
                        tablePanel.refresh();
                        controller.importFromFile(fileChooser.getSelectedFile());
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(mainFrame.this,"Can't import file","ERRO",JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });

        exportItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int exp = fileChooser.showSaveDialog(mainFrame.this);


                if (exp == JFileChooser.APPROVE_OPTION) {

                    try {
                        controller.saveToFile(fileChooser.getSelectedFile());
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(mainFrame.this,"Can't export file","ERRO",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int comfirmexit = JOptionPane.showConfirmDialog(mainFrame.this, "Do You Really Wanna Exit?", "Exit Comfirm", JOptionPane.OK_CANCEL_OPTION);

                if (comfirmexit == JOptionPane.OK_OPTION) {

                    WindowListener[] windowListeners = getWindowListeners();

                    for (WindowListener windowListener: windowListeners) {
                        windowListener.windowClosing(new WindowEvent(mainFrame.this, 0));
                    }
                }
            }
        });

        exitItem.setMnemonic(KeyEvent.VK_E);
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

        File.add(exportItem);
        File.add(importItem);
        File.addSeparator();
        File.add(exitItem);


//      Window Menu

        JMenu Window = new JMenu("Window");

        JMenuItem Pref = new JMenuItem("Preferences");
        JMenu form = new JMenu("Form");
        JCheckBoxMenuItem personForm = new JCheckBoxMenuItem("Personal Form");
        personForm.setSelected(true);

        personForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem personalformitem = (JCheckBoxMenuItem) e.getSource();

                if (form.isSelected()) {
                    SplitPane.setDividerLocation((int) formPanel.getMaximumSize().getWidth());
                }

                formPanel.setVisible(personalformitem.isSelected());
            }
        });

        Pref.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                preferenceDialog.setVisible(true);

            }
        });

        form.add(personForm);
        Window.add(form);
        Window.add(Pref);

        menuBar.add(File);
        menuBar.add(Window);

        return menuBar;
    }
}
