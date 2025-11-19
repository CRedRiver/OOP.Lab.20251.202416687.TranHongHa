package hust.soict.dsai.aims.media;
public class DigitalVideoDisc extends Disc{
    private static int nbDigitalVideoDisc = 0;


    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        
        super(title, category, cost, length, director); 
        

        nbDigitalVideoDisc += 1;
        this.id = nbDigitalVideoDisc; 

    }

    public void printInfo() {
        System.out.println("DVD: " + title + " (" + category + ")");
        System.out.println("Director: " + director + ", Length: " + length + " min, Cost: $" + cost);
    }
}
