package application;

import java.util.ArrayList;

/**
 * An interface for the OrderController and the PizzaController.
 * This interface allows the two Controllers to know the values of the current order lists simultaneously.
 * CHRISTOPHER DEFRANZA & EVELYN GIORDANO
 * @author Evelyn Giordano
 */
public interface ControllerInterface {
	ArrayList<String> orders = new ArrayList<String>();
	ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

}
