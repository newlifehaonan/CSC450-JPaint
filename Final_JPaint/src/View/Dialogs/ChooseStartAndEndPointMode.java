package View.Dialogs;

import Model.Interfaces.IApplicationState;
import View.Enum.StartAndEndPointMode;
import View.Interfaces.Idialog;

public class ChooseStartAndEndPointMode implements Idialog {

    IApplicationState applicationState;

    public ChooseStartAndEndPointMode(IApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Start and End Point Mode";
    }

    @Override
    public String getDialogText() {
        return "Select a shading type from the menu below:";
    }

    @Override
    public StartAndEndPointMode getCurrentSelection() {
        return applicationState.getActiveStartAndEndPointMode();
    }

    @Override
    public StartAndEndPointMode[] getDialogOptions() {
        return StartAndEndPointMode.values();
    }
}
