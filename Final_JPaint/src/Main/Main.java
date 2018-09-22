package Main;

import Controller.ConnectEvent;
import Model.ApplicationState;
import Model.Interfaces.IApplicationState;
import View.*;
import View.Interfaces.GuiControl;
import View.Interfaces.IDrawCanvas;

import java.awt.*;



public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GuiControl guiControl = new Toolbar();
                Gui gui = new Gui(guiControl);
                IApplicationState applicationState = new ApplicationState(gui);
                ShapeList shapeList = new ShapeList(applicationState);
                IDrawCanvas drawCanvas = new DrawCanvas(shapeList);
                ConnectEvent connectEvent = new ConnectEvent(gui, applicationState, drawCanvas, shapeList);
                MainFrame mainFrame = new MainFrame(guiControl, drawCanvas,applicationState, shapeList);
                connectEvent.addEventToButton();
            }
        });

    }
}
