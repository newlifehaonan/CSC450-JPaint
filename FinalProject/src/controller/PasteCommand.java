package controller;

public class PasteCommand implements ICommand{
    @Override
    public void run() {
        System.out.println("PasteCommand running.");
    }
}
