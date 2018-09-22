package States;

import Interfaces.GumBallState;
import Model.GumballMachine;

public class SoldState implements GumBallState {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("please wait!");

    }

    @Override
    public void ejectQuarter() {
        System.out.println("sorry you turn the crank already");
    }

    @Override
    public void turnCrank() {
        System.out.println("turning twice does not give you another gumball");
    }

    @Override
    public void dispense() {

        gumballMachine.release();
        if(gumballMachine.getCount() == 0) {
            System.out.println("Oops Out of Gumball");
            gumballMachine.setState(gumballMachine.getSoldoutstate());
        }
        else {
            gumballMachine.setState(gumballMachine.getNoquarterstate());
        }
    }
}
