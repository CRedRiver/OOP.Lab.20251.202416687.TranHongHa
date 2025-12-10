package hust.soict.dsai.aims.media;
public class DigitalVideoDisc extends Disc implements Playable{
    private static int nbDigitalVideoDisc = 0;

    @Override
    public String getType(){
        return "DVD";
    }
    public DigitalVideoDisc(String title){
        super(title);
    }
    public DigitalVideoDisc(String title, String category, String director, 
        int length, float cost) {     
        super(title, category, cost, length, director); 
        this.id = nbDigitalVideoDisc;
        nbDigitalVideoDisc += 1; 

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("DVD: ")
        .append(this.getTitle())
        .append(" - ")
        .append(this.getCategory())
        .append(" - director: ")
        .append(this.getDirector());
        return sb.toString();
    }

    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
