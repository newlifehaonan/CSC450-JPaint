package Controller.Command;

import Controller.Interfaces.ICommand;

public class RedoCommand implements ICommand {
    @Override
    public void excute() {
        CommandHistory.redo();
        CommandHistory.printCommandHistory();
    }
}
