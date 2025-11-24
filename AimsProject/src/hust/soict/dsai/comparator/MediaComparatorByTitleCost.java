package hust.soict.dsai.comparator;

import java.util.Comparator;

import hust.soict.dsai.aims.media.Media;

public class MediaComparatorByTitleCost implements Comparator<Media>{

    @Override
    public int compare(Media item1, Media item2){

        return Comparator.comparing(Media::getTitle)
                        .thenComparing(Media::getCost)
                        .compare(item1, item2);
    }  
}
