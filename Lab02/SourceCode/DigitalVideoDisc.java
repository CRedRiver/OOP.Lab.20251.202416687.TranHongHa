package SourceCode;
public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int ID;
    private static int nbDigitalVideoDisc = 0;
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
        nbDigitalVideoDisc += 1;
        this.ID = nbDigitalVideoDisc;
        this.title = title;
    }

    public DigitalVideoDisc(String category, boolean isCategory) {
        nbDigitalVideoDisc += 1;
        this.ID = nbDigitalVideoDisc;
        this.category = category;
    }

    public DigitalVideoDisc(String title, String category, String director, int length,
    float cost) {
        nbDigitalVideoDisc += 1;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.ID = nbDigitalVideoDisc;
    }

    public void printInfo() {
        System.out.println("DVD: " + title + " (" + category + ")");
        System.out.println("Director: " + director + ", Length: " + length + " min, Cost: $" + cost);
    }
}
