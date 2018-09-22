package Controller;

import Controller.Command.*;
import Controller.Interfaces.ICommand;
import Model.Interfaces.IApplicationState;
import View.Enum.EventName;
import View.Interfaces.IDrawCanvas;
import View.Interfaces.UiModule;
import View.ShapeList;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ConnectEvent {

    private UiModule uiModule;
    private IApplicationState applicationState;
    private IDrawCanvas canvas;
    private ShapeList shapeList;

    public ConnectEvent(UiModule uiModule, IApplicationState applicationState, IDrawCanvas canvas, ShapeList shapeList) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.canvas = canvas;
        this.shapeList =shapeList;
    }


    public void addEventToButton() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, ()->applicationState.setActiveShape());

        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, ()->applicationState.setActivePrimaryColor());

        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, ()->applicationState.setActiveSecondaryColor());

        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, ()->applicationState.setActiveShadingType());

        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, ()->applicationState.setActiveStartAndEndPointMode());

        uiModule.addEvent(EventName.DELETE, new DeleteShapeCommand(applicationState, shapeList));
        uiModule.addAccelorator(EventName.DELETE, KeyEvent.VK_DELETE);

        uiModule.addEvent(EventName.PASTE, new PasteShapeCommand(applicationState,shapeList));
        uiModule.addAccelorator(EventName.PASTE, KeyEvent.VK_P);

        uiModule.addAccelorator(EventName.COPY, KeyEvent.VK_C);

        uiModule.addEvent(EventName.UNDO, new UndoCommand());
        uiModule.addAccelorator(EventName.UNDO, KeyEvent.VK_U);

        uiModule.addEvent(EventName.REDO, new RedoCommand());
        uiModule.addAccelorator(EventName.REDO, KeyEvent.VK_R);

    }

}
