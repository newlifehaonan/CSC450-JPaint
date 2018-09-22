package States;

import Interfaces.GumBallState;
import Model.GumballMachine;

public class WinnerState implements GumBallState {

    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You insert a Quarter");

    }

    @Override
    public void ejectQuarter() {
        System.out.println("you haven't insert a Quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("please Insert a Quarter");
    }

    @Override
    public void dispense() {

        System.out.println("you need to pay first");
    }
}
