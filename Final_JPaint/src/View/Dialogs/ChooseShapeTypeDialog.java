package View.Dialogs;

import Model.ApplicationState;
import Model.Interfaces.IApplicationState;
import View.Enum.ShapeType;
import View.Interfaces.Idialog;

public class ChooseShapeTypeDialog implements Idialog {

    IApplicationState applicationState;

    public ChooseShapeTypeDialog(IApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    @Override

    public String getDialogTitle() {
        return "Shape";
    }

    @Override
    public String getDialogText() {
        return "Select a shape from the menu below:";
    }

    @Override
    public ShapeType[] getDialogOptions() {
        return ShapeType.values();
    }

    @Override
    public ShapeType getCurrentSelection() {
        return applicationState.getActiveShapeType();
    }
}
