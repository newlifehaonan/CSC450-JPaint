package Controller;

import Controller.Interfaces.IDialogProvider;
import Model.Interfaces.IApplicationState;
import View.Dialogs.*;
import View.Interfaces.Idialog;

public class DialogProvider implements IDialogProvider {

    IApplicationState applicationState;

    private final Idialog primaryDialog;
    private final Idialog secondaryDialog;
    private final Idialog shadingTypeDialog;
    private final Idialog shapeDialog;
    private final Idialog startandEndPointDialog;

    public DialogProvider(IApplicationState applicationState) {
        this.applicationState = applicationState;
        this.primaryDialog = new ChoosePrimaryColorDialog(applicationState);
        this.secondaryDialog = new ChooseSecondaryColorDialog(applicationState);
        this.shadingTypeDialog = new ChooseShadingTypeDialog(applicationState);
        this.shapeDialog = new ChooseShapeTypeDialog(applicationState);
        this.startandEndPointDialog = new ChooseStartAndEndPointMode(applicationState);
    }

    @Override
    public Idialog getPrimaryColorDialog() {
        return primaryDialog;
    }

    @Override
    public Idialog getSecondaryColorDialog() {
        return secondaryDialog;
    }

    @Override
    public Idialog getShapeDialog() {
        return shapeDialog;
    }

    @Override
    public Idialog getStartandEndPointModeDialog() {
        return startandEndPointDialog;
    }

    @Override
    public Idialog getShadingTypeDialog() {
        return shadingTypeDialog;
    }
}
