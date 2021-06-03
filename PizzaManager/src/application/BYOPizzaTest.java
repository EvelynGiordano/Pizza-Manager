package application;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


/**
 * JUnit test for the abstract pizzaPrice() method of the Pizza class.
 * CHRISTOPHER DEFRANZA & EVELYN GIORDANO
 * @author Evelyn Giordano
 */
public class BYOPizzaTest {

	/**
	 * Tests the outputs for each pizza sizes.
	 * Tests the result when the number of toppings is less than 1 or greater than 7.
	 */
	@Test
	public void testPizzaPrice() {
		
		ArrayList<String> l1 = new ArrayList<String>();					//tests for small BYO pizza
		BYOPizza s = new BYOPizza("Build Your Own", "Small", l1);
		
					
		assertEquals(-1, s.pizzaPrice());								//if no toppings are selected (disallowed)
		
		l1.add("Onion");
		l1.add("Sausage");
		assertEquals(9, s.pizzaPrice());								//test price of small pizza with 2 toppings
		
		l1.add("Pepperoni");											
		l1.add("Pineapple");
		l1.add("Chicken");
		l1.add("Beef");
		assertEquals(17, s.pizzaPrice());								//test price of small pizza with 6 toppings
		
		l1.add("Green Peppers");
		assertEquals(-1, s.pizzaPrice());								//test price of small pizza with 7 toppings (disallowed)
		
		
		
		ArrayList<String> l2 = new ArrayList<String>();					//tests for medium BYO pizza. Same as above
		BYOPizza m = new BYOPizza("Build Your Own", "Medium", l2);
		assertEquals(-1, m.pizzaPrice());
		
		l2.add("Onion");
		l2.add("Sausage");
		assertEquals(11, m.pizzaPrice());
		
		l2.add("Pepperoni");
		l2.add("Pineapple");
		l2.add("Chicken");
		l2.add("Beef");
		assertEquals(19, m.pizzaPrice());
		
		l2.add("Green Peppers");
		assertEquals(-1, m.pizzaPrice());
		
		
		
		ArrayList<String> l3 = new ArrayList<String>();
		BYOPizza l = new BYOPizza("Build Your Own", "Large", l3);
		assertEquals(-1, l.pizzaPrice());
		
		l3.add("Onion");
		l3.add("Sausage");
		assertEquals(13, l.pizzaPrice());
		
		l3.add("Pepperoni");
		l3.add("Pineapple");
		l3.add("Chicken");
		l3.add("Beef");
		assertEquals(21, l.pizzaPrice());
		
		l3.add("Green Peppers");
		assertEquals(-1, l.pizzaPrice());
		
		
		
		

	}

}
