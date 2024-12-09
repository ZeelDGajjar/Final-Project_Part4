package org.example;
import java.util.*;

/**
 *
 * @author 2474008
 */

public class Library {

    // Data member to store the list of books
    private ArrayList<Book> book;

    /**
     * Default constructor - Creates an empty list of books and adds 5 books.
     */
    public Library() {
        book = new ArrayList<>();

        book.add(new Book());
        book.add(new Book());
        book.add(new Book());
        book.add(new Book());
        book.add(new Book());
    }

    /**
     * Constructor with ArrayList of Book objects - Copies the provided ArrayList into the library.
     * @param book The ArrayList of Book objects to be copied.
     */
    public Library(ArrayList<Book> book){
        this.book = new ArrayList<>(book);
    }

    /**
     * Copy constructor - Creates a copy of the library by copying the books list from another library.
     * @param anotherLibrary The Library to be copied.
     */
    public Library(Library anotherLibrary){
        this.book = new ArrayList<>(anotherLibrary.book);
    }

    /**
     * Searches for books by keyword in title or author.
     * @param Keyword The keyword to search for in the book's title or author.
     * @return A list of books that contain the keyword in the title or author.
     */
    public ArrayList<Book> searchBook(String Keyword){
        ArrayList<Book> searchResult = new ArrayList<>();
        for (Book book : book) {
            if (book.getTitle().toLowerCase().contains(Keyword.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(Keyword.toLowerCase())) {
                searchResult.add(book);
            }
        }
        return searchResult;
    }

    /**
     * Checks if two libraries are equal based on the list of books.
     * @param anotherLibrary The library to compare with.
     * @return True if the libraries have the same list of books, false otherwise.
     */
    public boolean equals(Library anotherLibrary){
        return this.book.equals(anotherLibrary.book);
    }

    /**
     * Returns a string representation of the library and its books.
     * @return A string that lists all the books in the library.
     */
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Book book : this.book) {
            output.append(String.format("%s:\n%s\n\n", "Book", book.toString()));
        }
        return output.toString();
    }

    //Getter for books
    public ArrayList<Book> getBook(){
        return new ArrayList<>(book); // Return a copy to maintain encapsulation
    }

    //Setter for books
    public void setBook(ArrayList<Book> book){
        this.book = new ArrayList<>(book); // Create a copy to prevent external modifications
    }
}
