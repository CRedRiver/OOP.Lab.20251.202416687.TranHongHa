package hust.soict.dsai.aims.media;
public class DigitalVideoDisc extends Disc{
    private static int nbDigitalVideoDisc = 0;


    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        // Call the Disc constructor (which calls the Media constructor)
        super(title, category, cost, length, director); 
        
        // Then, handle the ID generation unique to DVD
        nbDigitalVideoDisc += 1;
        this.id = nbDigitalVideoDisc; 

    }

    public void printInfo() {
        System.out.println("DVD: " + title + " (" + category + ")");
        System.out.println("Director: " + director + ", Length: " + length + " min, Cost: $" + cost);
    }
}
