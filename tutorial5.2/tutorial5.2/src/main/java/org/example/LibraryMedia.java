package org.example;

public class LibraryMedia {
    protected String title;
    protected int publicationYear;
    protected boolean available;

    public LibraryMedia(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.available = true;
    }

    public void borrow() {
        if (available) {
            available = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is already borrowed.");
        }
    }

    public void returnMedia() {
        if (!available) {
            available = true;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " wasn't borrowed.");
        }
    }

    public void displayInformation() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Availability: " + (available ? "Available" : "Borrowed"));
    }
}
