package hust.soict.dsai.lab02.SourceCode;

public class DigitalVideoDisc {
    private String title = null;
    private String category = null;
    private String director = null;
    private int length = 0;
    private float cost = 0;
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
        if (category == null) {
            return "Unknown";
        }
        return category;
    }
    public String getDirector() {
        if (director == null) {
            return "Unknown";
        }
        return director;
    }
    public int getLength() {
        return length;
    }
    public float getCost() {
        return cost;
    }
    public int getID() {
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
