package application;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
/**
 * The OrderController Class controls and implements the secondary window of the GUI.
 * It also implements the ControllerInterface.
 * It gives the user the ability to view and delete their order.
 * When the back button is pressed, only this window is closed.
 * CHRISTOPHER DEFRANZA & EVELYN GIORDANO
 * @author Evelyn Giordano
 */
public class OrderController implements ControllerInterface{

    @FXML
    private ListView<String> pizzaOrder;

    @FXML
    private TextArea total;
    
    @FXML
    private Button clear;

    @FXML
    private Button back;
    
    int t;

    /**
     * Event handler to delete an order when the "Clear Order" button is clicked.
     * @param event  a button click
     */
    @FXML
    void deleteOrder(ActionEvent event) {
    	total.setEditable(true);
    	pizzaOrder.setItems(FXCollections.observableArrayList(new ArrayList<String>()));
    	orders.clear();
    	pizzas.clear();
    	total.clear();
    }
    
    /**
     * Event handler to close only the second window when the "Back" button is clicked.
     * @param event   a button click
     */
    @FXML
    void clearStage(ActionEvent event) {
    	final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
    
    /**
     * Initializes the second stage and calculates the total of the order based off of the current list of pizzas.
     * Sets the items displayed in the pizzaOrder listview equal to the arraylist of pizza info.
     */
    public void initialize() {
    	total.setEditable(true);
    	pizzaOrder.setItems(FXCollections.observableArrayList(orders));
    	t = 0;
    	for (Pizza x: pizzas) {
    		t += x.pizzaPrice();
    	}
    	
    	total.setText("$" + String.valueOf(t));
    	total.setEditable(false);
    }

	
}