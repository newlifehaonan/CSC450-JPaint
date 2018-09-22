package View;

import View.Enum.EventName;
import View.Interfaces.GuiControl;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class Toolbar extends JPanel implements GuiControl {


    Map<EventName, JButton> buttons = new HashMap<>();
//    private PointListener typeListener;

    public Toolbar() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        createbutton();

    }

    private void createbutton() {
        for (EventName type : EventName.values()) {
            String typeStr = type.toString();
            JButton thisButton = new JButton(typeStr);
            buttons.put(type, thisButton);
            add(thisButton);
        }
    }

    public JButton getButton(EventName eventName) {
        return buttons.get(eventName);
    }

}
