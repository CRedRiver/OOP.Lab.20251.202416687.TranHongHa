package hust.soict.dsai.aims.media;

import java.util.*;
public class Book extends Media{
    private List<String> authors = new ArrayList<String>();
    private static int nbBook = 0;

    public Book(String title, String category, float cost) {
        super(title, category, cost);
        this.id = nbBook;
        nbBook += 1;
        
    }

    public boolean addAuthor(String authorName){
        if (this.authors.contains(authorName)){
            System.out.println("Author is already on the list");
            return false;
        }
        this.authors.add(this.id, authorName);
        return true;
    }
    public boolean removeAuthor(String authorName){
        if (this.authors.contains(authorName)){
            this.authors.remove(authorName);
            return true;
        }
        System.out.println("Author is not on the list");
        return false;
    }
}
