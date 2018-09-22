package Controller.Command;

import Controller.Interfaces.ICommand;

public class UndoCommand implements ICommand {
    @Override
    public void excute() {
        CommandHistory.undo();
        CommandHistory.printCommandHistory();
    }
}
