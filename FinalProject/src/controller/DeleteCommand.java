package controller;

public class DeleteCommand implements ICommand {
    @Override
    public void run() {
        System.out.println("DeleteCommand running.");
    }
}
