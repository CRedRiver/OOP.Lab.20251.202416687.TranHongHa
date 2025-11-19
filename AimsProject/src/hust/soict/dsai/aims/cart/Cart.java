package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {

    private int qtyOrdered;
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = 
        new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
            return;
        }
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] discs) {
        for (DigitalVideoDisc disc : discs) {
            if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is almost full");
                return;
            }
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2){
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc1;
            qtyOrdered++;
        }
        else{System.out.println("The cart is almost full");return;}
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc2;
            qtyOrdered++;
        }
        else{System.out.println("The cart is almost full");return;}
    }

    // Remove a DVD from the cart
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null && itemsOrdered[i].getID()==(disc.getID())) {
                this.qtyOrdered -= 1;
                for (int j = i; j < qtyOrdered; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                System.out.println("The disc has been removed");
                break;
            }
        }
    }
    public float totalCost() {
        float total_cost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total_cost += itemsOrdered[i].getCost();
        }
        return total_cost;
    }
    // Print out Cart items
    public void print() {
        System.out.println("***********************CART***********************");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + "DVD " + itemsOrdered[i].getTitle() 
            + " - " + itemsOrdered[i].getCategory() 
            + " - " + itemsOrdered[i].getDirector() 
            + " - " + itemsOrdered[i].getLength() + ":" 
            + itemsOrdered[i].getCost() + "$");
        }
        System.out.println("Total cost:" + totalCost() + "$");
        System.out.println("**************************************************");
    }

    public void sortDVDs(String sort_by){
        if (sort_by.equals("title")){
            for (int i = 0; i < qtyOrdered - 1; i++) {
                for (int j = i + 1; j < qtyOrdered; j++) {
                    if (itemsOrdered[i].getTitle().compareTo(itemsOrdered[j].getTitle()) > 0) {
                        DigitalVideoDisc temp = itemsOrdered[i];
                        itemsOrdered[i] = itemsOrdered[j];
                        itemsOrdered[j] = temp;
                    }
                }
            }
        } else if (sort_by.equals("cost")) {
            for (int i = 0; i < qtyOrdered - 1; i++) {
                for (int j = i + 1; j < qtyOrdered; j++) {
                    if (itemsOrdered[i].getCost() > itemsOrdered[j].getCost()) {
                        DigitalVideoDisc temp = itemsOrdered[i];
                        itemsOrdered[i] = itemsOrdered[j];
                        itemsOrdered[j] = temp;
                    }
                }
            }
        } 
        else {
            System.out.println("Invalid sort option");
            return;
        }
    }
    //Swap two DVDs in the cart
    public void swap(DigitalVideoDisc disc1, DigitalVideoDisc disc2){
        String oldTitle = disc1.getTitle();
        disc1.setTitle(disc2.getTitle());
        disc2.setTitle(oldTitle);

        String tmpCategory = disc1.getCategory();
        disc1.setCategory(disc2.getCategory());
        disc2.setCategory(tmpCategory);
    }
    //Search by ID
    public void searchByID(int id){
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null && itemsOrdered[i].getID() == id) {
                System.out.println("Found DVD: " + itemsOrdered[i].getTitle() + " - $" + itemsOrdered[i].getCost());
                return;
            }
        }
        System.out.println("No match is found.");
    }
    //Search by Title
    public boolean isMatch(String str1, String str2){
        if (str1 == null || str2 == null) {
            return false;
        }
        else if (str1.equalsIgnoreCase(str2)){
            return true;
        }
        return false;
    }
    public boolean searchByTitle(String title){
        for (int i = 0; i < qtyOrdered; i++) {
            if (isMatch(title, itemsOrdered[i].getTitle())) {
                System.out.println("Found DVD: " + itemsOrdered[i].getTitle() + " - $" + itemsOrdered[i].getCost());
                return true;
            }
        }
        System.out.println("No match is found.");
        return false;
    }

    public boolean searchByPrice(float price){
        boolean check = false;
        for (int i = 0; i < qtyOrdered; i++){
            if (itemsOrdered[i].getCost() == price){
                check = true;
                System.out.println("Found DVD with price " + itemsOrdered[i].getCost() + " $ : " + itemsOrdered[i].getTitle());
            }
        }
        return check;
    }
}
