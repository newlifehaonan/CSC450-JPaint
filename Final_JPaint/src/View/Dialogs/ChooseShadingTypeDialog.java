package View.Dialogs;

import Model.ApplicationState;
import Model.Interfaces.IApplicationState;
import View.Enum.ShapeColor;
import View.Enum.ShapeShadingType;
import View.Interfaces.Idialog;

public class ChooseShadingTypeDialog implements Idialog {
    private IApplicationState applicationState;

    public ChooseShadingTypeDialog(IApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Shading Type";
    }

    @Override
    public String getDialogText() {
        return "Select a shading type from the menu below:";
    }

    @Override
    public ShapeShadingType[] getDialogOptions() {
        return ShapeShadingType.values();
    }

    @Override
    public ShapeShadingType getCurrentSelection() {
        return applicationState.getActiveShapeShadingType();
    }

}
