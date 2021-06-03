package application;

/**
 * Extends the abstract class Pizza.
 * Includes a concrete implementation of the abstract pizzaPrice() method.
 * Pizzas of this type have a final toppings list.
 * CHRISTOPHER DEFRANZA & EVELYN GIORDANO
 * @author Christopher Defranza
 */
public class HawaiianPizza extends Pizza{

   protected int hawaiianSmall = 8;
   protected int hawaiianMedium = 10;
   protected int hawaiianLarge = 12;
   
   /**
    * Parameterized constructor for a Hawaiian pizza that had a preset list of toppings.
    * @param style  style of pizza
    * @param size   size of pizza
    */
   public HawaiianPizza(String style, String size) {
       super(style, size);
       this.toppings.add("Ham");
       this.toppings.add("Pineapple");   
   }

   /**
    * Implements the abstract class pizzaPrice() of the abstract pizza class.
    * Calculates the pricing for Hawaiian pizzas.
    */
   @Override
   public int pizzaPrice() {
	   
	   int toppingCost = 2 * toppings.size();
	   
	   if ((toppingCost == 0) ||  (toppings.size() > 6)) {
   			return -1;
   		}
	   
       if(this.size.equalsIgnoreCase("small")){
           return hawaiianSmall;
       }
       
       if(this.size.equalsIgnoreCase("medium")){
           return hawaiianMedium;
       }
       
       if(this.size.equalsIgnoreCase("large")){
           return hawaiianLarge;
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