package application;
import java.util.ArrayList;
/**
 * This class has an abstract method pizzaPrice() that is defined in 3 subclasses.
 * CHRISTOPHER DEFRANZA & EVELYN GIORDANO
 * @author Christopher Defranza
 */
public abstract class Pizza {
   
   protected String style;
   protected String size;
   protected int price;
   protected int smallPrice;
   protected ArrayList<String> toppings = new ArrayList<String>();

   /**
    * Parameterized constructor that includes a parameter for a unique toppings array.
    * @param style
    * @param size
    * @param toppings
    */
   public Pizza(String style, String size, ArrayList<String> toppings) {
       this.size = size;
       this.style = style;
       this.toppings = toppings;
   }

   /**
    * Parameterized constructor without an array parameter to account for Pizza types with non-customizable toppings.
    * @param style  style of pizza
    * @param size   size of pizza
    */
   public Pizza(String style, String size) { 
       this.size = size;
       this.style = style;
   }

   /**
    * Abstract method that is implemented in DeluxePizza, BYOPizza, and HawaiianPizza.
    * @return
    */
   public abstract int pizzaPrice();

   /**
    * Overrides the String class's method, toString().
    * Returns a string for the specific Pizza object.
    */
   public String toString() {
	   return "\tSIZE: " + this.size + "\n\tSTYLE: " + this.style;
   }

}
