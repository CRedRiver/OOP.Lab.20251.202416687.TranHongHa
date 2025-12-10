package hust.soict.dsai.comparator;

import java.util.Comparator;
import hust.soict.dsai.aims.media.Media;

public class MediaComparatorByCostTitle implements Comparator<Media>{

    @Override
    public int compare(Media item1, Media item2){

        return Comparator.comparing(Media::getCost)
                        .thenComparing(Media::getTitle)
                        .compare(item1, item2);
    }   
}
