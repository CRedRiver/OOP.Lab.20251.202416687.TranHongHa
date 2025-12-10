package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.comparator.MediaComparatorByTitleCost;
import hust.soict.dsai.comparator.MediaComparatorByCostTitle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.DecimalFormat;
import java.util.Collections;

public class Cart {

    private int qtyOrdered;
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    public int getQtyOrdered() {
        return qtyOrdered;
    }
    public void addMedia(Media item){
        this.qtyOrdered += 1;
        if (this.qtyOrdered > 20){
            System.out.println("Max number of items in cart reached!");
            this.qtyOrdered -= 1;
            return;
        }
        this.itemsOrdered.add(item); 
    }
    public boolean removeMedia(Media item){
        if (this.itemsOrdered.contains(item)){
            this.itemsOrdered.remove(item);
            this.qtyOrdered -= 1;
            return true;
        }
        return false;
    }
    public float totalCost() {
        float total_cost = 0;
        for (Media media : this.itemsOrdered) {
            total_cost += media.getCost();
        }
        return total_cost;
    }
    // Print out Cart items (USING STRINGBUILDER)
    public void print() {
        StringBuilder sb = new StringBuilder();
    
        sb.append("***********************CART***********************\n");
    
        int i = 0;
        for (Media item : this.itemsOrdered) {
            sb.append(i + 1).append(". ");
        
            if (item instanceof Book) {
                Book bookItem = (Book) item;
                sb.append("Book: ").append(bookItem.getTitle())
                .append(" - ").append(bookItem.getCategory())
                .append(" - ").append(bookItem.getAuthorString())
                .append(" : ").append(bookItem.getCost()).append("$");
            } 
            else if (item instanceof DigitalVideoDisc) {
                DigitalVideoDisc dvdItem = (DigitalVideoDisc) item;
                sb.append("DVD: ").append(dvdItem.getTitle())
                .append(" - ").append(dvdItem.getCategory())
                .append(" - ").append(dvdItem.getDirector())
                .append(" - ").append(dvdItem.getLength())
                .append(" : ").append(dvdItem.getCost()).append("$");
            } 
            else if (item instanceof CompactDisc) {
                CompactDisc cdItem = (CompactDisc) item;
                sb.append("CD: ").append(cdItem.getTitle())
                .append(" - ").append(cdItem.getCategory())
                .append(" - director: ").append(cdItem.getDirector())
                .append(" - artist: ").append(cdItem.getArtist())
                .append(" - ").append(cdItem.getTracks().size()).append(" Tracks")
                .append(" - ").append(cdItem.getLength())
                .append(" : ").append(cdItem.getCost()).append("$");
            }
        
            sb.append("\n"); 
            i++; 
        }
    
        sb.append("Total cost: ").append((new DecimalFormat("0.00")).format(totalCost())).append("$\n");
        sb.append("**************************************************");
    
        System.out.println(sb.toString());
    
    }
    
    // SORT MEDIAA
    public void sortMediaByTitleCost(){
        Collections.sort(this.itemsOrdered, new MediaComparatorByTitleCost());
        System.out.println("Cart items have been sorted by Title then Cost.");
    }
    public void sortMediaByCostTitle(){
        Collections.sort(this.itemsOrdered, new MediaComparatorByCostTitle());
        System.out.println("Cart items have been sorted by Title then Cost.");
    }

    // Search by ID
    public void searchByID(int id) {
        for (Media item : itemsOrdered) {
            if (item.getId() == id) {
                StringBuilder sb = new StringBuilder();
                sb.append("Found item: ");

                if (item instanceof Book) {
                    Book bookItem = (Book) item;
                    sb.append("Book: ").append(bookItem.getTitle())
                      .append(" - ").append(bookItem.getCategory())
                      .append(" - ").append(bookItem.getAuthorString())
                      .append(" : ").append(bookItem.getCost()).append("$");
                } else if (item instanceof DigitalVideoDisc) {
                    DigitalVideoDisc dvdItem = (DigitalVideoDisc) item;
                    sb.append("DVD: ").append(dvdItem.getTitle())
                      .append(" - ").append(dvdItem.getCategory())
                      .append(" - ").append(dvdItem.getDirector())
                      .append(" - ").append(dvdItem.getLength())
                      .append(" : ").append(dvdItem.getCost()).append("$");
                } else if (item instanceof CompactDisc) {
                    CompactDisc cdItem = (CompactDisc) item;
                    sb.append("CD: ").append(cdItem.getTitle())
                      .append(" - ").append(cdItem.getCategory())
                      .append(" - director: ").append(cdItem.getDirector())
                      .append(" - artist: ").append(cdItem.getArtist())
                      .append(" - ").append(cdItem.getTracks().size()).append("Tracks")
                      .append(" - ").append(cdItem.getLength())
                      .append(" : ").append(cdItem.getCost()).append("$");
                }
                
                System.out.println(sb.toString());
                return; 
            }
        }
        System.out.println("No match is found.");
    }
 
    public boolean isMatch(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        return str1.equalsIgnoreCase(str2);
    }

    public Media searchByTitle(String title) {
        for (Media item : itemsOrdered) {
            if (isMatch(title, item.getTitle())) {
                StringBuilder sb = new StringBuilder();
                sb.append("Found Media: ")
                  .append(item.getTitle())
                  .append(" - ")
                  .append(item.getCost()).append("$");
                
                System.out.println(sb.toString());
                return item;
            }
        }
        return null;
    }

    public boolean searchByPrice(float price) {
        boolean matchFound = false;
        for (Media item : itemsOrdered) {
            if (item.getCost() == price) {
                matchFound = true;
                StringBuilder sb = new StringBuilder();
                sb.append("Found item with price ")
                  .append(item.getCost())
                  .append("$ : ")
                  .append(item.getTitle());
                
                System.out.println(sb.toString());
            }
        }
        if (!matchFound) {
             System.out.println("No match is found.");
        }
        return matchFound;
    }

    public void empty(){
        itemsOrdered.clear();
    }

    public String placeOrder() {
        if (itemsOrdered.isEmpty()) {
            return "Your cart is empty";
        } else{
        qtyOrdered = 0;
        this.empty();
        return "Order successfully placed";
        }
    }

}
