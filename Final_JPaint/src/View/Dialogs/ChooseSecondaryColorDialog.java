package View.Dialogs;

import Model.ApplicationState;
import Model.Interfaces.IApplicationState;
import View.Enum.ShapeColor;
import View.Interfaces.Idialog;

public class ChooseSecondaryColorDialog implements Idialog {

    private IApplicationState applicationState;

    public ChooseSecondaryColorDialog(IApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Secondary Color";
    }

    @Override
    public String getDialogText() {
        return "Select a secondary color from the menu below:";
    }

    @Override
    public ShapeColor getCurrentSelection() {
        return applicationState.getActiveSecondaryColor();
    }

    @Override
    public ShapeColor[] getDialogOptions() {
        return ShapeColor.values();
    }
}
