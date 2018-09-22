package controller;

public class CopyCommand implements ICommand {
    @Override
    public void run() {
        System.out.println("CopyCommand running.");
    }
}
