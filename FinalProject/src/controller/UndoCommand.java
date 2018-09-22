package controller;

public class UndoCommand implements ICommand{

    @Override
    public void run() {
        System.out.println("UndoCommand running.");
    }
}
