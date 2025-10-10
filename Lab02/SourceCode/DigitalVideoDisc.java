package SourceCode;
public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private String ID;
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public int getLength() {
        return length;
    }
    public float getCost() {
        return cost;
    }
    public String getID() {
        return ID;
    }

    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    public DigitalVideoDisc(String category, boolean isCategory) {
        this.category = category;
    }

    public DigitalVideoDisc(String title, String category, String director, int length,
    float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.ID = generateID();
    }

    private String generateID() {
        return "" + title.hashCode();
    }
    public void printInfo() {
        System.out.println("DVD: " + title + " (" + category + ")");
        System.out.println("Director: " + director + ", Length: " + length + " min, Cost: $" + cost);
    }
}
