package Model;

import Interfaces.GumBallState;
import States.*;

public class GumballMachine {

    GumBallState noquarterstate;
    GumBallState hasquarterstate;
    GumBallState soldstate;
    GumBallState soldoutstate;
    GumBallState winnerstate;

    GumBallState state;

    int count;

    public GumballMachine(int initeGumball) {
        this.noquarterstate = new NoQuarterState(this);
        this.hasquarterstate = new HasQuarterState(this);
        this.soldstate = new SoldState(this);
        this.soldoutstate = new SoldOutState(this);
        this.winnerstate = new WinnerState(this);

        count = initeGumball;

        if(initeGumball == 0){
            state = soldoutstate;
        }

        else {
            state = noquarterstate;
        }
    }

    public GumBallState getNoquarterstate() {
        return noquarterstate;
    }

    public GumBallState getHasquarterstate() {
        return hasquarterstate;
    }

    public GumBallState getSoldstate() {
        return soldstate;
    }

    public GumBallState getSoldoutstate() {
        return soldoutstate;
    }

    public GumBallState getWinnerstate() {
        return winnerstate;
    }

    public int getCount() {
        return count;
    }

    public GumBallState getCurrentState() {
        return state;
    }

    public void setState(GumBallState gumBallState) {
        this.state = state;
    }

    public void release() {
        System.out.println("Gumball rolling out");
        if(count != 0) {
            count -= 1;
        }
    }


}
