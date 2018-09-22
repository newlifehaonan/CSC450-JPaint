package Model;

import Controller.DialogProvider;
import Controller.Interfaces.IDialogProvider;
import Model.Interfaces.IApplicationState;
import Model.Interfaces.MouseObserver;
import View.Enum.ShapeColor;
import View.Enum.ShapeShadingType;
import View.Enum.ShapeType;
import View.Enum.StartAndEndPointMode;
import View.Interfaces.UiModule;

import java.util.ArrayList;

public class ApplicationState implements IApplicationState{
    IDialogProvider dialogProvider;
    UiModule uiModule;

    private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private StartAndEndPointMode activeStartAndEndPointMode;

    private ArrayList<MouseObserver> Observers = new ArrayList<MouseObserver>();


    public ApplicationState(UiModule uiModule) {
        dialogProvider = new DialogProvider(this);
        this.uiModule = uiModule;
        setDefaults();
    }

    @Override
    public void setActiveShape() {
        activeShapeType = uiModule.getDialogResponse(dialogProvider.getShapeDialog());
    }

    @Override
    public void setActivePrimaryColor() {
        activePrimaryColor = uiModule.getDialogResponse(dialogProvider.getPrimaryColorDialog());
        notifyObservers();
        System.out.println("Primary Color changed!");
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = uiModule.getDialogResponse(dialogProvider.getSecondaryColorDialog());
        notifyObservers();
        System.out.println("Secondary Color  changed!");
    }

    @Override
    public void setActiveShadingType() {
        activeShapeShadingType = uiModule.getDialogResponse(dialogProvider.getShadingTypeDialog());
        notifyObservers();
        System.out.println("Shape Shading Type changed!");
    }

    @Override
    public void setActiveStartAndEndPointMode() {
        activeStartAndEndPointMode = uiModule.getDialogResponse(dialogProvider.getStartandEndPointModeDialog());
        notifyObservers();
        System.out.println("Mouse mode changed!");
    }

    @Override
    public ShapeType getActiveShapeType() {
        return activeShapeType;
    }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public ShapeShadingType getActiveShapeShadingType() {
        return activeShapeShadingType;
    }

    @Override
    public StartAndEndPointMode getActiveStartAndEndPointMode() {
        return activeStartAndEndPointMode;
    }

    private void setDefaults() {
        activeShapeType = ShapeType.ellipse;
        activePrimaryColor = ShapeColor.BLACK;
        activeSecondaryColor = ShapeColor.WHITE;
        activeShapeShadingType = ShapeShadingType.OUTLINE;
        activeStartAndEndPointMode = StartAndEndPointMode.DRAW;
    }

    @Override
    public void registerObserver(MouseObserver o) {
        Observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for(MouseObserver observer : Observers) {
            observer.update();
            System.out.println("Observer got updated");
        }
    }
}
