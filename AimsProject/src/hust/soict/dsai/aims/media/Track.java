package hust.soict.dsai.aims.media;

public class Track implements Playable{
    private int length;
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    private String title;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    @Override
    public boolean equals(Object o){
        if (o == null || !(o instanceof Track)) {
            return false;
        }
        return (((Track) o).getTitle().equals(this.getTitle()) 
        && ((Track) o).getLength() == this.getLength());
    }
    
    public void play(){
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
}
