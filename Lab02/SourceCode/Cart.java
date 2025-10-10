package SourceCode;
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

    public void showCart() {
        System.out.println("Cart DVDs:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].getTitle() + " - $" + itemsOrdered[i].getCost());
        }
    System.out.println("Total cost: $" + totalCost());
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

}
