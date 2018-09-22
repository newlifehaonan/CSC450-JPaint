package View.Dialogs;

import Model.ApplicationState;
import Model.Interfaces.IApplicationState;
import View.Enum.ShapeColor;
import View.Interfaces.Idialog;

public class ChoosePrimaryColorDialog implements Idialog {

    IApplicationState applicationState;

    public ChoosePrimaryColorDialog(IApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Primary Color";
    }

    @Override
    public String getDialogText() {
        return "Select a primary color from the menu below:";
    }

    @Override
    public ShapeColor[] getDialogOptions() {
        return ShapeColor.values();
    }

    @Override
    public ShapeColor getCurrentSelection() {
        return applicationState.getActivePrimaryColor();
    }


}
