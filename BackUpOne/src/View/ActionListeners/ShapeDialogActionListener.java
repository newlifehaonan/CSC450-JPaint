package View.ActionListeners;

import View.Dialogs.ShapeDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeDialogActionListener implements ActionListener {

    ShapeDialog shapeDialog;

    public ShapeDialogActionListener(ShapeDialog shapeDialog) {
        this.shapeDialog = shapeDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        shapeDialog.setVisible(true);
    }
}
