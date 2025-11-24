package hust.soict.dsai.aims.media;

import java.util.*;
public class CompactDisc extends Disc implements Playable{
    private String artist;
    private static int nbCD = 0;
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    private List<Track> tracks = new ArrayList<Track>();
    public List<Track> getTracks() {
        return tracks;
    }
    @Override
    public String getType(){
        return "CD";
    }

    public CompactDisc(String title, String category, String director, int length, float cost,String artist, List<Track> tracks) {
        super(title, category, cost, length, director); 
        this.artist = artist;
        this.tracks = tracks;
        this.id = nbCD;
        nbCD++;
    }

    public boolean addTrack(Track track){
        if (this.tracks.contains(track)) {
            System.out.println("The CD already contains this track");
            return false;
        }
        this.tracks.add(track);
        return true;
    }

    public boolean removeTrack(Track track){
        if (this.tracks.contains(track)) {
            this.tracks.remove(track);
            return true;
        }
        System.out.println("The CD does not contain this track");
        return false;
    }

    public int getLength(){
        int length = 0;
        for (Track track : this.tracks) {
            length += track.getLength();
        }
        return length;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Book: ")
        .append(this.getTitle())
        .append(" by ")
        .append(this.getArtist());
        return sb.toString();
    }

    public void play(){
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Number of Tracks: " + String.valueOf(this.tracks.size()));
        for (Track track : this.tracks) {
            track.play();
        }
    }
}
