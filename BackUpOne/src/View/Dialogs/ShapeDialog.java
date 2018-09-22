package View.Dialogs;

import View.Enum.ShapeType;
import View.Interfaces.TypeListener;
import View.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ShapeDialog extends Dialog implements ActionListener {

    ArrayList<String> types = new ArrayList<String>();
    JComboBox comboBox;
    JButton okbtn;
    JButton canclebtn;
    TypeListener typeListener;

    public ShapeDialog() {
        super((Dialog) null, "Shape Choice", false);
        setSize(400,300);
//        setLocationRelativeTo(frame);

        for(ShapeType shapeType: ShapeType.values()) {
            types.add(shapeType.toString());
        }

        okbtn = new JButton("OK");
        canclebtn = new JButton("cancle");
        comboBox = new JComboBox(types.toArray());
        comboBox.setSelectedIndex(0);

        setLayout(new BorderLayout());
        add(comboBox, BorderLayout.NORTH);
        add(okbtn, BorderLayout.CENTER);
        add(canclebtn,BorderLayout.SOUTH);
        okbtn.addActionListener(this);
        canclebtn.addActionListener(this);


    }

    public void setTypeListener(TypeListener typeListener) {
        this.typeListener = typeListener;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton Source = (JButton) e.getSource();
        if(Source.equals(okbtn)) {
            String selectedItem = (String) comboBox.getSelectedItem();
            if(selectedItem.equals("rectangle")){
                typeListener.TypeEmitted(ShapeType.rectangle);
            }
            else if (selectedItem.equals("ellipse")) {
                typeListener.TypeEmitted(ShapeType.ellipse);
            }
            else if(selectedItem.equals("triangle")) {
                typeListener.TypeEmitted(ShapeType.triangle);
            }
            this.setVisible(false);
        }
        else {
            this.setVisible(false);
        }
    }
}
