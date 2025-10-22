package src;

public class Store {
    private DigitalVideoDisc[] itemsInStore;
    private static qtyItems = 0;
    public void addDVD(DigitalVideoDisc disc){
        this.qtyItems ++;
        itemsInStore[dtyItems] = disc;    
    }
    public void removeDVD(DigitalVideoDisc disc){
        for (disc : itemsInStore){
            for (int i = 0; i < qtyItems; i++) {
            if (itemsInStore[i] != null && itemsInStore[i].getID()==(disc.getID())) {
                this.qtyItems -= 1;
                for (int j = i; j < qtyOrdered; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                System.out.println("The disc has been removed");
                break;
            }
        }
        }
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
}
