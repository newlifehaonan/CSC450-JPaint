package States;

import Interfaces.GumBallState;
import Model.GumballMachine;

public class SoldOutState implements GumBallState {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Sorry We Sold Out Gumball");

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
