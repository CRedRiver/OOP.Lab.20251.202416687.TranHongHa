package hust.soict.dsai.aims;

import hust.soict.dsai.aims.store.Store;
import javafx.collections.ObservableList;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aims {
    private static ArrayList<Cart> orderList = new ArrayList<Cart>();
    private static Cart currentCart = new Cart();
    private static Store localStore = new Store();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Dummy data
        Book book1 = new Book("iPhone 12 User Manual", "Electronics", 9.99f);
        book1.addAuthor("Apple Inc.");
        localStore.addMedia(book1);

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Tesla Model 3 Review", "Automotive", "MotorTrend", 15, 4.99f);
        localStore.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("How to Brew the Perfect Coffee", "Lifestyle", "BaristaPro", 42, 12.99f);
        localStore.addMedia(dvd2);

        List<Track> natureTracks = new ArrayList<>();
        Track t1 = new Track("Rain in the Forest", 180);
        Track t2 = new Track("Ocean Waves", 240);
        Track t3 = new Track("Birdsong Morning",150);
        natureTracks.add(t1); natureTracks.add(t2); natureTracks.add(t3);
        int totalLength = t1.getLength() + t2.getLength() + t3.getLength();
        CompactDisc cd1 = new CompactDisc("Nature Soundscapes", "Ambient", "Various", totalLength, 7.99f, "Nature Label", natureTracks);
        localStore.addMedia(cd1);

        boolean running = true;
        while (running) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    storeMenu();
                    break;
                case "2":
                    updateStoreMenu();
                    break;
                case "3":
                    currentCart.print();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
            System.out.println();
        }
        System.out.println("Exiting Application.");
    }

    private static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }
// --------------------STORE MENU--------------------------------
    private static void storeMenu() {
        boolean inStoreMenu = true;
        while (inStoreMenu) {
            localStore.print();
            System.out.println("STORE MENU: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media\'s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    boolean check = seeMediaDetails();
                    if (check) break;
                    System.out.println("Media not found in store");
                    System.out.println();
                    break;
                case "2":
                    boolean check1 = addMediaToCart();
                    if (check1) break;
                    System.out.println("Media not found in store");
                    System.out.println();
                    break;
                case "3":
                    System.out.println("Enter the media's title");
                    String title = scanner.nextLine();
                    boolean check2 = playMedia(localStore.searchByTitle(title));
                    if (check2) break;
                    System.out.println("Media not found in store");
                    System.out.println();
                    break;
                case "4":
                    currentCart.print();
                    cartMenu();
                    break;
                case "0":
                    inStoreMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
            System.out.println();
        }
    }

    private static boolean seeMediaDetails() {
        System.out.println("Enter the media's title");
        String title = scanner.nextLine();
        Media item = localStore.searchByTitle(title);
        if (item != null){
            System.out.println(item.toString());
            mediaDetailsMenu(item);
            return true;
        }
        return false;
    }

    private static boolean addMediaToCart() {
        System.out.println("Enter the media's title");
        String title1 = scanner.nextLine();
        Media item1 = localStore.searchByTitle(title1);
        if (item1 != null){
            currentCart.addMedia(item1);
            System.out.println("Added " + item1.getTitle() + " to current cart");
            return true;
        }
        return false;
    }

    private static boolean playMedia(Media item) {
        if (item != null){
            System.out.println(item.toString());
            // Use Playable interface
            if (item instanceof Playable) {
                ((Playable) item).play();
            } else {
                System.out.println("Cannot play this media");
            }
            return true;
        }
        return false;
    }
// -----------------------MEDIA MENU---------------------------
    private static void mediaDetailsMenu(Media item) {
        boolean inMediaMenu = true;
        while (inMediaMenu) {
            System.out.println("MEDIA DETAILS: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    currentCart.addMedia(item);
                    System.out.println("Added " + item.getTitle() + " to current cart");
                    break;
                case "2":
                    if (item instanceof Playable) {
                        ((Playable) item).play();
                    } else {
                        System.out.println("Cannot play this media");
                    }
                    break;
                case "0":
                    inMediaMenu = false;
                    break;
            }
        }
    }

    private static void updateStoreMenu() {
        boolean isUpdating = true;
        while (isUpdating) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media");
            System.out.println("2. Remove a media");
            System.out.println("3. Sort store by title");
            System.out.println("4. Sort store by cost");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addMediaToStore();
                    break;
                case "2":
                    removeMediaFromStore();
                    break;
                case "3":
                    localStore.sortMediaByTitleCost();
                    break;
                case "4":
                    localStore.sortMediaByCostTitle();
                    break;
                case "0":
                    isUpdating = false;
                    break;
            }
        }
        
    }

    private static void addMediaToStore() {
        System.out.println("Enter new media details: ");
        System.out.println("Title ");
        String title = scanner.nextLine();
        System.out.println("Category ");
        String cat = scanner.nextLine();
        System.out.println("Cost");
        float cost = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Choose type: Book - DVD - CD");
        String type = scanner.nextLine();
        switch (type) {
            case "Book":
                Book newItemB = new Book(title, cat, cost);
                localStore.addMedia((Media) newItemB);
                break;
            case "DVD":
                System.out.println("Director ");
                String dir = scanner.nextLine();
                System.out.println("Length");
                int len = scanner.nextInt();
                DigitalVideoDisc newItemD = new 
                DigitalVideoDisc(title, cat, dir, len, cost);
                localStore.addMedia((Media) newItemD);
                break;
            case "CD":
                System.out.println("Director ");
                String dirC = scanner.nextLine();
                System.out.println("Artist ");
                String artist = scanner.nextLine();
                System.out.println("Length");
                int lenC = scanner.nextInt();
                ArrayList<Track> tracks = new ArrayList<Track>();
                CompactDisc newItemC = new 
                CompactDisc(title, cat, dirC, lenC, cost, artist, tracks);
                localStore.addMedia((Media) newItemC);
                break;
            default:
                System.out.println("Invalid media type.");
        }
    }

    private static void removeMediaFromStore() {
        localStore.print();
        System.out.println("Enter media index: ");
        int index = scanner.nextInt();
        Media item = localStore.searchByIndexOnStoreMenu(index);
        if (item != null) {
            localStore.removeMedia(item);
        }
        return;
    }
