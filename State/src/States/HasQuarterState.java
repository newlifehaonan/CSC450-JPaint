package States;

import Interfaces.GumBallState;
import Model.GumballMachine;

public class HasQuarterState implements GumBallState {

    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you can't insert another quarter");

    }

    @Override
    public void ejectQuarter() {
        gumballMachine.setState(gumballMachine.getNoquarterstate());
        System.out.println("Quarter returned");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turn the crank");
        gumballMachine.setState(gumballMachine.getSoldstate());
    }

    @Override
    public void dispense() {

        System.out.println("No Gumball dispense");
    }
}
