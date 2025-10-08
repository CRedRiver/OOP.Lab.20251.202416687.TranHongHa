package AimsProject.main_package;

public class Cart {

    private int qtyOrdered;
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = 
        new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        this.qtyOrdered += 1;
        if (this.qtyOrdered > MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
        }

    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        this.qtyOrdered -= 1;
        System.out.println("The disc has been added");
    }
    public float totalCost(){
        float total_cost = 0;
        for (int i = 0; i < MAX_NUMBERS_ORDERED;i++){
            total_cost += itemsOrdered[i].getCost();
        }
        return total_cost;
    }
}
