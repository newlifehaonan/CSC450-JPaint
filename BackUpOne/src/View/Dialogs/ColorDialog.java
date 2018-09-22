package View.Dialogs;

import View.Enum.ShapeColor;
import View.Enum.ShapeType;
import View.Interfaces.ColorListener;
import View.Interfaces.TypeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ColorDialog extends JDialog implements ActionListener {
    ArrayList<String> colorlist = new ArrayList<String>();
    JComboBox comboBox;
    JButton okbtn;
    JButton canclebtn;
    ColorListener colorListener;

    public ColorDialog() {
        super((Dialog) null,"Color Dialog",false);
        setSize(400,300);

        for(ShapeColor shapeColor : ShapeColor.values()) {
            colorlist.add(shapeColor.toString());
        }

        okbtn = new JButton("OK");
        canclebtn = new JButton("cancle");
        comboBox = new JComboBox(colorlist.toArray());
        comboBox.setSelectedIndex(0);

        setLayout(new BorderLayout());
        add(comboBox, BorderLayout.NORTH);
        add(okbtn, BorderLayout.CENTER);
        add(canclebtn,BorderLayout.SOUTH);
        okbtn.addActionListener(this);
        canclebtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton Source = (JButton) e.getSource();
        if(Source.equals(okbtn)) {
            String selectedItem = (String) comboBox.getSelectedItem();
            if(selectedItem.equals("blue")){
                colorListener.ColorEmitted(ShapeColor.blue);
            }
            else if (selectedItem.equals("red")) {
                colorListener.ColorEmitted(ShapeColor.red);
            }
            this.setVisible(false);
        }
        else {
            this.setVisible(false);
        }

    }

    public void setColorListener(ColorListener colorListener) {
        this.colorListener = colorListener;
    }
}
