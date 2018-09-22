package View.Adaptor;

import Controller.Interfaces.ICommand;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    ICommand iCommand;
    public ButtonListener(ICommand iCommand) {
        this.iCommand = iCommand;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        iCommand.excute();
    }
}
