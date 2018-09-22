package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.ShapeConfiguration;
import model.ShapeList;
import model.persistence.ApplicationState;
import view.gui.DrawClickHandler;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.awt.*;

public class Main {

    public static void main(String[] args){

        ShapeList shapeList = new ShapeList();
        ShapeConfiguration shapeConfiguration = new ShapeConfiguration();
        PaintCanvas paintCanvas = new PaintCanvas(shapeList);
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);

        ApplicationState applicationState = new ApplicationState(uiModule);

        //additions

        paintCanvas.addMouseListener(new DrawClickHandler(applicationState, shapeList, shapeConfiguration));
        paintCanvas.setCursor((new Cursor(Cursor.CROSSHAIR_CURSOR)));

        IJPaintController controller = new JPaintController(uiModule, applicationState);
        controller.setup();

    //set paint canvas

    }
}
