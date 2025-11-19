import java.util.*;

public class Book {
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();
    private static int nbBook = 0;

    public Book(int id, String title, float cost, List<String> authors) {
        nbBook += 1;
        this.id = nbBook;
        this.title = title;
        this.cost = cost;
        this.authors = authors;
    }
}
