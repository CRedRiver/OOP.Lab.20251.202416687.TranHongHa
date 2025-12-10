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
		Track t1 = new Track("Come Together", 259); tracks1.add(t1);
		Track t2 = new Track("Something", 182); tracks1.add(t2);
		int total1 = t1.getLength() + t2.getLength();
		CompactDisc c1 = new CompactDisc("Abbey Road", "Rock", "George Martin", total1, 11.99f, "The Beatles", tracks1);
		store.addMedia(c1);

		List<Track> tracks2 = new ArrayList<>();
		Track t3 = new Track("Give Life Back to Music", 269); tracks2.add(t3);
		Track t4 = new Track("Get Lucky", 369); tracks2.add(t4);
		int total2 = t3.getLength() + t4.getLength();
		CompactDisc c2 = new CompactDisc("Random Access Memories", "Electronic", "Daft Punk", total2, 12.99f, "Daft Punk", tracks2);
		store.addMedia(c2);

		List<Track> tracks3 = new ArrayList<>();
		Track t5 = new Track("Rain in the Forest", 180); tracks3.add(t5);
		Track t6 = new Track("Ocean Waves", 240); tracks3.add(t6);
		int total3 = t5.getLength() + t6.getLength();
		CompactDisc c3 = new CompactDisc("Nature Soundscapes", "Ambient", "Various", total3, 7.99f, "Nature Label", tracks3);
		store.addMedia(c3);

		// Additional items
		Book b4 = new Book("Design Patterns", "Programming", 39.99f);
		b4.addAuthor("Erich Gamma");
		b4.addAuthor("Richard Helm");
		b4.addAuthor("Ralph Johnson");
		b4.addAuthor("John Vlissides");
		store.addMedia(b4);

		Book b5 = new Book("Refactoring: Improving the Design of Existing Code", "Programming", 45.00f);
		b5.addAuthor("Martin Fowler");
		store.addMedia(b5);

		DigitalVideoDisc d5 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 13.99f);
		store.addMedia(d5);

		DigitalVideoDisc d6 = new DigitalVideoDisc("Spirited Away", "Animation", "Hayao Miyazaki", 125, 15.50f);
		store.addMedia(d6);

		DigitalVideoDisc d7 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 14.50f);
		store.addMedia(d7);

		DigitalVideoDisc d8 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 81, 9.99f);
		store.addMedia(d8);

		DigitalVideoDisc d9 = new DigitalVideoDisc("Avatar", "Sci-Fi", "James Cameron", 162, 17.99f);
		store.addMedia(d9);

		List<Track> tracks4 = new ArrayList<>();
		Track tt1 = new Track("Billie Jean",294); tracks4.add(tt1);
		Track tt2 = new Track("Beat It",258); tracks4.add(tt2);
		int total4 = tt1.getLength() + tt2.getLength();
		CompactDisc c4 = new CompactDisc("Thriller", "Pop", "Quincy Jones", total4, 13.99f, "Michael Jackson", tracks4);
		store.addMedia(c4);

		List<Track> tracks5 = new ArrayList<>();
		Track tt3 = new Track("Back in Black", 255); tracks5.add(tt3);
		Track tt4 = new Track("You Shook Me All Night Long", 210); tracks5.add(tt4);
		int total5 = tt3.getLength() + tt4.getLength();
		CompactDisc c5 = new CompactDisc("Back in Black", "Rock", "Robert John " + "Lange", total5, 11.50f, "AC/DC", tracks5);
		store.addMedia(c5);

		List<Track> tracks6 = new ArrayList<>();
		Track tt5 = new Track("So What", 545); tracks6.add(tt5);
		Track tt6 = new Track("Freddie Freeloader", 620); tracks6.add(tt6);
		int total6 = tt5.getLength() + tt6.getLength();
		CompactDisc c6 = new CompactDisc("Kind of Blue", "Jazz", "Columbia", total6, 10.99f, "Miles Davis", tracks6);
		store.addMedia(c6);

		return store;
	}

	public static void main(String[] args) {
		Store store = createStore();
		store.print();
	}
}
