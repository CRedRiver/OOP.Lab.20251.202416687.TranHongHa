package hust.soict.dsai.aims.media;

import java.util.*;
public class CompactDisc extends Disc{
    private String artist;
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title, String category, String director, int length, float cost,String artist, List<Track> tracks) {
        super(title, category, cost, length, director); 
        this.artist = artist;
        this.tracks = tracks;
    }
}
