package hust.soict.dsai.aims.media;

public class Disc extends Media{
    protected int length;
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    protected String director;
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public Disc(String title, String category, float cost, int length, String director) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }
}
