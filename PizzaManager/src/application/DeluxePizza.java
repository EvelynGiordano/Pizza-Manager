package application;

/**
 * Extends the abstract class Pizza.
 * Includes a concrete implementation of the abstract pizzaPrice() method.
 * Pizzas of this type have a final toppings list.
 * CHRISTOPHER DEFRANZA & EVELYN GIORDANO
 * @author Christopher Defranza
 */
public class DeluxePizza extends Pizza{

    protected int deluxeSmall = 14;
    protected int deluxeMedium = 16;
    protected int deluxeLarge = 18;
    
    /**
     * Parameterized constructor for a Deluxe pizza that had a preset list of toppings.
     * @param style  style of pizza
     * @param size   size of pizza
     */
    public DeluxePizza(String style, String size) {
        super(style, size);
        toppings.add("Sausage");
        toppings.add("Pepperoni");
        toppings.add("Green Pepper");
        toppings.add("Onion");
        toppings.add("Mushroom");
    }

    /**
     * Implements the abstract class pizzaPrice() of the abstract pizza class.
     * Calculates the pricing for Deluxe pizzas.
     */
    @Override
    public int pizzaPrice() {
    	
    	int toppingCost = 2 * toppings.size();
    	
    	if ((toppingCost == 0) ||  (toppings.size() > 6)) {
    		return -1;
    	}
    	
        if(this.size.equalsIgnoreCase("small")){
            return deluxeSmall;
        }
        
        if(this.size.equalsIgnoreCase("medium")){
            return deluxeMedium;
        }
        
        if(this.size.equalsIgnoreCase("large")){
            return deluxeLarge;
        }else
            return -1; // error checking
    }
    
     /**
     * Overrides the Pizza class's method, toString().
     * Returns a string for the specific Pizza object.
     */
    public String toString(){
        return super.toString() + " \n\tTOPPINGS: " + (this.toppings).toString();
    }

}