package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBERS_STORE = 100;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_NUMBERS_STORE];
    private int qtyItems = 0;

    public void addDVD(DigitalVideoDisc disc){
        if (qtyItems >= MAX_NUMBERS_STORE) {
            System.out.println("The store is full");
            return;
        }
        itemsInStore[qtyItems++] = disc;
    }

    public void removeDVD(DigitalVideoDisc disc){
        for (int i = 0; i < qtyItems; i++) {
            if (itemsInStore[i] != null && itemsInStore[i].getId() == disc.getId()) {
                for (int j = i; j < qtyItems - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyItems - 1] = null;
                qtyItems--;
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("No match is found.");
    }

    public void print() {
        System.out.println("***********************STORE***********************");
        for (int i = 0; i < qtyItems; i++) {
            System.out.println((i + 1) + ". " + "DVD " + itemsInStore[i].getTitle() 
            + " - " + itemsInStore[i].getCategory() 
            + " - " + itemsInStore[i].getDirector() 
            + " - " + itemsInStore[i].getLength() + ":" 
            + itemsInStore[i].getCost() + "$");
        }
        System.out.println("***************************************************");
    }

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
        for (int i = 0; i < qtyItems; i++) {
            if (isMatch(title, itemsInStore[i].getTitle())) {
                System.out.println("Found DVD: " + itemsInStore[i].getTitle() + " - $" + itemsInStore[i].getCost());
                return true;
            }
        }
        System.out.println("No match is found.");
        return false;
    }

    public void searchByID(int id){
        for (int i = 0; i < qtyItems; i++) {
            if (itemsInStore[i] != null && itemsInStore[i].getId() == id) {
                System.out.println("Found DVD: " + itemsInStore[i].getTitle() + " - $" + itemsInStore[i].getCost());
                return;
            }
        }
        System.out.println("No match is found.");
    }

    public boolean searchByPrice(float price){
        boolean check = false;
        for (int i = 0; i < qtyItems; i++){
            if (itemsInStore[i].getCost() == price){
                check = true;
                System.out.println("Found DVD with price " + itemsInStore[i].getCost() + " $ : " + itemsInStore[i].getTitle());
            }
        }
        return check;
    }
}
