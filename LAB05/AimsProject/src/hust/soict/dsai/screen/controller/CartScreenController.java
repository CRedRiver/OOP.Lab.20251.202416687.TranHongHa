package hust.soict.dsai.screen.controller;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.screen.StoreScreen;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;
    private Store store;
    private ObservableList<Media> observableCartItems;
    
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;
    
    @FXML
    private Label costLabel;

    @FXML
    private TextField tfFilter;

    @FXML
    private Button placeOrder;
    private JFrame stage;

    @FXML
    void viewStorePressed(ActionEvent event) {
        SwingUtilities.invokeLater(() -> {
        StoreScreen screen = new StoreScreen(store, cart);
        screen.setVisible(true);
        });
    }


    @FXML
    void placeOrderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, cart.placeOrder());
        alert.setTitle("Order created");
        alert.setHeaderText(null);
        costLabel.setText(cart.totalCost() + "$");
        alert.showAndWait();
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        Alert alert;
        try {
            alert = new Alert(Alert.AlertType.NONE, media.playGUI());
            alert.setTitle("Playing");
            alert.setHeaderText(null);
            alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
            alert.showAndWait();
        } catch (PlayerException e) {
            alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        observableCartItems.remove(media);
    }

    public CartScreenController(Store store, Cart cart) {
        super();
        this.store = store;
        this.cart = cart;
    }
    private void updateTotalLabel() {
        double total = observableCartItems.stream()
                      .mapToDouble(Media::getCost)
                      .sum();
        if (Platform.isFxApplicationThread()) {
            costLabel.setText(String.format("%.2f $", total));
        } else {
            Platform.runLater(() -> costLabel.setText(String.format("%.2f $", total)));
        }
    }
    @FXML
    void initialize() {
        colMediaTitle.setCellValueFactory(
            new PropertyValueFactory<Media, String>("title")
        );
        colMediacategory.setCellValueFactory(
            new PropertyValueFactory<Media, String>("category")
        );
        colMediaCost.setCellValueFactory(
            new PropertyValueFactory<Media, Float>("cost")
        );
        observableCartItems = this.cart.getItemsOrdered();
        tblMedia.setItems(observableCartItems);
        updateTotalLabel();

        costLabel.setText(cart.totalCost() + "$");

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        observableCartItems.addListener((ListChangeListener<Media>) change -> {
            updateTotalLabel();
        });
        
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {

                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                }

                private void updateButtonBar(Media media) {
                    btnRemove.setVisible(true);
                    if (media instanceof Playable) {
                        btnPlay.setVisible(true);
                    } else {
                        btnPlay.setVisible(false);
                    }
                }
            }
        );

        tfFilter.textProperty().addListener(
            new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }

            private void showFilteredMedia(String keyword) {
                FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered());

                if (!keyword.isEmpty() && radioBtnFilterId.isSelected()) {
                    filteredList.setPredicate(media -> {
                        String idString = String.valueOf(media.getId());
                        return idString.equals(keyword);
                    });
                } else if (!keyword.isEmpty() &&  radioBtnFilterTitle.isSelected()) {
                    filteredList.setPredicate(media -> {
                        String title = media.getTitle().toLowerCase();
                        return title.contains(keyword.toLowerCase());
                    });
                } else {
                    filteredList.setPredicate(null);
                }
                tblMedia.setItems(filteredList);
                costLabel.setText(cart.totalCost() + "$");
            }
        });

    }

    public void setParentFrame(javax.swing.JFrame frame) {
        this.stage = frame;
    }
}