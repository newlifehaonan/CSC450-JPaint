package pizza;

import java.util.List;

public class Pizza {
    private String size;
    private final List<String> toppings;

    public Pizza(String size, List<String> toppings){
        this.size = size;
        this.toppings = toppings;
    }

    public String getSize() {
        return size;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void addtopping(String topping) {
        this.toppings.add(topping);
    }


    public String toString(){

        StringBuilder toppingsBuilder = new StringBuilder();

        toppingsBuilder.append(size + " pizza\n");
        for (String topping :
                toppings) {
            toppingsBuilder.append("\t" + topping + "\n");
        }
        return toppingsBuilder.toString();
    }
}
