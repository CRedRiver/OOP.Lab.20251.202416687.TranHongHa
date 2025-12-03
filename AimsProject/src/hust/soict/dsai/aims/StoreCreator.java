package hust.soict.dsai.aims;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;

import java.util.ArrayList;
import java.util.List;

public class StoreCreator {

	public static Store createStore() {
		Store store = new Store();

		// Books
		Book b1 = new Book("Clean Code", "Programming", 29.99f);
		b1.addAuthor("Robert C. Martin");
		store.addMedia(b1);

		Book b2 = new Book("Effective Java", "Programming", 34.99f);
		b2.addAuthor("Joshua Bloch");
		store.addMedia(b2);

		Book b3 = new Book("The Pragmatic Programmer", "Programming", 27.50f);
		b3.addAuthor("Andrew Hunt");
		b3.addAuthor("David Thomas");
		store.addMedia(b3);

		// DVDs
		DigitalVideoDisc d1 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 14.99f);
		store.addMedia(d1);

		DigitalVideoDisc d2 = new DigitalVideoDisc("The Matrix", "Sci-Fi", "Wachowski", 136, 12.99f);
		store.addMedia(d2);

		DigitalVideoDisc d3 = new DigitalVideoDisc("Interstellar", "Sci-Fi", "Christopher Nolan", 169, 16.99f);
		store.addMedia(d3);

		DigitalVideoDisc d4 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 19.99f);
		store.addMedia(d4);

		// CDs
		List<Track> tracks1 = new ArrayList<>();
		Track t1 = new Track(); t1.setTitle("Come Together"); t1.setLength(259); tracks1.add(t1);
		Track t2 = new Track(); t2.setTitle("Something"); t2.setLength(182); tracks1.add(t2);
		int total1 = t1.getLength() + t2.getLength();
		CompactDisc c1 = new CompactDisc("Abbey Road", "Rock", "George Martin", total1, 11.99f, "The Beatles", tracks1);
		store.addMedia(c1);

		List<Track> tracks2 = new ArrayList<>();
		Track t3 = new Track(); t3.setTitle("Give Life Back to Music"); t3.setLength(269); tracks2.add(t3);
		Track t4 = new Track(); t4.setTitle("Get Lucky"); t4.setLength(369); tracks2.add(t4);
		int total2 = t3.getLength() + t4.getLength();
		CompactDisc c2 = new CompactDisc("Random Access Memories", "Electronic", "Daft Punk", total2, 12.99f, "Daft Punk", tracks2);
		store.addMedia(c2);

		List<Track> tracks3 = new ArrayList<>();
		Track t5 = new Track(); t5.setTitle("Rain in the Forest"); t5.setLength(180); tracks3.add(t5);
		Track t6 = new Track(); t6.setTitle("Ocean Waves"); t6.setLength(240); tracks3.add(t6);
		int total3 = t5.getLength() + t6.getLength();
		CompactDisc c3 = new CompactDisc("Nature Soundscapes", "Ambient", "Various", total3, 7.99f, "Nature Label", tracks3);
		store.addMedia(c3);

		return store;
	}

	public static void main(String[] args) {
		Store store = createStore();
		store.print();
	}
}
