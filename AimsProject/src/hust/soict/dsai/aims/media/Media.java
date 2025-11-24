package hust.soict.dsai.aims.media;

import java.util.Comparator;

import hust.soict.dsai.comparator.MediaComparatorByCostTitle;
import hust.soict.dsai.comparator.MediaComparatorByTitleCost;

public class Media implements Comparable<Media> {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = 
                        new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = 
                        new MediaComparatorByCostTitle();

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public String getType(){
        return "Media";
    }
    @Override
    public boolean equals(Object o){
        if (o == null || !(o instanceof Media)) {
            return false;
        }
        return ((Media) o).getTitle().equals(this.getTitle());
    }
    public Media(String title){
        this.title = title;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Media other){
        int titleDiff = this.getTitle().compareTo(other.getTitle());
        if (titleDiff != 0) return titleDiff;

        if (this instanceof DigitalVideoDisc && other instanceof DigitalVideoDisc) {
            DigitalVideoDisc d1 = (DigitalVideoDisc) this;
            DigitalVideoDisc d2 = (DigitalVideoDisc) other;
            int lenDiff = Integer.compare(d2.getLength(), d1.getLength()); // decreasing
            if (lenDiff != 0) return lenDiff;
        }

        return Float.compare(this.getCost(), other.getCost());
    }
}


