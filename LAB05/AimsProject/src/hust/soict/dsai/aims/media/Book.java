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

    public List<String> getAuthors() {
        return authors;
    }

    public String getAuthorString(){
        List<String> authors = getAuthors();
        StringBuilder result = new StringBuilder();
        for (String author : authors){
            if (authors.indexOf(author) == authors.size() - 1){
                result.append(author);
                break;
            }
            result.append(author).append(", ");
        }
        return result.toString();
    }

    public boolean addAuthor(String authorName){
        if (this.authors.contains(authorName)){
            System.out.println("Author is already on the list");
            return false;
        }
        this.authors.add(authorName);
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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Book: ")
        .append(this.getTitle())
        .append(" by ")
        .append(this.getAuthorString());
        return sb.toString();
    }
}
