package View;

import View.ActionListeners.ShapeDialogActionListener;
import View.Dialogs.ColorDialog;
import View.Dialogs.ShapeDialog;
import View.Enum.ShapeColor;
import View.Enum.ShapeType;
import View.Interfaces.ColorListener;
import View.Interfaces.TypeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Toolbar extends JPanel {

    private JButton involkShapeDialogbtn;
    private JButton involkColorDialogbtn;

    private ShapeDialog shapeDialog;
    private ColorDialog colorDialog;


    private TypeListener typeListener;
    private ColorListener colorListener;


    public Toolbar() {

        involkShapeDialogbtn = new JButton("Choose Shape");
        involkColorDialogbtn = new JButton("Choose Color");

        shapeDialog = new ShapeDialog();
        colorDialog = new ColorDialog();

        add(involkShapeDialogbtn);
        add(involkShapeDialogbtn);

        involkShapeDialogbtn.addActionListener(new ShapeDialogActionListener(shapeDialog));

        setLayout(new FlowLayout(FlowLayout.LEFT));

        shapeDialog.setTypeListener(new TypeListener() {
            @Override
            public void TypeEmitted(ShapeType shapeType) {
                typeListener.TypeEmitted(shapeType);
            }
        });

        colorDialog.setColorListener(new ColorListener() {
            @Override
            public void ColorEmitted(ShapeColor shapeColor) {
                colorListener.ColorEmitted(shapeColor);
            }
        });

    }


    public void setTypeListener(TypeListener typeListener) {
        this.typeListener = typeListener;
    }


}
