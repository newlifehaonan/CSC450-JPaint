package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class FormPanel extends JPanel  {


    private JTextField name;
    private JTextField occupation;
    private JLabel namelabel;
    private JLabel occupationlabel;
    private JButton okbtn;
    private JList agelist;
    private JComboBox employCombox;
    private JCheckBox citizenship;
    private JLabel TaxIDLabel;
    private JTextField TaxID;
    private JRadioButton maleradio;
    private JRadioButton femaleradio;
    private ButtonGroup gender;


//    private FormEvent formEvent;

    private FormListener formListener;

    public FormPanel() {

        this.name = new JTextField(10);
        this.occupation = new JTextField(10);
        this.namelabel = new JLabel("Name:");
        this.occupationlabel = new JLabel("Occupation:");
        this.okbtn = new JButton("OK");
        this.agelist = new JList();
        this.employCombox = new JComboBox();
        this.citizenship = new JCheckBox();
        this.TaxIDLabel = new JLabel("Tax ID:");
        this.TaxID = new JTextField(10);
        this.maleradio = new JRadioButton("Male");
        this.femaleradio = new JRadioButton("Female");
        this.gender = new ButtonGroup();

        /*
        Set Mnemonic for field
         */
        okbtn.setMnemonic(KeyEvent.VK_O);
        namelabel.setDisplayedMnemonic(KeyEvent.VK_N);
        namelabel.setLabelFor(name);

        /*
         * set radio group
         */
        maleradio.setSelected(true);
        gender.add(femaleradio);
        gender.add(maleradio);
        maleradio.setActionCommand("male");
        femaleradio.setActionCommand("female");


        /*
        set check box
        when check TaxID textfield is enabled
         */
        TaxIDLabel.setEnabled(false);
        TaxID.setEnabled(false);

        citizenship.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean ischecked = citizenship.isSelected();

                if(ischecked) {
                    TaxID.setEnabled(true);
                    TaxIDLabel.setEnabled(true);
                }
                else if (!ischecked) {
                    TaxID.setEnabled(false);
                    TaxIDLabel.setEnabled(false);
                }
            }
        });

        /*
        set list box
         */

        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new ageCatmodel(0, "< 18"));
        ageModel.addElement(new ageCatmodel(1, "18 ~ 65"));
        ageModel.addElement(new ageCatmodel(2, "> 65"));
        agelist.setModel(ageModel);
        agelist.setPreferredSize(new Dimension(110, 70));
        agelist.setBorder(BorderFactory.createEtchedBorder());
        agelist.setSelectedIndex(1);

        /*

        set combo box
         */

        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        comboBoxModel.addElement("employed");
        comboBoxModel.addElement("self-employed");
        comboBoxModel.addElement("unemployed");
        employCombox.setModel(comboBoxModel);
        employCombox.setPreferredSize(new Dimension(110, 30));
        employCombox.setEditable(true);

        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
        setMinimumSize(dim);

        /*
        * Set marging using empty border
        * set pading using any other kinds of border
        * user compound border to combine them together
        * */

        Border inner = BorderFactory.createTitledBorder("Hello Haonan");
        Border outer = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(inner,outer));




        /*
         * use gridbaglayout to set the space between component.
         */

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();



        gc.gridy = 0;

//        first row.

        gc.weightx = 1;

        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0 , 0, 5);
        add(namelabel, gc);

        gc.gridy = 0;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0 , 0, 0);
        add(name, gc);

//      next row

        gc.gridy++;

        gc.weightx = 1;

        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0 , 0, 5);
        add(occupationlabel, gc);

        gc.gridy = 1;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0 , 0, 0);
        add(occupation, gc);


        //  next  row

        gc.gridy++;

        gc.weightx = 1;

        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0 , 0, 5);
        add(new JLabel("Age:"), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0 , 0, 0);
        add(agelist, gc);

        //  next  row

        gc.gridy++;

        gc.weightx = 1;

        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0 , 0, 5);
        add(new JLabel("employmnent:"), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0 , 0, 0);
        add(employCombox, gc);

        //  next  row

        gc.gridy++;

        gc.weightx = 1;

        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0 , 0, 5);
        add(new JLabel("US citizen:"), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0 , 0, 0);
        add(citizenship, gc);

        //  next  row

        gc.gridy++;

        gc.weightx = 1;

        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0 , 0, 5);
        add(TaxIDLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0 , 0, 0);
        add(TaxID, gc);

        //  next  row

        gc.gridy++;

        gc.weightx = 1;

        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0 , 0, 5);
        add(new JLabel("Gender:"), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0 , 0, 0);
        add(maleradio, gc);

        //  next  row

        gc.gridy++;

        gc.weightx = 1;

        gc.weighty = 0.1;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0 , 0, 0);
        add(femaleradio, gc);


//        next row
        gc.gridy++;

        gc.weightx = 1;

        gc.weighty = 2;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0 , 0, 0);
        add(okbtn, gc);


        okbtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String Name = name.getText();

                String Occupation = occupation.getText();

                ageCatmodel ageCat = (ageCatmodel) agelist.getSelectedValue();

                String employment = (String) employCombox.getSelectedItem();

                Boolean iscitizen = citizenship.isSelected();

                String taxid = (String) TaxID.getText();

                String sex = gender.getSelection().getActionCommand();


                if(formListener != null) {
                    formListener.FormEventOccured(new FormEvent(this, Name, Occupation, ageCat, employment, iscitizen, taxid, sex));
                }

            }
        });
    }


    public void setFormListener(FormListener formListener) {

        this.formListener = formListener;
    }

}

class ageCatmodel {

    private int id;
    private String agecat;

    public ageCatmodel(int id, String agecat) {

        this.id = id;
        this.agecat = agecat;
    }

    public int getid() {

        return id;
    }

    public String toString() {

        return agecat;
    }
}
