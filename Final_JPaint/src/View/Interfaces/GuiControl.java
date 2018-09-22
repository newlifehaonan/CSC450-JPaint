package View.Interfaces;

import View.Enum.EventName;

import javax.swing.*;

public interface GuiControl {

    JButton getButton(EventName eventName);
}

