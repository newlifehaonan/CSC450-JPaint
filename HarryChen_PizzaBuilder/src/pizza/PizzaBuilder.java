package pizza;

import java.util.ArrayList;

public class PizzaBuilder implements IPizzaBuilder {

    private Pizza mypizza;

    public PizzaBuilder() {
        this.mypizza = new Pizza("", new ArrayList<>());
    }

    @Override
    public void addTopping(String topping) {

        mypizza.addtopping(topping);
    }

    @Override
    public void setSize(String size) {

        this.mypizza.setSize(size);
    }

    @Override
    public Pizza getPizza() {

        return this.mypizza;
    }
}
