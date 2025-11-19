package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Disney", 90, 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 29.99f);
        anOrder.addDigitalVideoDisc(dvd4);

        DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Matrix", "Action", "Wachowski Sisters", 136, 22.50f);
        anOrder.addDigitalVideoDisc(dvd5);

        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Interstellar", "Sci-Fi", "Christopher Nolan", 169, 27.99f);
        anOrder.addDigitalVideoDisc(dvd6);
        
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("Spirited Away", "Animation", "Hayao Miyazaki", 125, 24.99f);
        anOrder.addDigitalVideoDisc(dvd7);

        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
        anOrder.print();
    }
}
