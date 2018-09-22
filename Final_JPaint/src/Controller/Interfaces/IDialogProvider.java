package Controller.Interfaces;

import View.Interfaces.Idialog;

public interface IDialogProvider {
    Idialog getPrimaryColorDialog();
    Idialog getSecondaryColorDialog();
    Idialog getShapeDialog();
    Idialog getStartandEndPointModeDialog();
    Idialog getShadingTypeDialog();
}