// ------------------------CART MENU ---------------------------------
    private static void cartMenu() {
        boolean inCartMenu = true;
        while (inCartMenu) {
            System.out.println("CART MENU");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    filterCart();
                    break;
                case "2":
                    System.out.println("Sort by: Title - Cost");
                    String sortBy = scanner.nextLine();
                    switch(sortBy) {
                        case "Title":
                            currentCart.sortMediaByTitleCost();
                        case "Cost":
                            currentCart.sortMediaByCostTitle();
                        default:
                            System.out.println("Invalid choice");
                    }
                    break;
                case "3":
                    System.out.println("Enter media title: ");
                    String title = scanner.nextLine();
                    removeMediaInCart(title);
                    break;
                case "4":
                    System.out.println("Enter media title: ");
                    String title1 = scanner.nextLine();
                    playMedia(currentCart.searchByTitle(title1));
                    break;
                case "5":
                    placeOrder();
                    break;
                case "0":
                    inCartMenu = false;
                    break;
            }
        }
    }

    private static void filterCart() {
        System.out.println("Filter by: ID - Title");
        String filBy = scanner.nextLine();
        switch(filBy) {
                case "ID":
                    System.out.println("Min: ");
                    int minId = scanner.nextInt();
                    System.out.println("Max: ");
                    int maxId = scanner.nextInt();
                    filterMediaInCartById(minId, maxId);
                case "Title":
                    System.out.println("Enter your keyword:");
                    String keyword = scanner.nextLine();
                    filterMediaInCartByTitle(keyword);
                default:
                    System.out.println("Invalid choice");
        }
    }

    private static void filterMediaInCartById(int minId, int maxId) {
        ObservableList<Media> list = currentCart.getItemsOrdered();
        Cart tempCart = new Cart();
        for (Media item : list) {
            if ((item.getId() >= minId) && (item.getId() <= maxId)) {
                tempCart.addMedia(item);
            }
        }
        System.out.println("Filtered Cart with Medias in chosen Id range:");
        tempCart.print();
    }

    private static void filterMediaInCartByTitle(String keyword) {
        ObservableList<Media> list = currentCart.getItemsOrdered();
        Cart tempCart = new Cart();
        for (Media item : list) {
            if (item.getTitle().contains(keyword)) {
                tempCart.addMedia(item);
            }
        }
        System.out.println("Filtered Cart with Medias " + keyword);
        tempCart.print();
    }

    private static void removeMediaInCart(String title) {
        ObservableList<Media> list = currentCart.getItemsOrdered();
        for (Media item : list) {
            if (item.getTitle().equals(title)) {
                currentCart.removeMedia(item);
                break;
            }
        }
    }

    public static void placeOrder() {
        if (currentCart.getQtyOrdered() == 0) {
            System.out.println("You have not ordered anything");
            return;
        }
        System.out.println("Order is sucessfully created!");
        orderList.add(currentCart);
        currentCart.empty();
    }
}
