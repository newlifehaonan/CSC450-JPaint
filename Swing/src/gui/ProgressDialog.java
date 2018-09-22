package gui;

import javax.swing.*;
import java.awt.*;

public class ProgressDialog extends JDialog {

    private JDialog retrieveDialog;
    public ProgressDialog(Window parent) {
        super(parent, "Message Downloading....",ModalityType.APPLICATION_MODAL);
        setSize(200,200);
    }
}
