package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * The PizzaController Class controls and implements the primary window of the GUI.
 * It also implements the ControllerInterface.
 * It gives the user the ability to select the style and size of their pizza, and sometimes their toppings.
 * Users can add pizzas to their order individually and may open a second window to view their order.
 * CHRISTOPHER DEFRANZA & EVELYN GIORDANO
 * @author Evelyn Giordano
 */
public class PizzaController implements ControllerInterface {

    @FXML
    private ListView<String> toppings;

    @FXML
    private ListView<String> chosenToppings;

    @FXML
    private ComboBox<String> style;

    @FXML
    private ComboBox<String> size;
    
    @FXML
    private Button add;

    @FXML
    private Button remove;
    
    @FXML
    private Button addOrder;

    @FXML
    private TextArea output;
    
    @FXML
    private ImageView image;
    
    Image byo = new Image("https://www.hungryhowies.com/sites/default/files/styles/menu_item_280x175/public/"
    		+ "images/menu-items/thumbnails/build-you-own_0.png?itok=kqLw4gRp");
    Image haw = new Image("https://www.thespruceeats.com/thmb/Tqmt7oH8AMjDWQHCSa93hE4TPe8=/2998x1999/"
    		+ "filters:fill(auto,1)/IMG_4618fhor-a98bebf4c7e743a8bbfd6071b5dafc12.jpg");
    Image del = new Image("https://i2.wp.com/www.chateaudescharmes.com/wp-content/uploads/2019/05/"
    		+ "Deluxe-Pizza-May.jpg?fit=825%2C550&ssl=1");
    
    ArrayList<String> tops;
    
    Pizza p;

    /**
     * Event handler for when the "Add to Order" button is pressed.
     * It adds the pizza to a list of pizzas and the respective string to a list of strings.
     * Creates a new pizza object after the previous is added to the order.
     * @param event  a button click
     */
    @FXML
    void addToOrder(ActionEvent event) {
    	// add pizza to order list
    	if (tops.isEmpty()) {
    		output.setEditable(true);
    		output.setText("You must add at least one topping.");
    		output.setEditable(false);
    		return;
    	}
    	
    	if ((style.getValue()).contentEquals("Build Your Own")) {
			tops = new ArrayList<String>();
    		chosenToppings.setItems(FXCollections.observableArrayList(tops));
          	addOrder.setDisable(true);
		}
    	
    	output.setEditable(true);
    	output.setText("Pizza added.");
    	output.setEditable(false);
    	orders.add((orders.size() + 1) + ")  " + p.toString() + "\n\tPRICE: $" + p.pizzaPrice());
    	pizzas.add(p);
    	if ((style.getSelectionModel().getSelectedItem()).equals("Hawaiian")) {
    		p = new HawaiianPizza(style.getValue(), size.getValue());
        }
        else if ((style.getSelectionModel().getSelectedItem()).equals("Deluxe")){
        	p = new DeluxePizza(style.getValue(), size.getValue());
        } else {
        	p = new BYOPizza(style.getValue(), size.getValue(), tops);
        	add.setDisable(false);
        }
    	
  
    	
    }

    /**
     * Event handler for when the "Add Topping" button is pressed.
     * If it is already chosen, return. If there are already 6 toppings, return.
     * If toppings are equal to 6 after the current addition, then disable the add button.
     * @param event  a button click
     */
    @FXML
    void addTopping(ActionEvent event) {
    	// add all toppings selected in the toppings list
    	output.setEditable(true);
    	output.clear();
    	output.setEditable(false);
    	if(tops.isEmpty()) {
    		tops.add(toppings.getSelectionModel().getSelectedItem());
    		addOrder.setDisable(false);
    		p.toppings = tops;
    		chosenToppings.setItems(FXCollections.observableArrayList(tops));
    		return;
    	}
    	if (tops.contains(toppings.getSelectionModel().getSelectedItem())){
    		//output already selected error
    		return;
    	}
    	if (tops.size() < 6) {
    		tops.add(toppings.getSelectionModel().getSelectedItem());
    		p.toppings = tops;
    		chosenToppings.setItems(FXCollections.observableArrayList(tops));
    		
    		if(tops.size() == 6) {
    			add.setDisable(true);
    		}
    	}
    }


    /**
     * Updates the current pizza object if the size is changed inside the Combobox.
     * @param event   a combobox selection
     */
    @FXML
    void changeSize(ActionEvent event) {
    	p.size = size.getValue();
    	output.setEditable(true);
    	output.clear();
    	output.setEditable(false);
    }

