package hust.soict.dsai.screen;

import javax.swing.JFrame;
import hust.soict.dsai.screen.controller.CartScreenController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;



public class CartScreen extends JFrame {

    private static Cart cart;
    private static Store store;
    
    public static void main(String[] args) {
		new CartScreen(store, cart);
	}

    public CartScreen(Store store, Cart cart) {

        super();

        CartScreen.cart = cart;
        CartScreen.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(1024, 768);
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/screen/view/cart.fxml"));
                    
                    CartScreenController controller = new CartScreenController(store, cart);
                    controller.setParentFrame(CartScreen.this);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    
}