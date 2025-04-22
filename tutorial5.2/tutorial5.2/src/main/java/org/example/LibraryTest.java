package org.example;

import org.example.Book;
import org.example.Movie;
import org.example.LibraryMedia;


public class LibraryTest {
    public static void main(String[] args) {
        // Correct instantiation of Book and Movie objects
        Book book1 = new Book("The Witcher", 1990, "Andrzej Sapkowski", 320);
        Book book2 = new Book("Java Programming", 2000, "Herbert Schildt", 600);
        Movie movie1 = new Movie("The Green Mile", 1999, "Frank Darabont", 189);
        Movie movie2 = new Movie("Inception", 2010, "Christopher Nolan", 148);

        // Storing objects in the LibraryMedia array
        LibraryMedia[] mediaArray = new LibraryMedia[4];
        mediaArray[0] = book1;
        mediaArray[1] = book2;
        mediaArray[2] = movie1;
        mediaArray[3] = movie2;

        // Displaying information for each media
        System.out.println("===== INFORMATION ABOUT ALL MEDIA =====");
        for (LibraryMedia media : mediaArray) {
            media.displayInformation();
            System.out.println("--------------------");
        }

        // Borrowing and returning operations
        System.out.println("\n===== BORROWING AND RETURNING OPERATIONS =====");
        book1.borrow();
        book1.borrow(); // Trying to borrow again
        book1.returnMedia();

        // Calling type-specific methods
        System.out.println("\n===== TYPE-SPECIFIC METHODS =====");
        book1.checkNumberOfPages();
        movie1.checkDuration();

        // Demonstrating casting to call type-specific methods via base class reference
        System.out.println("\n===== TYPE CASTING =====");
        for (LibraryMedia media : mediaArray) {
            if (media instanceof Book) {
                Book b = (Book) media;
                b.checkNumberOfPages();
            } else if (media instanceof Movie) {
                Movie m = (Movie) media;
                m.checkDuration();
            }
        }
    }
}