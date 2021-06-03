package application;

import java.util.ArrayList;
/**
 * Extends the abstract class Pizza.
 * Includes a concrete implementation of the abstract pizzaPrice() method.
 * Pizzas of this type are customizable and have varying ArrayLists.
 * CHRISTOPHER DEFRANZA & EVELYN GIORDANO
 * @author Christopher Defranza
 */
public class BYOPizza extends Pizza {
	
    protected int BYOSmall = 5;
    protected int BYOMedium = 7;
    protected int BYOLarge = 9;
    
    /**
     * Parameterized constructor for a BYO pizza that includes a unique set of toppings.
     * @param style  style of pizza
     * @param size   size of pizza
     * @param toppings  arraylist of toppings
     */
    public BYOPizza(String style, String size, ArrayList<String> toppings) {
        super(style, size);
        this.toppings = toppings;
    }

    /**
     * Implements the abstract class pizzaPrice() of the abstract pizza class.
     * Calculates the pricing for Build Your Own pizzas.
     */
    @Override
    public int pizzaPrice() {
    	int toppingCost = 2 * toppings.size();
    	
    	if ((toppingCost == 0) ||  (toppings.size() > 6)) {
    		return -1;
    	}
    	
        if(this.size.equalsIgnoreCase("small")){
            return BYOSmall + toppingCost;
        }
        
        if(this.size.equalsIgnoreCase("medium")){
            return BYOMedium + toppingCost;
        }
        
        if(this.size.equalsIgnoreCase("large")){
            return BYOLarge + toppingCost;
        }else
            return -1; // error checking
    }
    
    /**
     * Overrides the Pizza class's method, toString().
     * Returns a string for the specific Pizza object.
     */
    public String toString(){
        return super.toString()+" \n\tTOPPINGS: "+ (this.toppings).toString();
    }
}
