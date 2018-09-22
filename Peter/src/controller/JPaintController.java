package controller;

import model.command.DeleteCommand;
import model.interfaces.IApplicationState;
import model.shape.ShapeList;
import view.EventName;
import view.interfaces.IUiModule;
import view.gui.*;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private PaintCanvas canvas;
    private ShapeList shapelist;
    public JPaintController(IUiModule uiModule, IApplicationState applicationState,PaintCanvas canvas,ShapeList shapelist) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.canvas=canvas;
        this.shapelist=shapelist;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.DELETE, new DeleteCommand(this.canvas,this.shapelist));
}}