    /**
     * Creates a new pizza object if the style is changed inside the Combobox.
     * @param event   a combobox selection
     */
    @FXML
    void changeStyle(ActionEvent event) {
    	output.setEditable(true);
    	output.clear();
    	output.setEditable(false);
    	if ((style.getSelectionModel().getSelectedItem()).equals("Hawaiian")) {
    		image.setImage(haw);
        	p = new HawaiianPizza(style.getValue(), size.getValue());
        	tops = p.toppings;
        	toppings.setDisable(true);
        	add.setDisable(true);
        	remove.setDisable(true);
        	addOrder.setDisable(false);
    		chosenToppings.setItems(FXCollections.observableArrayList(p.toppings));
        }
        else if ((style.getSelectionModel().getSelectedItem()).equals("Deluxe")){
    		image.setImage(del);
        	p = new DeluxePizza(style.getValue(), size.getValue());
        	tops = p.toppings;
        	toppings.setDisable(true);
        	add.setDisable(true);
        	remove.setDisable(true);
        	addOrder.setDisable(false);
    		chosenToppings.setItems(FXCollections.observableArrayList(p.toppings));
        } else {
    		image.setImage(byo);
        	p = new BYOPizza(style.getValue(), size.getValue(), new ArrayList<String>());
        	tops = new ArrayList<String>();
        	toppings.setDisable(false);
        	add.setDisable(false);
        	remove.setDisable(false);
    		chosenToppings.setItems(FXCollections.observableArrayList(p.toppings));
        }
    }
    	
    /**
     * Removes the selected toppings and resets the GUI to the default settings.
     * @param event  a button click
     */
    @FXML
    void clearToppingList(ActionEvent event) {
    		// delete toppings list for pizza
	    	output.setEditable(true);
	    	output.clear();
	    	output.setEditable(false);
    		tops = new ArrayList<String>();
    		p.toppings = tops;
    		chosenToppings.setItems(FXCollections.observableArrayList(tops));
    		style.getSelectionModel().select("Build Your Own");
    		size.getSelectionModel().select("Medium");
    }

    /**
     * Opens a new stage when the "Show Order" button is clicked.
     * Displays all pizzas on the order including their style, size, toppings, and cost.
     * The total cost is displayed at the bottom of the list.
     * @param event    a button click
     */
    @FXML
    void openNewStage(ActionEvent event) {	
    	if(!orders.isEmpty()) {
    		output.setEditable(true);
        	output.clear();
        	output.setEditable(false);
    		if ((style.getValue()).contentEquals("Build Your Own")) {
    			tops = new ArrayList<String>();
        		chosenToppings.setItems(FXCollections.observableArrayList(tops));
    		}
			try {
				Stage secondaryStage = new Stage();
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Order.fxml"));
				Scene scene = new Scene(root, 800, 600);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				secondaryStage.setTitle("Pizza Order");
				secondaryStage.setScene(scene);
		 		secondaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	} else {
    		
    		output.setEditable(true);
    		output.setText("There are no items to be displayed.");
        	output.setEditable(false);
    	}
		
    }


    /**
     * Removes a topping from the current list of chosen toppings and the current pizza objects topping list.
     * @param event  a button click
     */
    @FXML
    void removeTopping(ActionEvent event) {
    		// remove the toppings selected in the toppings list
    	int size = (p.toppings).size();
    	if ((p.toppings).contains(toppings.getSelectionModel().getSelectedItem())) {
    		(p.toppings).remove(toppings.getSelectionModel().getSelectedItem());
    		chosenToppings.setItems(FXCollections.observableArrayList(p.toppings));
    		if ((p.toppings).size() == 0) {
    			addOrder.setDisable(true);
    		}
    	}
    	
    	if(size == 6) {
    		add.setDisable(false);
    	}
    	
    }
    
    /**
     * Initializes the first stage of the Pizza Manager.
     * Populates and arms the ComboBoxes and sets the default settings.
     */
    public void initialize() {
    	ArrayList<String> styles = setStyles(new ArrayList<String>());
    	style.setItems(FXCollections.observableArrayList(styles));
    	style.arm();
    	ArrayList<String> sizes = setSizes(new ArrayList<String>());
    	size.setItems(FXCollections.observableArrayList(sizes));
    	size.arm();
    	ArrayList<String> toppingList = setToppingList(new ArrayList<String>());
        toppings.setItems(FXCollections.observableArrayList(toppingList));
        //create a pizza object
        style.getSelectionModel().select("Build Your Own");
        size.getSelectionModel().select("Medium");
        p = new BYOPizza("Build Your Own", size.getValue(), tops);
        tops = new ArrayList<String>();
        addOrder.setDisable(true);
        output.setEditable(false);
        
    }
    
    /**
     * Helper method to populate an ArrayList of toppings.
     * @param t     empty arraylist
     * @return		arraylist of toppings
     */
    public ArrayList<String> setToppingList(ArrayList<String> t) {
		t.add("Beef");
		t.add("Cheese");
		t.add("Chicken");
		t.add("Green Pepper");
		t.add("Ham");
		t.add("Mushroom");
		t.add("Onion");
		t.add("Pepperoni");
		t.add("Pineapple");
		t.add("Sausage");
		
		return t;
	}
    
    /**
     * Helper method to populate an ArrayList of styles to be entered into a ComboBox.
     * @param st    empty arraylist
     * @return		arraylist of pizza styles
     */
    public ArrayList<String> setStyles(ArrayList<String> st) {
		st.add("Build Your Own");
		st.add("Hawaiian");
		st.add("Deluxe");
		
		return st;
		
	}
    /**
     * Helper method to populate an ArrayList of sizes to be entered into a ComboBox.
     * @param sz	empty arraylist
     * @return		arraylist of sizes
     */
    public ArrayList<String> setSizes(ArrayList<String> sz) {
		sz.add("Small");
		sz.add("Medium");
		sz.add("Large");
		
		return sz;
		
	}


}