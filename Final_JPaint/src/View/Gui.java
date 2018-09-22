package View;

import Controller.Interfaces.ICommand;
import View.Adaptor.ButtonListener;
import View.Enum.EventName;
import View.Interfaces.GuiControl;
import View.Interfaces.Idialog;
import View.Interfaces.UiModule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Gui implements UiModule {

    GuiControl guiControl;

    ActionListener buttonListener;

    public Gui(GuiControl guiControl) {
        this.guiControl = guiControl;
    }


    @Override
    public void addEvent(EventName eventName, ICommand iCommand) {
        JButton selectedButton = guiControl.getButton(eventName);
        buttonListener = new ButtonListener(iCommand);
        selectedButton.addActionListener(buttonListener);
    }

    @Override
    public <T> T getDialogResponse(Idialog dialogSettings) {
        Object selectedValue = JOptionPane.showInputDialog(
                null,
                dialogSettings.getDialogText(),
                dialogSettings.getDialogTitle(),
                JOptionPane.PLAIN_MESSAGE,
                null,
                dialogSettings.getDialogOptions(),
                dialogSettings.getCurrentSelection()
        );

        return selectedValue == null
                ? (T)dialogSettings.getDialogOptions()
                : (T)selectedValue;
    }

    @Override
    public void addAccelorator(EventName eventName, int keyshortcut) {
        JButton selectedButton = guiControl.getButton(eventName);
        selectedButton.setMnemonic(keyshortcut);

        selectedButton.registerKeyboardAction(buttonListener,KeyStroke.getKeyStroke(keyshortcut, KeyEvent.CTRL_DOWN_MASK),0);
//        selectedButton.registerKeyboardAction(buttonListener,KeyStroke.getKeyStroke(keyshortcut, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()),0);
    }
}
