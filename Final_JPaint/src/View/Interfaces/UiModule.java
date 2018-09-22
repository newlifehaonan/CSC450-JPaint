package View.Interfaces;

import Controller.Interfaces.ICommand;
import View.Enum.EventName;

public interface UiModule {

     void addEvent(EventName eventName, ICommand iCommand);
     void addAccelorator(EventName eventName, int keyshortcut);
     <T> T getDialogResponse(Idialog dialogSettings);


}
