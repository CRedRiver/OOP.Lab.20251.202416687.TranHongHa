package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.comparator.MediaComparatorByCostTitle;
import hust.soict.dsai.comparator.MediaComparatorByTitleCost;

import java.util.ArrayList;
import java.util.Collections;


public class Store {
    public static final int MAX_NUMBERS_STORE = 100;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    private int qtyItems = 0;

    public void addMedia(Media item){
        if (qtyItems >= MAX_NUMBERS_STORE) {
            System.out.println("The store is full");
            return;
        }
        System.out.println("Added Media " + item.getTitle());
        itemsInStore.add(item);
        qtyItems++;
    }

    public boolean removeMedia(Media item){
        if (this.itemsInStore.contains(item)){
            System.out.println("Deleted Media " + item.getTitle());
            this.itemsInStore.remove(item);
            this.qtyItems -= 1;
            return true;
        }
        return false;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
    
        sb.append("***********************STORE***********************\n");
    
        int i = 0;
        for (Media item : this.itemsInStore) {
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

        sb.append("**************************************************");
        System.out.println(sb.toString());
    }

    // SORT MEDIAA
    public void sortMediaByTitleCost(){
        Collections.sort(this.itemsInStore, new MediaComparatorByTitleCost());
        System.out.println("Items have been sorted by Title then Cost.");
    }
    public void sortMediaByCostTitle(){
        Collections.sort(this.itemsInStore, new MediaComparatorByCostTitle());
        System.out.println("Items have been sorted by Title then Cost.");
    }


    // Search by ID
    public void searchByID(int id) {
        for (Media item : itemsInStore) {
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
                      .append(" - ").append(cdItem.getTracks().size()).append(" Tracks")
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
        for (Media item : itemsInStore) {
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
        for (Media item : itemsInStore) {
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

    public Media searchByIndexOnStoreMenu(int index) {
        if (itemsInStore.isEmpty()) {
            System.out.println("Store is empty");
            return null;
        }
        for (Media item : itemsInStore) {
            if (itemsInStore.indexOf(item) == index) {
                return item;
            }
        }
        System.out.println("Cannot find the Media");
        return null;
    }
}
