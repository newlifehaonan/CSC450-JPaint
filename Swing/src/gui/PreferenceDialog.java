package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.PreferenceChangeListener;

public class PreferenceDialog extends JDialog {

    private JButton okbtn;
    private JButton Cancelbtn;
    private JSpinner portspinner;
    private SpinnerNumberModel spinnerNumberModel;
    private JTextField user;
    private JPasswordField password;
    private PreferenceListener preferenceListener;


    public PreferenceDialog(JFrame parent) {
        super(parent, "Preferences",false);


        this.okbtn = new JButton("OK");
        this.Cancelbtn = new JButton("Cancel");
        this.spinnerNumberModel = new SpinnerNumberModel(3306,0,9999,1);
        this.portspinner = new JSpinner(spinnerNumberModel);
        this.user = new JTextField(10);
        this.password = new JPasswordField(10);
        password.setEchoChar('*');
        user.setVisible(true);

        setSize(400,300);
        setLocationRelativeTo(parent);


        setlayout();

        okbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = user.getText();
                char[] PassWord = password.getPassword();
                Integer portnum = (Integer) portspinner.getValue();

                if (preferenceListener != null) {

                    preferenceListener.setPreference(username, new String(PassWord), portnum);

                }

                setVisible(false);

            }
        });

        Cancelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

    }

    public void setPreference(PreferenceListener preferenceListener) {
        this.preferenceListener = preferenceListener;
    }


    public void setDefaultUser(String username, String Password, int port) {
        this.user.setText(username);
        this.password.setText(Password);
        this.portspinner.setValue(port);
    }

    public void setlayout() {

        JPanel controlpanel = new JPanel();
        JPanel btnpanel = new JPanel();

        Border titleborder = new TitledBorder("Database Preference");
        Border outerborder = new EmptyBorder(10,10,10,10);

        controlpanel.setBorder(BorderFactory.createCompoundBorder(outerborder,titleborder));


        controlpanel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

//        First row

        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = new Insets(15,15,15,15);
        controlpanel.add(new JLabel("User: "),gc);
        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        controlpanel.add(user,gc);

//        next row

        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = new Insets(15,15,15,15);
        controlpanel.add(new JLabel("Password: "),gc);
        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        controlpanel.add(password,gc);

//        next row

        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = new Insets(15,15,15,15);
        controlpanel.add(new JLabel("Port: "), gc);
        gc.gridx ++;
        gc.anchor = GridBagConstraints.WEST;
        controlpanel.add(portspinner,gc);

//        next row


        btnpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        okbtn.setPreferredSize(Cancelbtn.getPreferredSize());
        btnpanel.add(okbtn, gc);
        btnpanel.add(Cancelbtn, gc);


        add(controlpanel,BorderLayout.CENTER );
        add(btnpanel, BorderLayout.SOUTH);
    }
}
