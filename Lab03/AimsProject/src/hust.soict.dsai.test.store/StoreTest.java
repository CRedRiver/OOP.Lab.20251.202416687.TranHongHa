package src;

public class StoreTest {
    Store store = new Store();
    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
        "Animation", "Roger Allers", 87, 19.95f);
    store.addDVD(dvd1);

    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
        "Science Fiction", "George Lucas", 87, 24.95f);
    cart.addDVD(dvd2);

    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
    "Animation","Disney", 90, 18.99f);
    cart.addDVD(dvd3);

    store.print();
}